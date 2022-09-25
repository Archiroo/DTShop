package com.dtshop.app.Dto;


import com.dtshop.app.Domain.FileUpload;

public class FileUploadDto {
    private Long id;
    private String name;
    private String type;
    private byte[] data;

    public FileUploadDto() {

    }

    public FileUploadDto(FileUpload entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.type = entity.getType();
        this.data = entity.getData();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
