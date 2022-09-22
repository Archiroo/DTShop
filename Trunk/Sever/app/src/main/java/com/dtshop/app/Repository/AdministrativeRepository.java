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
    @Query("Select new com.dtshop.app.Dto.AdministrativeUnitDto(entity, true) From AdministrativeUnit entity " +
            "Where (1=1) Order by entity.dateCreate DESC")
    List<AdministrativeUnitDto> getAllDto();

    @Query("Select count(entity.id) From AdministrativeUnit entity where entity.code = ?1")
    Long checkCode(String code);

    @Query("Select new com.dtshop.app.Dto.AdministrativeUnitDto(entity, true) From AdministrativeUnit entity " +
            "Where (1=1) Order by entity.dateCreate DESC")
    Page<AdministrativeUnitDto> getPageDto(Pageable pageable);

    @Query("Select entity From AdministrativeUnit entity " +
            " Where (1=1) AND entity.parent.id is NULL Or entity.parent.id = 0" +
            " Order by entity.dateCreate DESC")
    List<AdministrativeUnit> getAllProvince();

    @Query("Select entity From AdministrativeUnit entity " +
            " Where (1=1) AND entity.parent.id = ?1 " +
            " Order by entity.dateCreate DESC")
    List<AdministrativeUnit> getAllByParentId(Long parentId);

}
