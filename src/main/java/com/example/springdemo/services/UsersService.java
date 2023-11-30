package com.example.springdemo.services;

import org.springframework.stereotype.Service;

import com.example.springdemo.models.Users;
import com.example.springdemo.repositories.UsersRepository;

import java.util.List;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> findAllUsers() {
        return usersRepository.findAll();
    }

    public Users getUsersById(Long id) {
        return usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec id : " + id));
    }

    public Users addUsers(Users users) {
        if (!(users instanceof Users)) {
            throw new RuntimeException("L'objet n'est pas de type Users");
        }

        return usersRepository.save(users);
    }

    public Users updateUsers(Users users) {
        return usersRepository.save(users);
    }

    public void deleteUsers(Long id) {
        usersRepository.deleteById(id);
    }

}
