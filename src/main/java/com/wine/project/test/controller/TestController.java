package com.wine.project.test.controller;

import com.wine.project.test.dto.Abc;
import com.wine.project.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping("/queryAbc.do")
    public List<Abc> queryAbc(){
        return testService.queryAbc();
    }
}
