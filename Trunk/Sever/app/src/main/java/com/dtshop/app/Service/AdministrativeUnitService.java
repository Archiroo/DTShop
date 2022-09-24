package com.dtshop.app.Service;

import com.dtshop.app.Domain.AdministrativeUnit;
import com.dtshop.app.Dto.AdministrativeUnitDto;
import com.dtshop.app.Dto.FunctionDto.ResponseObject;
import com.dtshop.app.Dto.FunctionDto.SearchDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AdministrativeUnitService {
    List<AdministrativeUnitDto> getAllDto();

    List<AdministrativeUnit> getAllProvince();

    List<AdministrativeUnit> getAllByParentId(Long id);

    List<AdministrativeUnitDto> saveList(List<AdministrativeUnitDto> listAdministrative);

    AdministrativeUnitDto getEntity(Long id);

    Boolean checkCode(String code);

    AdministrativeUnitDto createDto(Long id, AdministrativeUnitDto dto);

    AdministrativeUnitDto updateDto(Long id, AdministrativeUnitDto dto);

    AdministrativeUnitDto deleteDto(Long id);

    Page<AdministrativeUnitDto> getPageDto(int pageIndex, int pageSize);

    Page<AdministrativeUnitDto> searchByPage(SearchDto searchDto);



}
