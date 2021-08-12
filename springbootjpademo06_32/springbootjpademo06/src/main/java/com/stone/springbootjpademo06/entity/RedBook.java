package com.stone.springbootjpademo06.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("red")
public class RedBook extends Book{
    private String redMark;
}
