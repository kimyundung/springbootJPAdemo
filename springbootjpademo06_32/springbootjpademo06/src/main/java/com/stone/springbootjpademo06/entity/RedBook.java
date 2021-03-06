package com.stone.springbootjpademo06.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Data
@ToString
@Entity
@EqualsAndHashCode(callSuper = false)
public class RedBook extends Book{
    private String redMark;
}
