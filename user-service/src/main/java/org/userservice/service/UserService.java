package org.userservice.service;

import org.userservice.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();
    UserDto findById(Integer id);
    UserDto save(UserDto userDto);
}
