import {
    request
  } from "./request"
  
  export function queryPermissionList(permission, pageNum, pageSize) {
    return request({
      method: 'POST',
      url: '/permission/queryList',
      params: {
        pageNum,
        pageSize
      },
      data: permission
    })
  }