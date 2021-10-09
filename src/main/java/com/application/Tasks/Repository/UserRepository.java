package com.application.Tasks.Repository;

import com.application.Tasks.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    void deleteUserById(Long id);
//    Optional<User> findByUserName(String username);
//    User findUserById(Long id);
    User findUserByUsername(String username);
    User findUserByUsernameAndPassword(String username, String password);
}