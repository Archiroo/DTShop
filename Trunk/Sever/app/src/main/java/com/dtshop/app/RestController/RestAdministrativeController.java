package com.dtshop.app.RestController;

import com.dtshop.app.Domain.AdministrativeUnit;
import com.dtshop.app.Dto.AdministrativeUnitDto;
import com.dtshop.app.Dto.FunctionDto.ResponseObject;
import com.dtshop.app.Dto.FunctionDto.SearchDto;
import com.dtshop.app.Service.AdministrativeUnitService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/administrative_unit")
public class RestAdministrativeController {
    @Autowired
    private AdministrativeUnitService administrativeUnitService;

    @RequestMapping(value = "/getAllDto", method = RequestMethod.GET)
    public List<AdministrativeUnitDto> getAllDto() {
        return this.administrativeUnitService.getAllDto();
    }

    @RequestMapping(value = "/getAllProvince", method = RequestMethod.GET)
    public List<AdministrativeUnit> getAllProvince() {
        return this.administrativeUnitService.getAllProvince();
    }

    @RequestMapping(value = "/getAllByParentId/{id}", method = RequestMethod.GET)
    public List<AdministrativeUnit> getAllByParentId(@PathVariable Long id) {
        return this.administrativeUnitService.getAllByParentId(id);
    }

    @RequestMapping(value = "/getEntity/{id}", method = RequestMethod.GET)
    public ResponseObject getEntity(@PathVariable Long id) {
        return this.administrativeUnitService.getEntity(id);
    }

    @RequestMapping(value = "/checkCode", method = RequestMethod.POST)
    public Boolean checkCode(@RequestBody SearchDto dto) {
        String code = null;
        if(dto != null && dto.getNameOrCode() != null) {
            code = dto.getNameOrCode();
        }
        return this.administrativeUnitService.checkCode(code);
    }

    @RequestMapping(value = "/createDto", method = RequestMethod.POST)
    public AdministrativeUnitDto createDto(@RequestBody AdministrativeUnitDto dto) {
        return this.administrativeUnitService.createDto(null, dto);
    }

    @RequestMapping(value = "/updateDto/{id}", method = RequestMethod.PUT)
    public AdministrativeUnitDto updateDto(@PathVariable Long id, @RequestBody AdministrativeUnitDto dto) {
        return this.administrativeUnitService.updateDto(id, dto);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseObject deleteDto(@PathVariable Long id) {
        return this.administrativeUnitService.deleteDto(id);
    }

    @RequestMapping(value = "/page/{pageIndex}/{pageSize}", method = RequestMethod.GET)
    public Page<AdministrativeUnitDto> getPageDto(@PathVariable Integer pageIndex, @PathVariable Integer pageSize) {
        return this.administrativeUnitService.getPageDto(pageIndex, pageSize);
    }

    @RequestMapping(value = "/searchByPage")
    public Page<AdministrativeUnitDto> searchByPage(@RequestBody SearchDto searchDto) {
        return this.administrativeUnitService.searchByPage(searchDto);
    }
}
