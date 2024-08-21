package com.example.fido.fidoDemo.service;


import com.example.fido.fidoDemo.model.User;
import com.example.fido.fidoDemo.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class RegistrationService {

    private final UserRepository userRepository;

    public RegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(String username, byte[] publicKey, String credentialId, long counter) {
        User user = new User();
        user.setUsername(username);
        user.setPublicKey(publicKey);
        user.setCredentialId(credentialId);
        user.setCounter(counter);

        userRepository.save(user);
    }

    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}

