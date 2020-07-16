package com.jacques.shiro;

import com.jacques.shiro.entity.IpAddress;
import com.jacques.shiro.service.IpAddressService;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jack_YD
 * @create 2020/1/6 13:38
 */
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class IpTest {
//  @Autowired
//  IpAddressService ipAddressService;
//
//
//  @Test
//  public void test1(){
//    IpAddress subdivision = ipAddressService.getSubdivision("101.71.154.230");
//
//    System.out.println(subdivision);
//  }
//
//
//
//
//
//  @Test
//  public void test2() throws IOException, URISyntaxException {
//    // 创建Httpclient对象
//    CloseableHttpClient httpclient = HttpClients.createDefault();
//    // 创建http POST请求，访问开源中国
//    HttpPost httpPost = new HttpPost("http://ip.taobao.com/service/getIpInfo.php?ip=101.71.154.230");
//
//    // 根据开源中国的请求需要，设置post请求参数
//    List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
////    parameters.add(new BasicNameValuePair("ip", "101.71.154.230"));
//    // 构造一个form表单式的实体
////    UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
//    // 将请求实体设置到httpPost对象中
////    httpPost.setEntity(formEntity);
//
////    URLDataSource urlDataSource=
//
//    CloseableHttpResponse response = null;
//    try {
//      // 执行请求
//      response = httpclient.execute(httpPost);
//      // 判断返回状态是否为200
//      if (response.getStatusLine().getStatusCode() == 200) {
//        // 解析响应体
//        String content = EntityUtils.toString(response.getEntity(), "UTF-8");
//        System.out.println(content);
//      }else{
//        // 解析响应体
//        String content = EntityUtils.toString(response.getEntity(), "UTF-8");
//        System.out.println(content);
//      }
//    } finally {
//      if (response != null) {
//        response.close();
//      }
//      // 关闭浏览器
//      httpclient.close();
//    }
//  }
//
//  @Test
//  public void test3() throws IOException {
//    // 创建Httpclient对象
//    CloseableHttpClient httpclient = HttpClients.createDefault();
//    // 创建http POST请求，访问开源中国
//    HttpPost httpPost = new HttpPost("http://www.oschina.net/search");
//
//    // 根据开源中国的请求需要，设置post请求参数
//    List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
//    parameters.add(new BasicNameValuePair("scope", "project"));
//    parameters.add(new BasicNameValuePair("q", "java"));
//    parameters.add(new BasicNameValuePair("fromerr", "8bDnUWwC"));
//    // 构造一个form表单式的实体
//    UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
//    // 将请求实体设置到httpPost对象中
//    httpPost.setEntity(formEntity);
//
//    CloseableHttpResponse response = null;
//    try {
//      // 执行请求
//      response = httpclient.execute(httpPost);
//      // 判断返回状态是否为200
//      if (response.getStatusLine().getStatusCode() == 200) {
//        // 解析响应体
//        String content = EntityUtils.toString(response.getEntity(), "UTF-8");
//        System.out.println(content);
//      }else{
//        // 解析响应体
//        String content = EntityUtils.toString(response.getEntity(), "UTF-8");
//        System.out.println(content);
//      }
//    } finally {
//      if (response != null) {
//        response.close();
//      }
//      // 关闭浏览器
//      httpclient.close();
//    }
//
//  }
//}
