package com.example.springdemo.services.users;

import com.example.springdemo.models.Users;

import java.util.List;

public interface IUsersService {
    List<Users> findAllUsers();
    Users getUsersById(Long id);
    Users addUsers(Users users);
    Users updateUsers(Users users);
    void deleteUsers(Long id);
}
