package com.internet_store.test.service;

import com.internet_store.test.dto.UserDto;
import com.internet_store.test.mapper.UserMapper;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import com.internet_store.test.entity.User;
import com.internet_store.test.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto createUser(UserDto userDto) {
        User user = userMapper.fromDto(userDto);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        return userMapper.toDto(user);
    }

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
