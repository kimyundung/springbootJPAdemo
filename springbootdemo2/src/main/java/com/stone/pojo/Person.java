package com.stone.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 人类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component  // Person对象交给Spring管理
/*
    @ConfigurationProperties(prefix = "person")
    将配置文件中所有以person开头的配置信息注入当前类中
    前提1：必须保证配置文件中person.xx与当前Person类的属性名一致
    前提2：必须保证当前Person中的属性都具有set方法
 */
@ConfigurationProperties(prefix = "person")
public class Person {
    //@Value("$(id)")
    private int id;
    private String name;
    private List hobby;
    private String[] family;
    private Map map;
    private Pet pet;
}
