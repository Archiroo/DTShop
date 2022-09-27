package com.dtshop.app.Service.ServiceImpl;

import com.dtshop.app.Domain.AdministrativeUnit;
import com.dtshop.app.Domain.DeliveryUnit;
import com.dtshop.app.Dto.DeliveryUnitDto;
import com.dtshop.app.Dto.FunctionDto.SearchDto;
import com.dtshop.app.Repository.AdministrativeRepository;
import com.dtshop.app.Repository.DeliveryUnitRepository;
import com.dtshop.app.Service.DeliveryUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryUnitServiceImpl implements DeliveryUnitService {

    @Autowired
    private DeliveryUnitRepository deliveryUnitRepos;

    @Autowired
    private AdministrativeRepository administrativeRepos;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<DeliveryUnitDto> getAllDto() {
        return this.deliveryUnitRepos.getAllDto();
    }

    @Override
    public Page<DeliveryUnitDto> searchByPage(SearchDto searchDto) {
        if(searchDto != null && searchDto.getPageIndex() != null && searchDto.getPageSize() != null) {
            int pageIndex = searchDto.getPageIndex();
            int pageSize = searchDto.getPageSize();
            if(pageIndex > 0) {
                pageIndex = pageIndex - 1;
            } else {
                pageIndex = 0;
            }
            Pageable pageable = PageRequest.of(pageIndex, pageSize);
            String sql = "Select new com.dtshop.app.Dto.DeliveryUnitDto(entity, true) From DeliveryUnit entity Where (1=1) ";
            String sqlCount = "Select count(entity.id) From DeliveryUnit entity Where (1=1) ";
            String whereClause = "";
            String orderBy = " Order by entity.dateCreate DESC";
            if(searchDto.getNameOrCode() != null) {
                whereClause += " entity.name Like :textSearch ";
            }
            sql += whereClause + orderBy;
            sqlCount += whereClause;

            Query q = manager.createQuery(sql, DeliveryUnitDto.class);
            Query qCount = manager.createQuery(sqlCount);
            if(searchDto.getNameOrCode() != null) {
                q.setParameter("textSearch", "%" + searchDto.getNameOrCode() + "%");
                qCount.setParameter("textSearch", "%" + searchDto.getNameOrCode() + "%");
            }
            q.setFirstResult(pageIndex * pageSize);
            q.setMaxResults(pageSize);
            Long numberResult = (Long) qCount.getSingleResult();
            Page<DeliveryUnitDto> page = new PageImpl<>(q.getResultList(), pageable, numberResult);
            return page;

        }
        return null;
    }

    @Override
    public DeliveryUnitDto createDto(Long id, DeliveryUnitDto dto) {
        return this.updateDto(id, dto);
    }

    @Override
    public DeliveryUnitDto updateDto(Long id, DeliveryUnitDto dto) {
        DeliveryUnit entity = null;
        LocalDateTime dateCreate = LocalDateTime.now();
        if(id != null) {
            Optional<DeliveryUnit> deliveryUnitOptional = this.deliveryUnitRepos.findById(id);
            if(deliveryUnitOptional.isPresent()) {
                entity = deliveryUnitOptional.get();
            }
        }
        else if(dto != null && dto.getId() != null) {
            Optional<DeliveryUnit> deliveryUnitOptional = this.deliveryUnitRepos.findById(id);
            if(deliveryUnitOptional.isPresent()) {
                entity = deliveryUnitOptional.get();
            }
        }
        if(entity == null) {
            entity = new DeliveryUnit();
            entity.setDateCreate(dateCreate);
        }
        if(dto.getName() != null) {
            entity.setName(dto.getName());
        }
        if(dto.getDescription() != null) {
            entity.setDescription(dto.getDescription());
        }
        if(dto.getStatus() != null) {
            entity.setStatus(dto.getStatus());
        }
        if(dto.getAdministrativeUnitDto() != null) {
            AdministrativeUnit administrativeUnit = null;
            if(dto.getAdministrativeUnitDto().getId() != null) {
                Optional<AdministrativeUnit> administrativeUnitOptional = this.administrativeRepos.findById(dto.getAdministrativeUnitDto().getId());
                if(administrativeUnitOptional.isPresent()) {
                    administrativeUnit = administrativeUnitOptional.get();
                    entity.setAdministrativeUnit(administrativeUnit);
                }
            }
        }
        entity = this.deliveryUnitRepos.save(entity);
        return new DeliveryUnitDto(entity, true);
    }

    @Override
    public DeliveryUnitDto deleteDto(Long id) {
        DeliveryUnit entity = null;
        if(id != null) {
            Optional<DeliveryUnit> deliveryUnitOptional = this.deliveryUnitRepos.findById(id);
            if(deliveryUnitOptional.isPresent()) {
                entity = deliveryUnitOptional.get();
                this.deliveryUnitRepos.delete(entity);
                return new DeliveryUnitDto(entity, true);
            }
        }
        return null;
    }


}
