package com.epam.learning.controller;

import com.epam.learning.dto.TaskUserDto;
import com.epam.learning.service.TaskUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/task_user")
@Api(tags = "Task with Users Endpoints")
public class TaskUserController {

    private final TaskUserService taskUserService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Create Task with User")
    public ResponseEntity<String> createTask(@RequestBody TaskUserDto taskUserDto) {
        taskUserDto.setId(null);
        return ResponseEntity.ok(taskUserService.createTask(taskUserDto));
    }

    @PutMapping("/{id}")
    @ApiOperation("Update Task  with User by task id")
    public ResponseEntity<TaskUserDto> updateTask(@PathVariable Integer id, @RequestBody TaskUserDto taskUserDto) {
        taskUserDto.setId(id);
        return ResponseEntity.ok(taskUserService.updateTask(id, taskUserDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Delete Task  with User by task id")
    public ResponseEntity<String> deleteTask(@PathVariable Integer id) {
        return ResponseEntity.ok(taskUserService.deleteTask(id));
    }

    @GetMapping("/{id}")
    @ApiOperation("Get Task with User by task id")
    public ResponseEntity<TaskUserDto> getTask(@PathVariable Integer id) {
        return ResponseEntity.ok(taskUserService.getTask(id));
    }

    @GetMapping("/user/{id}")
    @ApiOperation("Get list of all Tasks for user by user id")
    public ResponseEntity<List<TaskUserDto>> getAllTaskByUserId(@PathVariable Integer id) {
        return ResponseEntity.ok(taskUserService.getAllTaskByUserId(id));
    }
}
