package com.jacques.shiro.entity;

import java.io.Serializable;

/**
 * @author Jack_YD
 * @create 2020/1/6 13:44
 */
public class IpAddress implements Serializable{
  private String ip;//ip地址
  private String country;//国家
  private String region;//省份
  private String city;//城市
  private String isp;//运营商

  public IpAddress() {
  }

  public IpAddress(String ip, String country, String region, String city) {
    this.ip = ip;
    this.country = country;
    this.region = region;
    this.city = city;
  }

  public IpAddress(String ip, String country, String region, String city, String isp) {
    this.ip = ip;
    this.country = country;
    this.region = region;
    this.city = city;
    this.isp = isp;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getIsp() {
    return isp;
  }

  public void setIsp(String isp) {
    this.isp = isp;
  }

  @Override
  public String toString() {
    return "{\"IpAddress\":{"
        + "\"ip\":\""
        + ip + '\"'
        + ",\"country\":\""
        + country + '\"'
        + ",\"region\":\""
        + region + '\"'
        + ",\"city\":\""
        + city + '\"'
        + ",\"isp\":\""
        + isp + '\"'
        + "}}";

  }
}
