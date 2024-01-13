package com.productservice.security;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class TokenValidator {

    private RestTemplateBuilder restTemplateBuilder;

    TokenValidator(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    /**
     * This method should call user service to validate the token
     *
     * @param token
     * @return
     */
    public Optional<JWTObject> validateToken(String token){
        RestTemplate restTemplate = restTemplateBuilder.build();
        //Make a http call to  User service to call Validate token method
        return Optional.empty();
    }
}
