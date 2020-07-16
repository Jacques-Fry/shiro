import { request } from "./request"

export function getIp() {
  return request({
    url: '/ip/getIp'
  })
}