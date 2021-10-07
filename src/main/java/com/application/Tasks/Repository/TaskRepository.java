package com.application.Tasks.Repository;

import com.application.Tasks.Model.Task;
import com.application.Tasks.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
//    void deleteTaskById(Long id);
//    Task findTaskById(Long id);
    List<Task> findTasksByUserId(Long id);
}
