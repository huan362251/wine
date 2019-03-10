package com.wine.project.hello;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloController")
public class HelloController {

    @PostMapping(value = "/testHello.do")
    @Async
    public void testHello(){
        System.out.println(Thread.currentThread().getName());
    }
}
