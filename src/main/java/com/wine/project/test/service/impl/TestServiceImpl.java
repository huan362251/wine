package com.wine.project.test.service.impl;

import com.wine.project.test.dao.TestDao;
import com.wine.project.test.dto.AbcResDTO;
import com.wine.project.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao dao;

    @Override
    public AbcResDTO queryAbc() {
        AbcResDTO resDTO = new AbcResDTO();
        resDTO.setLists(dao.queryAbc());
        return resDTO;
    }
}
