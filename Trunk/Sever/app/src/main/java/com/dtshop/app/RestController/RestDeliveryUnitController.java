package com.dtshop.app.RestController;

import com.dtshop.app.Dto.DeliveryUnitDto;
import com.dtshop.app.Dto.FunctionDto.SearchDto;
import com.dtshop.app.Service.DeliveryUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/delivery_unit")
public class RestDeliveryUnitController {
    @Autowired
    private DeliveryUnitService deliveryUnitService;

    @RequestMapping(value = "/getAllDto", method = RequestMethod.GET)
    public List<DeliveryUnitDto> getAllDto() {
        return this.deliveryUnitService.getAllDto();
    }

    @RequestMapping(value = "/searchByPage", method = RequestMethod.POST)
    public Page<DeliveryUnitDto> getAllDto(@RequestBody SearchDto searchDto) {
        return this.deliveryUnitService.searchByPage(searchDto);
    }

    @RequestMapping(value = "/createDto", method = RequestMethod.POST)
    public DeliveryUnitDto createDto(@RequestBody DeliveryUnitDto dto) {
        return this.deliveryUnitService.createDto(null, dto);
    }

    @RequestMapping(value = "/updateDto/{id}", method = RequestMethod.PUT)
    public DeliveryUnitDto updateDto(@PathVariable Long id, @RequestBody DeliveryUnitDto dto) {
        return this.deliveryUnitService.updateDto(id, dto);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public DeliveryUnitDto deleteDto(@PathVariable Long id) {
        return this.deliveryUnitService.deleteDto(id);
    }
}
