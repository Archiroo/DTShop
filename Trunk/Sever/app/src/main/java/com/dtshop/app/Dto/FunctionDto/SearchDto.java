package com.dtshop.app.Dto.FunctionDto;

public class SearchDto {
    private Integer pageIndex;
    private Integer pageSize;
    private String nameOrCode;

    private Integer numberSearch;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getNameOrCode() {
        return nameOrCode;
    }

    public void setNameOrCode(String nameOrCode) {
        this.nameOrCode = nameOrCode;
    }

    public Integer getNumberSearch() {
        return numberSearch;
    }

    public void setNumberSearch(Integer numberSearch) {
        this.numberSearch = numberSearch;
    }
}
