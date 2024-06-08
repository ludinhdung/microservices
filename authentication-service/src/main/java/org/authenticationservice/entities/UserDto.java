package org.authenticationservice.entities;

public record UserDto(Integer id,String name, String email, String password, String role) {
}