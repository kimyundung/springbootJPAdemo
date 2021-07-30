package com.stone;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.stone.mapper") //制定扫描mapper的包名, 生成动态代理类
public class Springbootjpademo05Application {

	public static void main(String[] args) {
		SpringApplication.run(Springbootjpademo05Application.class, args);
	}

}
