package com.demo.student.controller;

import com.demo.student.model.dto.DemoTest;
import com.demo.student.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: chenyuhao
 * @Date: 2019/7/15 18:34
 * @Version 1.0
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/queryAll")
    public List<DemoTest> queryAll(){
        return demoService.queryAll();
    }

    @PostMapping("/query")
    public List<DemoTest> query(@RequestBody  DemoTest demoTest){
        return demoService.queryByRequest(demoTest);
    }

    @PostMapping("/insert")
    public void insert(@RequestBody  DemoTest demoTest){
        demoService.insertDemo(demoTest);
    }

    @PutMapping("/update")
    public void update(@RequestBody  DemoTest demoTest){
        demoService.updateDemo(demoTest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        demoService.deleteById(id);
    }


}
