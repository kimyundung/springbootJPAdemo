package com.stone.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 接收 name、email 两个字段的值
 */
@Data
@AllArgsConstructor
@Builder
// not bad
public class UserOnlyNameEmailDto {
    private String name,email;
}
