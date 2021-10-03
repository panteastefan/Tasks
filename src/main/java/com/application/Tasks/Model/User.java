package com.application.Tasks.Model;
import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    private @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue
    Long id;

    @Column(name = "user_name")
    private String userName;
    private String password;
    private String name;

    public User(String userName, String password, String name) {
        this.userName = userName;
        this.password = password;
        this.name = name;
    }

    @OneToMany(mappedBy = "user")
    private Set<Task> tasks;

    public User(Long id, String name, Set<Task> tasks) {
        this.id = id;
        this.name = name;
        this.tasks = tasks;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public Set<Task> getTasks() {
        return tasks;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}