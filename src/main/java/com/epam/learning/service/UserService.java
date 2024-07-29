package com.epam.learning.service;

import com.epam.learning.dto.UserDto;
import com.epam.learning.entity.UserEntity;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto updateUser(Integer id, UserDto userDto);

    String deleteUser(Integer id);

    UserEntity getUserEntity(Integer id);

}
