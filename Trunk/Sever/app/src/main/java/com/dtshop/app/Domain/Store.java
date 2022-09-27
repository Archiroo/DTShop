package com.dtshop.app.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="tbl_store")
@XmlRootElement

public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="date_create")
    private LocalDateTime dateCreate;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User user; // Thông tin chủ cửa hàng

    @ManyToOne
    @JoinColumn(name="parent_id")
    private Store parent; // Đơn vị cha

    @JsonIgnore
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Store> childrenStore; // Đơn vị con

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Store getParent() {
        return parent;
    }

    public void setParent(Store parent) {
        this.parent = parent;
    }

    public Set<Store> getChildrenStore() {
        return childrenStore;
    }

    public void setChildrenStore(Set<Store> childrenStore) {
        this.childrenStore = childrenStore;
    }
}
