/*
 * Copyright (c) 2012-
 * Vodafone Teknoloji Hizmetleri A.S., Istanbul, Turkey
 *
 * All rights reserved. This Software or any portion of it can not be translated,
 * distributed, sold, adapted, arranged, used, copied, modified, de-compiled,
 * reverse assembled or otherwise reverse engineered, disassembled, replaced or made
 * additions to and to be reproduced in whole or in part, in any way, manner or form.
 */
package com.cuzoffservice.infrastructure.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AuthenticationProvider {
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }
}
