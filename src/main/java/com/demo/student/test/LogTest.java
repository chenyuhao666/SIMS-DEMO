package com.demo.student.test;

import com.demo.student.config.aop.LogPrinter;
import org.springframework.stereotype.Service;

@Service
public class LogTest {

    @LogPrinter
    public void log999(){
        System.out.println("log999执行中");
    }

}
