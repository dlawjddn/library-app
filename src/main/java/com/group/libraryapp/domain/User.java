package com.group.libraryapp.domain;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 20)
    private String name;
    private Integer age;
    protected User(){}
    public User(String name, Integer age) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException(String.format("잘못된 name(%s)가 들어왔습니다.",name));
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void updateName(String name) {
        this.name=name;
    }
}
