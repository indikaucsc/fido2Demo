package com.example.fido.fidoDemo.controller;

import com.example.fido.fidoDemo.model.User;
import com.example.fido.fidoDemo.service.RegistrationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fido2")
public class Fido2Controller {

    private final RegistrationService registrationService;

    public Fido2Controller(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/register")
    public void register(@RequestBody User user) {
        // Generate and return PublicKeyCredentialCreationOptions
        // For simplicity, assume the publicKey, credentialId, and counter are part of the User object in this example.
        registrationService.registerUser(user.getUsername(), user.getPublicKey(), user.getCredentialId(), user.getCounter());
    }

    @PostMapping("/login")
    public boolean login(@RequestBody User user) {
        // Validate PublicKeyCredentialRequestOptions
        return registrationService.findUserByUsername(user.getUsername())
                .map(existingUser -> existingUser.getPublicKey().equals(user.getPublicKey()))
                .orElse(false);
    }
}

