package com.example.springdemo.services.users;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.example.springdemo.models.Users;
import com.example.springdemo.repositories.UsersRepository;

import java.util.List;

@Service
public class UsersServiceImpl implements IUsersService {

    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
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

        // Hachage du mot de passe
        String hashedPassword = hashPassword(users.getMotDePasseHash());
        users.setMotDePasseHash(hashedPassword);

        return usersRepository.save(users);
    }

    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public Users updateUsers(Users users) {
        return usersRepository.save(users);
    }

    public void deleteUsers(Long id) {
        usersRepository.deleteById(id);
    }

    public void login(String email, String password) {
        Users user = usersRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec email : " + email));

        if (!BCrypt.checkpw(password, user.getMotDePasseHash())) {
            throw new RuntimeException("Mot de passe incorrect");
        }
    }

}
