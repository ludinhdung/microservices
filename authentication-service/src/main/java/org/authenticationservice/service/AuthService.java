package org.authenticationservice.service;

import lombok.AllArgsConstructor;
import org.authenticationservice.entities.AuthRequest;
import org.authenticationservice.entities.AuthResponse;
import org.authenticationservice.entities.UserDto;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class AuthService {

    private final RestTemplate restTemplate;
    private final JwtUtil jwtUtil;

    public AuthResponse register(AuthRequest request) {
        request.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        request.setRole("USER");
        UserDto registeredUser = restTemplate.postForObject("http://localhost:8081/api/v1/users", request, UserDto.class);

        String accessToken = jwtUtil.generate(registeredUser.id().toString(), registeredUser.role(), "ACCESS");
        String refreshToken = jwtUtil.generate(registeredUser.id().toString(), registeredUser.role(), "REFRESH");

        return new AuthResponse(accessToken, refreshToken);
    }


}