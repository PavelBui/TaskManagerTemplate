package com.epam.learning.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer id;
    @NotNull(message = "user login shouldn't be null")
    private String userLogin;
    @NotNull(message = "user password shouldn't be null")
    private String userPassword;
}
