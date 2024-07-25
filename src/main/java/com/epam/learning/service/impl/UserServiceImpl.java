package com.epam.learning.service.impl;

import com.epam.learning.dto.UserDto;
import com.epam.learning.entity.UserEntity;
import com.epam.learning.exeption.UserNotFoundException;
import com.epam.learning.repository.UserRepository;
import com.epam.learning.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

//    @Override
//    public String createUser(UserDto userDto) {
//        return "Task was created successfully";
//    }

    @Override
    public UserDto getUserDto(Integer id) {
        return new UserDto();
//        return taskMapper.entityToDto(userRepository.findByIdAndIsDeletedFalse(id)
//                .orElseThrow(() -> new UserNotFoundException(id)));
    }

    @Override
    public UserEntity getUserEntity(Integer id) {
        return userRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

}
