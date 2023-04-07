package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void saveUser(UserCreateRequest request){
        userRepository.saveUser(request.getName(), request.getAge());
    }
    public List<UserResponse> getUsers(){
        return userRepository.getUsers();
    }
    public void updateUser(UserUpdateRequest request){
        boolean isUserNotExist = userRepository.isUserNotExist(request.getId());
        if (isUserNotExist) throw new IllegalArgumentException();

        userRepository.updateUserName(request.getName(), request.getId());
    }
    public void deleteUser(String name){
        boolean isUserNotExist = userRepository.isUserNotExist(name);
        if (isUserNotExist) throw new IllegalArgumentException();

        userRepository.deleteUser(name);
    }
}
