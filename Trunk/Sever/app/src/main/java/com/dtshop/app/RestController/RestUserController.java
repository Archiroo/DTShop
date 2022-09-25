package com.dtshop.app.RestController;

import com.dtshop.app.Dto.FunctionDto.ResponseObject;
import com.dtshop.app.Dto.FunctionDto.SearchDto;
import com.dtshop.app.Dto.UserDto;
import com.dtshop.app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class RestUserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getAllDto", method = RequestMethod.GET)
    public List<UserDto> getAllDto() {
        return this.userService.getAllDto();
    }

    @RequestMapping(value = "/getPageDto/{pageIndex}/{pageSize}", method = RequestMethod.GET)
    public Page<UserDto> getPageDto(@PathVariable int pageIndex, @PathVariable int pageSize) {
        return this.userService.getPageDto(pageIndex, pageSize);
    }

    @RequestMapping(value = "/getEntity/{id}", method = RequestMethod.GET)
    public UserDto getEntity(@PathVariable Long id) {
        return this.userService.getEntity(id);
    }

    @RequestMapping(value = "/createDto", method = RequestMethod.POST)
    public UserDto createDto(@RequestBody UserDto userDto) {
        return this.userService.createDto(null, userDto);
    }

    @RequestMapping(value = "/updateDto/{id}", method = RequestMethod.PUT)
    public UserDto updateDto(@PathVariable Long id, @RequestBody UserDto userDto) {
        return this.userService.updateDto(id, userDto);
    }

    @RequestMapping(value = "/deleteDto/{id}", method = RequestMethod.DELETE)
    public UserDto deleteDto(@PathVariable Long id) {
        return this.userService.deleteDto(id);
    }

    @RequestMapping(value = "/searchByPage", method = RequestMethod.POST)
    public Page<UserDto> searchByPage(@RequestBody SearchDto searchDto) {
        return this.userService.seachByPage(searchDto);
    }



}
