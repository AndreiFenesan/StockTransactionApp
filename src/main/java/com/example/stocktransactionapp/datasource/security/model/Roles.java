package com.example.stocktransactionapp.datasource.security.model;

import java.text.MessageFormat;

public enum Roles {
    ADMIN, BASIC_USER;

    public static String getRoleName(Roles roles) {
        return MessageFormat.format("ROLE_{0}", roles.name());
    }
}
