/*
 * Copyright (c) 2012-
 * Vodafone Teknoloji Hizmetleri A.S., Istanbul, Turkey
 *
 * All rights reserved. This Software or any portion of it can not be translated,
 * distributed, sold, adapted, arranged, used, copied, modified, de-compiled,
 * reverse assembled or otherwise reverse engineered, disassembled, replaced or made
 * additions to and to be reproduced in whole or in part, in any way, manner or form.
 */
package com.cuzoffservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.ZoneId;
import java.util.TimeZone;

@SpringBootApplication
public class CuzoffServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CuzoffServiceApplication.class, args);
    }

    @Bean
    public void setTimeZone() {
        TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.of("Europe/Istanbul")));
    }

}
