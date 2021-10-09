package com.application.Tasks.DTOs;

public class TaskDeleteDTO extends AuthenticatedRequestDTO{
    private Long id;

    public TaskDeleteDTO(String userToken, Long id) {
        super(userToken);
        this.id = id;
    }

    public TaskDeleteDTO(Long id) {
        this.id = id;
    }

    public TaskDeleteDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
