package com.gvdroid.simple.logging.dto;

import com.gvdroidframework.base.component.Page;

import java.util.List;

public class CustomerResponseDTO {

    Page page;

    List<CustomerResponseSubDTO> dataList;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<CustomerResponseSubDTO> getDataList() {
        return dataList;
    }

    public void setDataList(List<CustomerResponseSubDTO> dataList) {
        this.dataList = dataList;
    }
}
