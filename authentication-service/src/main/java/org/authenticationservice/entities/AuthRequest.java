package org.authenticationservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthRequest {

    private String email;
    private String password;
    private String name;
    private String role;
}