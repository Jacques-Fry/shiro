package com.jacques.shiro.shiro.realm;

import com.alibaba.fastjson.JSONObject;
import com.jacques.shiro.handler.CommonException;
import com.jacques.shiro.pojo.User;
import com.jacques.shiro.service.PermissionService;
import com.jacques.shiro.service.RoleService;
import com.jacques.shiro.service.UserService;
import com.jacques.shiro.utils.WebStatus;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;

/**
 * 自定义realms对象
 * 继承AuthorizingRealm
 * 重写方法
 * doGetAuthorizationInfo：授权
 * 获取到用户的授权数据（用户的权限数据）
 * doGetAuthenticationInfo：认证
 * 根据用户名密码登录，将用户数据保存（安全数据）
 */
public class PermissionRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    /**
     * 自定义realm名称
     */
    public void setName(String name) {
        super.setName("permissionRealm");
    }

    //授权:授权的主要目的就是根据认证数据获取到用户的权限信息

    /**
     * principalCollection：包含了所有已认证的安全数据
     * AuthorizationInfoInfo：授权数据
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权方法");
        //1.获取安全数据
        User user = (User) principalCollection.getPrimaryPrincipal();

        //2.根据id或者名称查询用户
        user = userService.findById(user.getId());
        if (user == null) {
            throw new CommonException(WebStatus.ERROR, "账号数据不存在");
        }
        if ("1".equals(user.getStatus())) {
            throw new CommonException(WebStatus.FREEZE, "您的账号已被冻结");
        }
        Integer roleId = user.getRoleId();

        //3.查询用户的角色和权限信息
        //4.构造返回用户得权限信息(所有角色,所有权限)
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if (roleId != 0) {
            //所有角色
            HashSet<String> roles = roleService.findById(roleId);
            //所有权限
            HashSet<String> perms = permissionService.findByRoleId(roleId);

            //设置角色集合
            info.setRoles(roles);
            //设置权限集合
            info.setStringPermissions(perms);
        }
        return info;
    }

    //认证：认证的主要目的，比较用户名和密码是否与数据库中的一致
    //将安全数据存入到shiro进行保管
    //参数：authenticationToken登录构造的usernamepasswordtoken
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证方法");
        //1.构造uptoken
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        //2.获取输入的用户名密码
        String username = upToken.getUsername();
        String password = new String(upToken.getPassword());
        //3.根据用户名查询数据库，正式系统查询
        User user = userService.findByUsername(username);
        if(user==null){
            throw new CommonException(WebStatus.USER_ERROR,"用户名不存在");
        }
        if ("1".equals(user.getStatus())) {
            throw new CommonException(WebStatus.FREEZE, "您的账号已被冻结");
        }
        //4.比较密码和数据库中的密码是否一致（密码可能需要加密）
        if (StringUtils.equals(password, user.getPassword())) {
            //单一登录
            checkSingleSingOn(user);
            //5.如果成功，向shiro存入安全数据
            user.setUsername(username);
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, this.getName());//1.安全数据，2.密码。3。当前realm域名称
            return info;
        } else {
            //6.失败，抛出异常或返回null
            throw new CommonException(WebStatus.USER_ERROR, "用户名或密码错误");
        }
    }

    /**
     * 验证权限
     */
    @Override
    public  boolean isPermitted(PrincipalCollection principals, String permission){
        User user = (User)principals.getPrimaryPrincipal();
        return user.getRoleId()==1||super.isPermitted(principals,permission);
    }

    /**
     * 验证角色
     */
    @Override
    public boolean hasRole(PrincipalCollection principals, String roleIdentifier) {
        User user = (User) principals.getPrimaryPrincipal();
        return user.getRoleId()==1 || super.hasRole(principals, roleIdentifier);
    }

        /**
         * 用户单一登录
         *
         * @param user 用户实体
         */
    private void checkSingleSingOn(User user) {
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        DefaultWebSessionManager sessionManager = (DefaultWebSessionManager) securityManager.getSessionManager();
        //获取当前已登录的用户session列表
        SessionDAO sessionDAO = sessionManager.getSessionDAO();
        Collection<Session> sessions = sessionDAO.getActiveSessions();

        for (Session session : sessions) {
            Object obj = session.getAttribute("org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY");
            if(obj!=null){
                JSONObject loginUser=JSONObject.parseObject(obj.toString());

                //清除该用户以前登录时保存的session
                if (loginUser != null && user.getId() == loginUser.getJSONObject("User").getLong("id")) {
                    sessionDAO.delete(session);
                }
            }
        }
    }
}
