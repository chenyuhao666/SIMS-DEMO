package com.demo.student.controller;

import com.demo.student.service.LogService;
import com.demo.student.test.LogTest;
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

    @Autowired
    private LogTest logTest;

    @GetMapping("/test1")
    public void log1(){
        logTest.log999();
    }

    @GetMapping("/test2")
    public void log2(){
        logService.log2();
    }

}
