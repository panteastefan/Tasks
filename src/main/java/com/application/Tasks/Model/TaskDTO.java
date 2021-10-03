package com.application.Tasks.Model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

public class TaskDTO extends AuthenticatedRequestDTO{
    private String name;
    private String description;
    private Date dueDate;
    private Status status;

}
