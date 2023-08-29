package com.arabsoft.stage2023.entity;

import org.springframework.security.core.GrantedAuthority;
public enum RoleName implements
        GrantedAuthority {
    ADMIN,
    SUPERADMIN,
    OPERATEUR;
    @Override
    public String getAuthority() {
        return "ROLE_" + name();
    }}