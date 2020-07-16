package com.jacques.gamelibrary;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 花落泪知雨
 * @since 2020/4/21
 */
@SpringBootApplication
@ComponentScan("com.jacques.*")
@MapperScan("com.jacques.*.dao")
public class GameLibraryApplication {
    public static void main(String[] ages){
        SpringApplication.run(GameLibraryApplication.class,ages);
    }
}
