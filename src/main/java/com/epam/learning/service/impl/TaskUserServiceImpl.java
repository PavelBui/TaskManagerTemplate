package com.epam.learning.service.impl;

import com.epam.learning.dto.TaskUserDto;
import com.epam.learning.entity.TaskUserEntity;
import com.epam.learning.exeption.TaskNotFoundException;
import com.epam.learning.mapper.TaskUserMapper;
import com.epam.learning.repository.TaskUserRepository;
import com.epam.learning.service.TaskUserService;
import com.epam.learning.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskUserServiceImpl implements TaskUserService {

    private final TaskUserMapper taskUserMapper;
    private final TaskUserRepository taskUserRepository;
    private final UserService userService;

    @Override
    public TaskUserDto createTask(TaskUserDto taskUserDto) {
        TaskUserEntity taskUserEntity = taskUserMapper.dtoToEntity(taskUserDto);
        if (taskUserDto.getUserId() != null) {
            taskUserEntity.setUser(userService.getUserEntity(taskUserDto.getUserId()));
        }
        TaskUserEntity savedTaskUserEntity = taskUserRepository.save(taskUserEntity);
        return taskUserMapper.entityToDto(savedTaskUserEntity);
    }

    @Override
    public TaskUserDto updateTask(Integer id, TaskUserDto taskUserDto) {
        TaskUserEntity taskUserEntity = taskUserRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        TaskUserEntity resultTaskEntity = taskUserMapper.dtoToEntity(taskUserDto, taskUserEntity);
        if (taskUserDto.getUserId() != null) {
            taskUserEntity.setUser(userService.getUserEntity(taskUserDto.getUserId()));
        }
        taskUserRepository.save(resultTaskEntity);
        return taskUserDto;
    }

    @Override
    public String deleteTask(Integer id) {
        TaskUserEntity taskUserEntity = taskUserRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        taskUserEntity.setDeleted(true);
        taskUserEntity.setDeleteDate(LocalDateTime.now());
        taskUserRepository.save(taskUserEntity);
        return "Task was deleted successfully";
    }

    @Override
    public TaskUserDto getTask(Integer id) {
        return taskUserMapper.entityToDto(taskUserRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new TaskNotFoundException(id)));
    }

    @Override
    public List<TaskUserDto> getAllTaskByUserId(Integer id) {
        return taskUserRepository.findAllByUserIdAndIsDeletedFalse(id).stream()
                .map(taskUserMapper::entityToDto)
                .toList();
    }
}
