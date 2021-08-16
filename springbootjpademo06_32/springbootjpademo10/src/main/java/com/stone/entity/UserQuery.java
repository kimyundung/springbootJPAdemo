package com.stone.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserQuery {
    private Long id;
    private String name;
    private String email;
    private SexEnum sex;
    private Integer age;
    private Date createDate;
    private Date updateDate;
    private List<UserAddress> addresses;
}
