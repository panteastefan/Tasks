package com.application.Tasks.Repository;

import com.application.Tasks.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    void deleteTaskById(Long id);
    Task findTaskById(Long id);
}
