package com.stone.springbootjpademo06.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity(name = "book")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
}
