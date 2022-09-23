package com.dtshop.app.Repository;

import com.dtshop.app.Domain.User;
import com.dtshop.app.Dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("Select new com.dtshop.app.Dto.UserDto(entity, true) From User entity Where (1=1)")
    List<UserDto> getAllDto();
    @Query("Select new com.dtshop.app.Dto.UserDto(entity, true) From User entity Where (1=1)")
    Page<UserDto> getPageDto(Pageable pageable);

    @Query("Select entity From User entity Where entity.id = ?1")
    User getEntity(Long id);

}
