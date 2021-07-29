package com.stone.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 用户扩展信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class UserExtend {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private String idCard;
    private Integer ages;
    private String studentNumber;
}
