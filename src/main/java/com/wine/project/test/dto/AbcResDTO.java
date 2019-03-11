package com.wine.project.test.dto;

import com.wine.common.message.ResponseDTO;

import java.util.List;

public class AbcResDTO extends ResponseDTO {

    private List<Abc> lists;

    public List<Abc> getLists() {
        return lists;
    }

    public void setLists(List<Abc> lists) {
        this.lists = lists;
    }
}
