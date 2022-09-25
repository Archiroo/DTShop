package com.dtshop.app.Service;

import com.dtshop.app.Domain.Role;
import com.dtshop.app.Domain.RoleUser;
import com.dtshop.app.Domain.User;
import com.dtshop.app.Dto.FunctionDto.ResponseObject;
import com.dtshop.app.Dto.FunctionDto.SearchDto;
import com.dtshop.app.Dto.UserDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    List<UserDto> getAllDto();

    Page<UserDto> getPageDto(int pageIndex, int pageSize);

    UserDto getEntity(Long id);

    UserDto getUserByUsername(String username);

    UserDto createDto(Long id, UserDto dto);

    UserDto updateDto(Long id, UserDto dto);

    UserDto deleteDto(Long id);

    Page<UserDto> seachByPage(SearchDto searchDto);
}
