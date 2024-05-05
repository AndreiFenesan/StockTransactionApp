package com.example.stocktransactionapp.controller.authentication;

import com.example.stocktransactionapp.datasource.security.model.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AuthenticationResponseBody {
    private String authenticationToken;
    private String refreshToken;
    private int userId;
    private Roles role;

    public AuthenticationResponseBody() {
    }
}
