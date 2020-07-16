import {
    request
  } from "./request"
  
  export function queryLogList(log, pageNum, pageSize) {
    return request({
      method: 'POST',
      url: '/syslog/queryList',
      params: {
        pageNum,
        pageSize
      },
      data: log
    })
  }