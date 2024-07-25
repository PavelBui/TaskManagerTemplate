package com.epam.learning.service;

import com.epam.learning.dto.TaskUserDto;

import java.util.List;

public interface TaskUserService {

    String createTask(TaskUserDto taskUserDto);

    TaskUserDto updateTask(Integer id, TaskUserDto taskUserDto);

    String deleteTask(Integer id);

    TaskUserDto getTask(Integer id);

    List<TaskUserDto> getAllTaskByUserId(Integer id);
}
