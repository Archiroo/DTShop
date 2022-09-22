package com.dtshop.app.Service;

import com.dtshop.app.Domain.AdministrativeUnit;
import com.dtshop.app.Dto.AdministrativeUnitDto;
import com.dtshop.app.Dto.FunctionDto.ResponseObject;
import com.dtshop.app.Dto.FunctionDto.SearchDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AdministrativeService {
    List<AdministrativeUnitDto> getAllDto();

    List<AdministrativeUnitDto> saveList(List<AdministrativeUnitDto> listAdministrative);

    ResponseObject getEntity(Long id);

    AdministrativeUnitDto createDto(Long id, AdministrativeUnitDto dto);

    AdministrativeUnitDto updateDto(Long id, AdministrativeUnitDto dto);

    ResponseObject deleteDto(Long id);

    Page<AdministrativeUnitDto> getPageDto(int pageIndex, int pageSize);

    Page<AdministrativeUnitDto> searchByPage(SearchDto searchDto);



}
