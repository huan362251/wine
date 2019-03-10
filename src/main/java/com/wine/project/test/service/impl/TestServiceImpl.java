package com.wine.project.test.service.impl;

import com.wine.project.test.dao.TestDao;
import com.wine.project.test.dto.Abc;
import com.wine.project.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao dao;

    @Override
    public List<Abc> queryAbc() {
        return dao.queryAbc();
    }
}
