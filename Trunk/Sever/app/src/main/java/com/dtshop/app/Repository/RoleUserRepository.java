package com.dtshop.app.Repository;

import com.dtshop.app.Domain.Role;
import com.dtshop.app.Domain.RoleUser;
import com.dtshop.app.Domain.User;
import com.dtshop.app.Dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleUserRepository extends JpaRepository<RoleUser, Long> {
    @Query("Select new com.dtshop.app.Dto.UserDto(entity.user, true) From RoleUser entity Where entity.user.username = ?1")
    UserDto getUserByUsername(String username);
}
