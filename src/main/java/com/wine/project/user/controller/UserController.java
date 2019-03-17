package com.wine.project.user.controller;

import com.wine.common.message.ResponseDTO;
import com.wine.project.user.dto.LoginReqDTO;
import com.wine.project.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @Author LIUHUAN
 * @Description
 * @Date Created by  2019/3/17 17:20
 **/
@RestController
public class UserController {

    private Logger logger =  LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login.do",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDTO login(@RequestBody LoginReqDTO dto){
        logger.info("login",dto.toString());
        System.out.println("login");
        ResponseDTO responseDTO = new ResponseDTO();

        responseDTO = userService.login(dto);

        return responseDTO;

    }
}
