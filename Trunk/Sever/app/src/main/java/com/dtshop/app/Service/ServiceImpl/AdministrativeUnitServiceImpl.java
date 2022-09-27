package com.dtshop.app.Service.ServiceImpl;

import com.dtshop.app.Domain.AdministrativeUnit;
import com.dtshop.app.Domain.User;
import com.dtshop.app.Dto.AdministrativeUnitDto;
import com.dtshop.app.Dto.FunctionDto.ResponseObject;
import com.dtshop.app.Dto.FunctionDto.SearchDto;
import com.dtshop.app.Repository.AdministrativeRepository;
import com.dtshop.app.Service.AdministrativeUnitService;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdministrativeUnitServiceImpl implements AdministrativeUnitService {

    @Autowired
    private AdministrativeRepository administrativeRepos;

    @PersistenceContext
    private EntityManager manager;


    @Override
    public List<AdministrativeUnitDto> getAllDto() {
        return this.administrativeRepos.getAllDto();
    }

    @Override
    public List<AdministrativeUnit> getAllProvince() {
        return this.administrativeRepos.getAllProvince();
    }

    @Override
    public List<AdministrativeUnit> getAllByParentId(Long id) {
        if(id != null) {
            List<AdministrativeUnit> result = this.administrativeRepos.getAllByParentId(id);
            return result;
        }
        return null;
    }

    @Override
    public List<AdministrativeUnitDto> saveList(List<AdministrativeUnitDto> listAdministrative) {
        ArrayList<AdministrativeUnitDto> ret = new ArrayList<AdministrativeUnitDto>();
        for(int i=0; i<listAdministrative.size(); i++) {
            AdministrativeUnitDto dto = listAdministrative.get(i);
            this.updateDto(dto.getId(), dto);
        }
        return ret;
    }

    @Override
    public AdministrativeUnitDto getEntity(Long id) {
        AdministrativeUnit entity = null;
        if(id != null) {
            Optional<AdministrativeUnit> administrativeUnitOptional = this.administrativeRepos.findById(id);
            if(administrativeUnitOptional.isPresent()) {
                entity = administrativeUnitOptional.get();
                return new AdministrativeUnitDto(entity, true);
            }
        }
        return null;
    }

    @Override
    public Boolean checkCode(String code) {
        if(code != null) {
            Long numberResult = this.administrativeRepos.checkCode(code);
            if(numberResult == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public AdministrativeUnitDto createDto(Long id, AdministrativeUnitDto dto) {
        return this.updateDto(null, dto);
    }

    @Override
    public AdministrativeUnitDto updateDto(Long id, AdministrativeUnitDto dto) {
        LocalDateTime dateCreate = LocalDateTime.now();
        User modifiedUser = null;
        String currentUserName = "Unknown User";
        AdministrativeUnit entity = null;
        if(id != null) {
            Optional<AdministrativeUnit> administrativeUnitOptional = this.administrativeRepos.findById(id);
            if(administrativeUnitOptional.isPresent()) {
                entity = administrativeUnitOptional.get();
            }
        } else if(dto != null && dto.getId() != null) {
            Optional<AdministrativeUnit> administrativeUnitOptional = this.administrativeRepos.findById(dto.getId());
            if(administrativeUnitOptional.isPresent()) {
                entity = administrativeUnitOptional.get();
            }
        }
        if(entity == null) {
            entity = new AdministrativeUnit();
            entity.setDateCreate(dateCreate);
        }
        if(dto.getCode() != null) {
            entity.setCode(dto.getCode());
        }
        if(dto.getName() != null) {
            entity.setName(dto.getName());
        }
        // Parent
        if(dto.getParent() != null) {
            AdministrativeUnit parentEntity = null;
            if(dto.getParent().getId() != null) {
                Optional<AdministrativeUnit> auParent = this.administrativeRepos.findById(dto.getParent().getId());
                if(auParent.isPresent()) {
                    parentEntity = auParent.get();
                    entity.setParent(parentEntity);
                    if(parentEntity.getLevel() != null && parentEntity.getLevel() > 0) {
                        entity.setLevel(parentEntity.getLevel() + 1);
                    }
                }
            }
        } else {
            entity.setLevel(1); // Cấp tỉnh
            entity.setParent(null);
        }
        this.administrativeRepos.save(entity);
        return new AdministrativeUnitDto(entity, true);
    }

    @Override
    public AdministrativeUnitDto deleteDto(Long id) {
        AdministrativeUnit entity = null;
        if(id != null) {
            Optional<AdministrativeUnit> administrativeUnitOptional = this.administrativeRepos.findById(id);
            if(administrativeUnitOptional.isPresent()) {
                entity = administrativeUnitOptional.get();
                this.administrativeRepos.delete(entity);
                return new AdministrativeUnitDto(entity, true);
            }
        }
        return null;
    }

    @Override
    public Page<AdministrativeUnitDto> getPageDto(int pageIndex, int pageSize) {
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        return this.administrativeRepos.getPageDto(pageable);
    }

    @Override
    public Page<AdministrativeUnitDto> searchByPage(SearchDto searchDto) {
        if(searchDto != null && searchDto.getPageIndex() != null && searchDto.getPageSize() != null) {
            int pageIndex = searchDto.getPageIndex();
            int pageSize = searchDto.getPageSize();
            if(pageIndex > 0) {
                pageIndex = pageIndex - 1;
            } else {
                pageIndex = 0;
            }
            Pageable pageable = PageRequest.of(pageIndex, pageSize);
            String sql = "Select new com.dtshop.app.Dto.AdministrativeUnitDto(entity, true) From AdministrativeUnit entity where (1=1)";
            String sqlCount = "Select count(entity.id) From AdministrativeUnit entity Where (1=1) ";
            String whereClause = "";
            String orderBy = " Order by entity.dateCreate DESC";
            if(searchDto.getNameOrCode() != null) {
                whereClause += " And entity.code Like :nameOrCode Or entity.name Like :nameOrCode ";
            }
            sql += whereClause + orderBy;
            sqlCount = whereClause;
            Query q = manager.createQuery(sql, AdministrativeUnitDto.class);
            Query qCount = manager.createQuery(sqlCount);
            if(searchDto.getNameOrCode() != null) {
                q.setParameter("nameOrCode", "%" + searchDto.getNameOrCode() + "%");
                qCount.setParameter("nameOrCode", "%" + searchDto.getNameOrCode() + "%");
            }
            q.setFirstResult(pageIndex*pageSize);
            q.setMaxResults(pageSize);
            Long numberResult = (Long) qCount.getSingleResult();
            Page<AdministrativeUnitDto> page = new PageImpl<>(q.getResultList(), pageable, numberResult);
            return page;
        }
        return null;
    }
}
