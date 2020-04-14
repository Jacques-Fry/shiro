package com.jacques.shiro.service;

import com.jacques.shiro.entity.IpAddress;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.net.InetAddress;

/**
 * @author Jack_YD
 * @create 2019/9/18 12:56
 */
@Service
public final class IpAddressService {

        private static Logger logger = LoggerFactory.getLogger(IpAddressService.class);

        private static String dbPath="D:/Tools/GeoLite2-City.mmdb";
        // C:/Users/TS-B-SYH/Desktop/dev/GeoLite2-City.mmdb
        //  /usr/share/nginx/common/GeoLite2-City.mmdb

        private static DatabaseReader reader;

        @Autowired
        private Environment env;

        @PostConstruct
        public void init() {
            try {
                String path = env.getProperty("geolite2.city.db.path");
                if (StringUtils.isNotBlank(path)) {
                    dbPath = path;
                }
                File database = new File(dbPath);
                reader = new DatabaseReader.Builder(database).build();
            } catch (Exception e) {
                logger.error("IP地址服务初始化异常:" + e.getMessage(), e);
            }
        }


        public IpAddress getSubdivision(String ipAddress){
            try {
                CityResponse response = reader.city(InetAddress.getByName(ipAddress));
                return new IpAddress(ipAddress,response.getCountry().getNames().get("zh-CN"),response.getLeastSpecificSubdivision().getNames().get("zh-CN"),response.getCity().getNames().get("zh-CN"));
            }catch (Exception e){
                logger.error("根据IP[{}]获取省份失败:{}", ipAddress, e.getMessage());
                return null;
            }
        }
}
