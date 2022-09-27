package com.dtshop.app.Dto;

import com.dtshop.app.Domain.DeliveryUnit;

import java.time.LocalDateTime;

public class DeliveryUnitDto {
    private Long id;
    private LocalDateTime dateCreate;
    private String name;
    private String description;
    private Integer status;
    private AdministrativeUnitDto administrativeUnitDto;

    public DeliveryUnitDto() {

    }

    public DeliveryUnitDto(DeliveryUnit entity) {
        this.id = entity.getId();
        this.dateCreate = entity.getDateCreate();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.status = entity.getStatus();
        if(entity.getAdministrativeUnit() != null) {
            this.administrativeUnitDto = new AdministrativeUnitDto(entity.getAdministrativeUnit(), true);
        }
    }

    public DeliveryUnitDto(DeliveryUnit entity, boolean arc) {
        this.id = entity.getId();
        this.dateCreate = entity.getDateCreate();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.status = entity.getStatus();
        if(entity.getAdministrativeUnit() != null) {
            this.administrativeUnitDto = new AdministrativeUnitDto(entity.getAdministrativeUnit(), true);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public AdministrativeUnitDto getAdministrativeUnitDto() {
        return administrativeUnitDto;
    }

    public void setAdministrativeUnitDto(AdministrativeUnitDto administrativeUnitDto) {
        this.administrativeUnitDto = administrativeUnitDto;
    }
}
