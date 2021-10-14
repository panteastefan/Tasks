package com.application.Tasks.Repository;

import com.application.Tasks.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
    User findUserByUsernameAndPassword(String username, String password);
    boolean existsUserByUsername(String username);

}