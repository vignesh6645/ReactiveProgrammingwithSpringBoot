package com.example.springReactiveApplication;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Table(name = "student")
public class Student {

    @Id
    private Integer id;

    private String firstname;

    private String lastname;

    private int age;
    }
