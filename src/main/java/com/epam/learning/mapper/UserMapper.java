package com.epam.learning.mapper;

import com.epam.learning.dto.UserDto;
import com.epam.learning.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity dtoToEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        dtoToEntity(userDto, userEntity);
        return userEntity;
    }

    public UserEntity dtoToEntity(UserDto userDto, UserEntity userEntity) {
        userEntity.setId(userDto.getId());
        userEntity.setUserLogin(userDto.getUserLogin());
        userEntity.setUserPassword(userDto.getUserPassword());
        return userEntity;
    }

    public UserDto entityToDto(UserEntity userEntity) {
        return UserDto.builder()
                .id(userEntity.getId())
                .userLogin(userEntity.getUserLogin())
                .userPassword(userEntity.getUserPassword())
                .build();
    }
}
