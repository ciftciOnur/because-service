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

import org.springframework.http.HttpStatus;

public class EmailNotFoundException extends UserServiceException{
    public EmailNotFoundException(String message){
        super(message, HttpStatus.NOT_FOUND);
    }
}
