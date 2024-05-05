package com.example.stocktransactionapp.service.security;

import com.example.stocktransactionapp.controller.authentication.CredentialsRequestBody;
import com.example.stocktransactionapp.datasource.security.model.BasicUser;
import com.example.stocktransactionapp.datasource.security.repository.UserRepository;
import com.example.stocktransactionapp.exception.security.EmailAlreadyTakenException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegistrationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(CredentialsRequestBody credentialsRequestBody) {
        userRepository.findUserByEmail(credentialsRequestBody.getUserEmail())
                .ifPresent(user -> {
                    throw new EmailAlreadyTakenException("Email already taken");
                });


        var user = BasicUser.builder()
                .email(credentialsRequestBody.getUserEmail())
                .password(passwordEncoder.encode(credentialsRequestBody.getPassword()))
                .build();

        userRepository.save(user);
    }
}
