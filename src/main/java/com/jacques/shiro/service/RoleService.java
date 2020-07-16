package com.jacques.shiro.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jacques.shiro.dao.RoleDao;
import com.jacques.shiro.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

/**
 * @author Jack_YD
 * @create 2019/12/23 14:50
 */
@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    /**
     * 根据id查询角色
     *
     * @param id
     */
    public HashSet<String> findById(Integer id) {
        System.out.println("==============执行了角色查询");
        return roleDao.findById(id);
    }

    /**
     * 分页条件查询角色
     */
    public PageInfo<Role> queryList(Role role, int pageNum, int pageSize) {
        String orderBy = "";
        PageHelper.startPage(pageNum, pageSize, orderBy);
        List<Role> roleList = roleDao.queryList(role, pageNum, pageSize);
        return new PageInfo<>(roleList);
    }
}
