package com.demo.student.controller;

import com.demo.student.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: chenyuhao
 * @Date: 2019/7/12 14:24
 * @Version 1.0
 */
@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/test1")
    public void log1(){
        logService.log1();
    }

    @GetMapping("/test2")
    public void log2(){
        logService.log2();
    }

}
