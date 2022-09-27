package com.dtshop.app.Repository;

import com.dtshop.app.Domain.DeliveryUnit;
import com.dtshop.app.Dto.DeliveryUnitDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryUnitRepository extends JpaRepository<DeliveryUnit, Long> {
    @Query("Select new com.dtshop.app.Dto.DeliveryUnitDto(entity, true) From DeliveryUnit entity Where (1=1) ")
    List<DeliveryUnitDto> getAllDto();
}
