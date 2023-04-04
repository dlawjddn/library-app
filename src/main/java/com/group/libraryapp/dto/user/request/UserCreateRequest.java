package com.group.libraryapp.dto.user.request;

public class UserCreateRequest {
    private final String name;
    private final Integer age;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public UserCreateRequest(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
