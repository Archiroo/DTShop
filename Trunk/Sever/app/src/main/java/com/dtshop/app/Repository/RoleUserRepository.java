package com.dtshop.app.Repository;

import com.dtshop.app.Domain.Role;
import com.dtshop.app.Domain.RoleUser;
import com.dtshop.app.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleUserRepository extends JpaRepository<RoleUser, Long> {
    @Query("Select entity.user From RoleUser entity Where entity.user.username = ?1")
    User getUserByUsername(String username);
}
