package com.dtshop.app.Dto;

import com.dtshop.app.Domain.AdministrativeUnit;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class AdministrativeUnitDto {
    private Long id;
    private LocalDateTime dateCreate;
    private String code;
    private String name;
    private Integer level;
    private AdministrativeUnitDto parent;
    private Set<AdministrativeUnitDto> childrenAdministrative;

    public AdministrativeUnitDto() {

    }

    public AdministrativeUnitDto(AdministrativeUnit entity) {
        this.id = entity.getId();
        this.dateCreate = entity.getDateCreate();
        this.code = entity.getCode();
        this.name = entity.getName();
        this.level = entity.getLevel();
        // Paren
        if(entity.getParent() != null) {
            AdministrativeUnit entityParent = new AdministrativeUnit();
            entityParent.setId(entity.getParent().getId());
            entityParent.setDateCreate(entity.getParent().getDateCreate());
            entityParent.setCode(entity.getParent().getCode());
            entityParent.setName(entity.getParent().getName());
            entityParent.setLevel(entity.getParent().getLevel());
            this.parent = new AdministrativeUnitDto(entityParent);
        }
        // Children
        Set<AdministrativeUnitDto> administrativeUnitDtos = new HashSet<AdministrativeUnitDto>();
        if(entity != null && entity.getChildrenAdministrative() != null
            && entity.getChildrenAdministrative().size() > 0) {
            for(AdministrativeUnit au : entity.getChildrenAdministrative()) {
                AdministrativeUnitDto auDto = new AdministrativeUnitDto();
                auDto.setId(au.getId());
                auDto.setDateCreate(au.getDateCreate());
                auDto.setCode(au.getCode());
                auDto.setName(au.getName());
                auDto.setLevel(au.getLevel());
                administrativeUnitDtos.add(auDto);
            }
            this.childrenAdministrative = administrativeUnitDtos;
        }
    }

    public AdministrativeUnitDto(AdministrativeUnit entity, boolean arc) {
        this.id = entity.getId();
        this.dateCreate = entity.getDateCreate();
        this.code = entity.getCode();
        this.name = entity.getName();
        this.level = entity.getLevel();
        // Paren
        if(entity.getParent() != null) {
            AdministrativeUnit entityParent = new AdministrativeUnit();
            entityParent.setId(entity.getParent().getId());
            entityParent.setDateCreate(entity.getParent().getDateCreate());
            entityParent.setCode(entity.getParent().getCode());
            entityParent.setName(entity.getParent().getName());
            entityParent.setLevel(entity.getParent().getLevel());
            this.parent = new AdministrativeUnitDto(entityParent);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public AdministrativeUnitDto getParent() {
        return parent;
    }

    public void setParent(AdministrativeUnitDto parent) {
        this.parent = parent;
    }

    public Set<AdministrativeUnitDto> getChildrenAdministrative() {
        return childrenAdministrative;
    }

    public void setChildrenAdministrative(Set<AdministrativeUnitDto> childrenAdministrative) {
        this.childrenAdministrative = childrenAdministrative;
    }
}
