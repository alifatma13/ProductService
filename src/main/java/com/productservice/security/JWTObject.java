package com.productservice.security;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class JWTObject {
    // This is kind of DTO you want from the token sent via api header
    private String email;
    private Long userId;
    private Date expiryAt;
    private Date createdAt;
    private List<Role> roles;
}
