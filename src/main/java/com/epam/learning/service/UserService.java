package com.epam.learning.service;

import com.epam.learning.dto.UserDto;
import com.epam.learning.entity.UserEntity;

public interface UserService {

//    String createUser(UserDto userDto);

    UserDto getUserDto(Integer id);

    UserEntity getUserEntity(Integer id);

}
