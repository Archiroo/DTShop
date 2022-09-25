package com.dtshop.app.Dto;

import com.dtshop.app.Domain.Role;
import com.dtshop.app.Domain.RoleUser;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

public class RoleDto {
    private Long id;
    private String name;

    public RoleDto() {

    }

    public RoleDto(Role entity) {
        this.id = entity.getId();
        this.name = entity.getName();
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
}
