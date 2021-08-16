package com.stone.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "addresses")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private SexEnum sex;
    private Integer age;
    private Date createDate;
    private Date updateDate;
    @OneToMany(mappedBy = "user") //必写代码
    @JsonIgnore                   //必写代码 (StackOverflowError)
    private List<UserAddress> addresses;
}
