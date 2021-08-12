package com.stone.springbootjpademo06.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class BlueBook extends Book{
    private String blueMark;
}
