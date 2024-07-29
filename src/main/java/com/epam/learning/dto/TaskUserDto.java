package com.epam.learning.dto;

import com.epam.learning.enums.Priority;
import com.epam.learning.enums.Status;
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
    private Long dueDate;
    private Long createdDate;
    private Integer userId;
}
