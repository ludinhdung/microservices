package org.authenticationservice.controller;


import lombok.AllArgsConstructor;
import org.authenticationservice.entities.AuthRequest;
import org.authenticationservice.entities.AuthResponse;
import org.authenticationservice.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "/register")
    public AuthResponse register(@RequestBody AuthRequest request) {
        return authService.register(request);
    }


}
