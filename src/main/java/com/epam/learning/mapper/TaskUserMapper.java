package com.epam.learning.mapper;

import com.epam.learning.dto.TaskUserDto;
import com.epam.learning.entity.TaskUserEntity;
import com.epam.learning.utils.DateTimeUtils;
import org.springframework.stereotype.Component;

@Component
public class TaskUserMapper {

    public TaskUserEntity dtoToEntity(TaskUserDto taskUserDto) {
        TaskUserEntity taskUserEntity = new TaskUserEntity();
        dtoToEntity(taskUserDto, taskUserEntity);
        return taskUserEntity;
    }

    public TaskUserEntity dtoToEntity(TaskUserDto taskUserDto, TaskUserEntity taskUserEntity) {
        taskUserEntity.setId(taskUserDto.getId());
        taskUserEntity.setTitle(taskUserDto.getTitle());
        taskUserEntity.setContent(taskUserDto.getContent());
        taskUserEntity.setStatus(taskUserDto.getStatus());
        taskUserEntity.setPriority(taskUserDto.getPriority());
        taskUserEntity.setDueDate(DateTimeUtils.convertTimestampToDate(taskUserDto.getDueDate()));
        taskUserEntity.setCreateDate(DateTimeUtils.convertTimestampToDate(taskUserDto.getCreatedDate()));
        return taskUserEntity;
    }

    public TaskUserDto entityToDto(TaskUserEntity taskUserEntity) {
        return TaskUserDto.builder()
                .id(taskUserEntity.getId())
                .title(taskUserEntity.getTitle())
                .content(taskUserEntity.getContent())
                .status(taskUserEntity.getStatus())
                .priority(taskUserEntity.getPriority())
                .dueDate(DateTimeUtils.convertDateToTimestamp(taskUserEntity.getDueDate()))
                .createdDate(DateTimeUtils.convertDateToTimestamp(taskUserEntity.getCreateDate()))
                .userId(taskUserEntity.getUser().getId())
                .build();
    }
}
