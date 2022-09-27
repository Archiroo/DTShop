package com.dtshop.app.Service;

import com.dtshop.app.Dto.DeliveryUnitDto;
import com.dtshop.app.Dto.FunctionDto.SearchDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DeliveryUnitService {
    List<DeliveryUnitDto> getAllDto();

    Page<DeliveryUnitDto> searchByPage(SearchDto searchDto);

    DeliveryUnitDto createDto(Long id, DeliveryUnitDto dto);

    DeliveryUnitDto updateDto(Long id, DeliveryUnitDto dto);

    DeliveryUnitDto deleteDto(Long id);
}
