package com.wine.project.test.controller;

import com.wine.project.test.dto.AbcResDTO;
import com.wine.project.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping(value = "/queryAbc.do" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public AbcResDTO queryAbc(){
        return testService.queryAbc();
    }
}
