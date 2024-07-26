package com.epam.learning.controller;

import com.epam.learning.dto.UserDto;
import com.epam.learning.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
@Api(tags = "User Endpoints")
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Create User")
    public ResponseEntity<String> createUser(@RequestBody UserDto userDto) {
        userDto.setId(null);
        return ResponseEntity.ok(userService.createUser(userDto));
    }

    @PutMapping("/{id}")
    @ApiOperation("Update User by id")
    public ResponseEntity<UserDto> updateUser(@PathVariable Integer id, @RequestBody UserDto userDto) {
        userDto.setId(id);
        return ResponseEntity.ok(userService.updateUser(id, userDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Delete User by id")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }

}
