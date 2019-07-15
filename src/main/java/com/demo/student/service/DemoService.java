package com.demo.student.service;

import com.demo.student.mapper.DemoMapper;
import com.demo.student.model.dto.DemoTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: chenyuhao
 * @Date: 2019/7/15 18:34
 * @Version 1.0
 */
@Service
public class DemoService {

    @Autowired
    private DemoMapper demoMapper;

    public List<DemoTest> queryAll(){
        return demoMapper.queryAll();
    }

    public List<DemoTest> queryByRequest(DemoTest demoTest){
        return demoMapper.queryDemoTests(demoTest);
    }

    public void insertDemo(DemoTest demoTest){
        demoMapper.insert(demoTest);
    }

    public void updateDemo(DemoTest demoTest){
        demoMapper.update(demoTest);
    }

    public void deleteById(Long id){
        demoMapper.deleteById(id);
    }

}
