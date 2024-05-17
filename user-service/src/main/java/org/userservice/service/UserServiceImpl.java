package org.userservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.userservice.dto.UserDto;
import org.userservice.exception.UserAlreadyExistsException;
import org.userservice.exception.UserNotFountException;
import org.userservice.mapper.UserMapper;
import org.userservice.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto).toList();
    }

    @Override
    public UserDto findById(Integer id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(() -> new UserNotFountException("User not found with ID: " + id));
    }

    @Override
    public UserDto save(UserDto userDto) {
        userRepository.findByEmailIgnoreCase(userDto.email())
                .ifPresent(user -> {
                    throw new UserAlreadyExistsException("User with email " + userDto.email() + " already exists");
                });

        return userMapper.toDto(userRepository.save(userMapper.toEntity(userDto)));
    }
}
