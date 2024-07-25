package com.epam.learning.dto;

import com.epam.learning.enums.Priority;
import com.epam.learning.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskUserDto {

    private Integer id;
    @NotNull(message = "title shouldn't be null")
    private String title;
    @NotNull(message = "content shouldn't be null")
    private String content;
    private Status status;
    private Priority priority;
    @NotNull(message = "due date shouldn't be null")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private String dueDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private String createdDate;
    private Integer userId;
}
