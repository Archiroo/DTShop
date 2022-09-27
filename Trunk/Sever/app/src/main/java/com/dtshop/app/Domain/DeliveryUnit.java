package com.dtshop.app.Domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@Entity
@Table(name="tbl_delivery_unit")
@XmlRootElement
public class DeliveryUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="date_create")
    private LocalDateTime dateCreate;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name="administrative_unit_id")
    private AdministrativeUnit administrativeUnit;

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

    public AdministrativeUnit getAdministrativeUnit() {
        return administrativeUnit;
    }

    public void setAdministrativeUnit(AdministrativeUnit administrativeUnit) {
        this.administrativeUnit = administrativeUnit;
    }
}
