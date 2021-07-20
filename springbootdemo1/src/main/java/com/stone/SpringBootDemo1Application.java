package com.stone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot启动类，通常放在二级包中
 * 因为SpringBoot项目在做包扫描，会扫描启动类所在的包及其子包下的所有内容
 */
@SpringBootApplication //当前类为SpringBoot项目的启动类
public class SpringBootDemo1Application {
    public static void main(String[] args){
        // 样板代码
        SpringApplication.run(SpringBootDemo1Application.class,args);
    }
}
