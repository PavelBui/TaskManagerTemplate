package com.epam.learning.service.impl;

import com.epam.learning.dto.UserDto;
import com.epam.learning.entity.UserEntity;
import com.epam.learning.exeption.UserNotFoundException;
import com.epam.learning.mapper.UserMapper;
import com.epam.learning.repository.UserRepository;
import com.epam.learning.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public String createUser(UserDto userDto) {
        UserEntity userEntity = userMapper.dtoToEntity(userDto);
        userEntity.setCreateDate(LocalDateTime.now());
        userEntity.setDeleteDate(null);
        userEntity.setIsDeleted(false);
        userRepository.save(userEntity);
        return "User was created successfully";
    }

    @Override
    public UserDto updateUser(Integer id, UserDto userDto) {
        UserEntity userEntity = userRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        UserEntity resultUserEntity = userMapper.dtoToEntity(userDto, userEntity);
        userRepository.save(resultUserEntity);
        return userDto;
    }

    @Override
    public String deleteUser(Integer id) {
        UserEntity userEntity = userRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        userEntity.setIsDeleted(true);
        userEntity.setDeleteDate(LocalDateTime.now());
        userRepository.save(userEntity);
        return "User was deleted successfully";
    }

    @Override
    public UserEntity getUserEntity(Integer id) {
        return userRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

}
