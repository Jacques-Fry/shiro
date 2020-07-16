package com.jacques.shiro.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jacques.shiro.dao.SysLogDao;
import com.jacques.shiro.pojo.SysLog;
import com.jacques.shiro.utils.IdWorker;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    /**
     * 生成操作记录
     * @param sysLog
     */
    public void saveSysLog(SysLog sysLog){
        sysLog.setId(idWorker.nextId());
        sysLogDao.saveSysLog(sysLog);
    }
    /**
     * 分页条件查询操作记录
     */
    public PageInfo<SysLog> queryList(SysLog sysLog, int pageNum, int pageSize) {
        String orderBy = "create_time DESC";
        PageHelper.startPage(pageNum, pageSize, orderBy);
        List<SysLog> sysLogList = sysLogDao.queryList(sysLog, pageNum, pageSize);
        return new PageInfo<>(sysLogList);
    }
}
