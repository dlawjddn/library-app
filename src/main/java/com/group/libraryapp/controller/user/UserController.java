package com.group.libraryapp.controller.user;

import com.group.libraryapp.domain.User;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private final List<User> users = new ArrayList<>();
    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request){
        User newUser = new User(request.getName(), request.getAge());
        users.add(newUser);
    }
    @GetMapping("/user")
    public List<UserResponse> getUser(){
        List<UserResponse> response = new ArrayList<>();
        for(int i=0; i< users.size(); i++){
            response.add(new UserResponse(i + 1L, users.get(i)));
        }
        return response;
    }
}
