import {
  request
} from "./request"

export function queryUserList(user, pageNum, pageSize) {
  return request({
    method: 'POST',
    url: '/user/queryList',
    params: {
      pageNum,
      pageSize
    },
    data: user
  })
}