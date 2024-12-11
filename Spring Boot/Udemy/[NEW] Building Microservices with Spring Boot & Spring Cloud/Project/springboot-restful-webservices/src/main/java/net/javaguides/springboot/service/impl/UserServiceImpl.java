package net.javaguides.springboot.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.mapper.UserMapper;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static net.javaguides.springboot.mapper.UserMapper.mapToUser;
import static net.javaguides.springboot.mapper.UserMapper.mapToUserDto;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto user) {

        // Convert UserDto into user JPA Entity
        User userEntity = mapToUser(user);

        // Execute saving user data
        User savedUser = userRepository.save(userEntity);

        // Convert JPA Entity into UserDto, then return
        return mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId){
        Optional<User> optionalUser = userRepository.findById(userId);

        User user = optionalUser.get();
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstname(user.getFirstname());
        existingUser.setLastname(user.getLastname());
        existingUser.setEmail(user.getEmail());

        return userRepository.save(existingUser);
    }

    @Override
    public Void deleteUser(Long userId) {
        userRepository.deleteById(userId);
        return null;
    }
}
