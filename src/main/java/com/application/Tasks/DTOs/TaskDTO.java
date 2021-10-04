package com.application.Tasks.DTOs;

import com.application.Tasks.Model.Status;

import java.util.Date;

public class TaskDTO extends AuthenticatedRequestDTO{
    private String name;
    private String description;
    private Date dueDate;
    private Status status;

}
