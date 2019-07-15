package com.demo.student.mapper;

import com.demo.student.model.dto.DemoTest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: chenyuhao
 * @Date: 2019/7/15 18:34
 * @Version 1.0
 */
public interface DemoMapper {

    public List<DemoTest> queryAll();

    public List<DemoTest> queryDemoTests(DemoTest demoTest);

    public void insert(DemoTest demoTest);

    public void update(DemoTest demoTest);

    public void deleteById(@Param("demoId") Long id);

}
