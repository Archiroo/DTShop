package com.dtshop.app.Repository;

import com.dtshop.app.Domain.RoleUser;
import com.dtshop.app.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleUserRepository extends JpaRepository<RoleUser, Long> {
    @Query("Select entity From RoleUser entity Where entity.user.id = ?1")
    RoleUser getUserByUsername(String username);
}
