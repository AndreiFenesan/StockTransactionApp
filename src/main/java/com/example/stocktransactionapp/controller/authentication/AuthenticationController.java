package com.example.stocktransactionapp.controller.authentication;

import com.example.stocktransactionapp.exception.security.InvalidTokenType;
import com.example.stocktransactionapp.service.security.AuthenticationService;
import com.example.stocktransactionapp.service.security.UserRegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserRegistrationService userRegistrationService;

    @PostMapping("/sign-in")
    public ResponseEntity<AuthenticationResponseBody> signInUser(
            @Valid @RequestBody CredentialsRequestBody authenticationRequestBody) {
        AuthenticationResponseBody body = authenticationService
                .authenticateUser(authenticationRequestBody);
        return ResponseEntity.ok(body);
    }

    @PostMapping("/refreshToken")
    public ResponseEntity<AuthenticationResponseBody> refreshToken(
            @AuthenticationPrincipal UserDetails principal,
            @Valid @RequestBody RefreshTokenRequestBody refreshTokenRequestBody) {
        AuthenticationResponseBody body = authenticationService
                .refreshToken(principal, refreshTokenRequestBody);
        return ResponseEntity.ok(body);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(
            @Valid @RequestBody CredentialsRequestBody credentialsRequestBody) {

        userRegistrationService.register(credentialsRequestBody);
        return ResponseEntity.accepted().build();
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> authenticationExceptionHandler(BadCredentialsException badCredentialsException) {
        return Map.of("error", badCredentialsException.getMessage());
    }

    @ExceptionHandler(InvalidTokenType.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> invalidTokenTypeExceptionHandler(InvalidTokenType invalidTokenType) {
        return Map.of("error", invalidTokenType.getMessage());
    }

}
