package net.javaguides.springboot.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.exception.EmailAlreadyExistsException;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.mapper.AutoUserMapper;
import net.javaguides.springboot.mapper.UserMapper;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static net.javaguides.springboot.mapper.UserMapper.mapToUser;
import static net.javaguides.springboot.mapper.UserMapper.mapToUserDto;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto user) {

        // Convert UserDto into user JPA Entity
        //        User userEntity = mapToUser(user); [Refaktor to modelMapper]
        //        User userEntity = modelMapper.map(user,User.class); [Refaktor to MapStruct]

        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
        if (optionalUser.isPresent()) throw new EmailAlreadyExistsException("Email Already Exists for User");

        User userEntity = AutoUserMapper.MAPPER.mapToUser(user);

        // Execute saving user data
        User savedUser = userRepository.save(userEntity);

        // Convert JPA Entity into UserDto, then return
        //        UserDto savedUserDto = maToUserDto(savedUser);  [Refaktor to modelMapper]
        //        UserDto savedUserDto = modelMapper.map(savedUser,UserDto.class) [Refaktor to MapStruct]
        return AutoUserMapper.MAPPER.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId){
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User","Id",userId)
        );

        //        User user = optionalUser.get(); [Not used]

        //        return UserMapper.mapToUserDto(user); [Refaktor to modelMapper]
        //        return modelMapper.map(user,UserDto.class); [Refaktor to MapStruct]
        return AutoUserMapper.MAPPER.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = userRepository.findAll();
//        return user.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList()); [Refaktor to MapStruct]
        return userList.stream().map((user) -> AutoUserMapper.MAPPER.mapToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {

        User existingUser = userRepository.findById(user.getId()).orElseThrow(
                () -> new ResourceNotFoundException("User","id", user.getId())
        );

        existingUser.setFirstname(user.getFirstName());
        existingUser.setLastname(user.getLastName());
        existingUser.setEmail(user.getEmail());

        User updatedUser = userRepository.save(existingUser);

        //        return UserMapper.mapToUserDto(updatedUser); [Refaktor to modelMapper]
        //        return modelMapper.map(updatedUser,UserDto.class); [Refaktor to MapStruct]
        return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
    }

    @Override
    public Void deleteUser(Long userId) {

        User existingUser = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User","id", userId)
        );

        userRepository.deleteById(userId);
        return null;
    }
}
