package com.jacques.shiro.shiro.session;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**
 * @author Jack_YD
 * @create 2019/12/24 14:14
 */
public class CustomSessionManager extends DefaultWebSessionManager {
  private static final String AUTHORIZATION = "Authorization";

  @Override
  protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
    String id = WebUtils.toHttp(request).getHeader(AUTHORIZATION);
    System.out.println("进入session管理器");
    if (StringUtils.isNotBlank(id)) {
      // 来源
      request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, "header");
      request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, id);
      // 是否验证
      request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
      return id;
    } else {
      //没有生成新的sessionId
      return super.getSessionId(request, response);
    }
  }

}
