package com.dtshop.app.Dto;

import com.dtshop.app.Domain.User;

import java.time.LocalDateTime;

public class UserDto {
    private Long id;
    private LocalDateTime dateCreate;
    private String username;
    private String password;

    private Integer level;
    private Integer active;

    public UserDto() {

    }

    public UserDto(User entity) {
        this.id = entity.getId();
        this.dateCreate = entity.getDateCreate();
        this.username = entity.getUsername();
        this.password = entity.getPassword();
        this.level = entity.getLevel();
        this.active = entity.getActive();
    }

    public UserDto(User entity, boolean arc) {
        this.id = entity.getId();
        this.dateCreate = entity.getDateCreate();
        this.username = entity.getUsername();
        this.password = entity.getPassword();
        this.level = entity.getLevel();
        this.active = entity.getActive();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}
