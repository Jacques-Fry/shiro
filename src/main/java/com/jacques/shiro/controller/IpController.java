package com.jacques.shiro.controller;

import com.jacques.shiro.entity.IpAddress;
import com.jacques.shiro.entity.Result;
import com.jacques.shiro.entity.StatusCode;
import com.jacques.shiro.service.IpAddressService;
import com.jacques.shiro.utils.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jack_YD
 * @create 2020/1/6 12:56
 */
@RestController
@RequestMapping("ip")
public class IpController {

  @Autowired
  IpAddressService ipAddressService;

  @GetMapping("getIp")
  public Result getIp(HttpServletRequest request) {
    String ip = IpUtil.getPublicIpAdrress(request);
    IpAddress subdivision = ipAddressService.getSubdivision(ip);
    if (subdivision == null) return new Result(false, StatusCode.ERROR, "根据Ip:" + ip + " 获取省份失败");
    return new Result(true, StatusCode.OK, "获取成功", subdivision);
  }
}
