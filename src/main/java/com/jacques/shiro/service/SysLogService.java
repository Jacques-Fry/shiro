package com.jacques.shiro.service;

import com.jacques.shiro.dao.SysLogDao;
import com.jacques.shiro.pojo.SysLog;
import com.jacques.shiro.utils.IdWorker;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Jack_YD
 * @create 2020/4/13 9:03
 */
@Service
public class SysLogService {

    @Resource
    private IdWorker idWorker;

    @Resource
    private SysLogDao sysLogDao;

    public void saveSysLog(SysLog sysLog){
        sysLog.setId(idWorker.nextId());
        sysLogDao.saveSysLog(sysLog);
    }
}
