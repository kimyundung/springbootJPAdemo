package com.stone.springbootjpademo06.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "book")
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "color", discriminatorType = DiscriminatorType.STRING)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
}
