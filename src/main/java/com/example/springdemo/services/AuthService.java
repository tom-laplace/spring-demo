package com.example.springdemo.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springdemo.models.Users;
import com.example.springdemo.repositories.UsersRepository;
import java.util.ArrayList;

@Service
public class AuthService {

    private UsersRepository usersRepository;

    public AuthService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
        Users user = usersRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email : " + email));

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getMotDePasseHash(),
                new ArrayList<>());
    }
}
