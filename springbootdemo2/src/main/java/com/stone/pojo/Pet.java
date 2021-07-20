package com.stone.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 宠物类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    private String type;
    private String name;
}
