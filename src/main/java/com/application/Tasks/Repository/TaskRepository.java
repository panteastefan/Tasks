package com.application.Tasks.Repository;

import com.application.Tasks.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Long deleteTaskById(Long id);
    List<Task> findTasksByUserId(Long id);
}
