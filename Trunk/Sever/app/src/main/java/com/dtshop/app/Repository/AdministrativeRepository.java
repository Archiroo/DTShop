package com.dtshop.app.Repository;

import com.dtshop.app.Domain.AdministrativeUnit;
import com.dtshop.app.Dto.AdministrativeUnitDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministrativeRepository extends JpaRepository<AdministrativeUnit, Long> {
    @Query("Select new com.dtshop.app.Dto.AdministrativeUnitDto(entity, true) AdministrativeUnit Where (1=1)")
    List<AdministrativeUnitDto> getAllDto();

    @Query("Select count(entity.id) From AdministrativeUnit entity where entity.code = ?1")
    Long checkCode(String code);

    @Query("Select new com.dtshop.app.Dto.AdministrativeUnitDto(entity, true) From AdministrativeUnit entity order by entity.id desc")
    Page<AdministrativeUnitDto> getPageDto(Pageable pageable);
}
