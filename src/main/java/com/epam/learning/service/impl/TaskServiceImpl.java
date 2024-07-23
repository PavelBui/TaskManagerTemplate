package com.epam.learning.service.impl;

import com.epam.learning.dto.TaskDto;
import com.epam.learning.entity.TaskEntity;
import com.epam.learning.exeption.TaskNotFoundException;
import com.epam.learning.mapper.TaskMapper;
import com.epam.learning.repository.TaskRepository;
import com.epam.learning.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;

    @Override
    public String createTask(TaskDto taskDto) {
        TaskEntity taskEntity = taskMapper.dtoToEntity(taskDto);
        taskEntity.setCreateDate(LocalDateTime.now());
        taskEntity.setDeleteDate(null);
        taskEntity.setIsDeleted(false);
        taskRepository.save(taskEntity);
        return "Task was created successfully";
    }

    @Override
    public TaskDto updateTask(Integer id, TaskDto taskDto) {
        TaskEntity taskEntity = taskRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        TaskEntity resultTaskEntity = taskMapper.dtoToEntity(taskDto, taskEntity);
        taskRepository.save(resultTaskEntity);
        return taskDto;
    }

    @Override
    public String deleteTask(Integer id) {
        TaskEntity taskEntity = taskRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        taskEntity.setIsDeleted(true);
        taskEntity.setDeleteDate(LocalDateTime.now());
        taskRepository.save(taskEntity);
        return "Task was deleted successfully";
    }

    @Override
    public TaskDto getTask(Integer id) {
        return taskMapper.entityToDto(taskRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new TaskNotFoundException(id)));
    }

    @Override
    public List<TaskDto> getAllTask() {
        return taskRepository.findAllByIsDeletedFalse().stream()
                .map(taskMapper::entityToDto)
                .toList();
    }

    @Override
    public List<TaskDto> getAllTaskForUser(Integer id) {
        return taskRepository.findAllByUserIdAndIsDeletedFalse(id).stream()
                .map(taskMapper::entityToDto)
                .toList();
    }
}
