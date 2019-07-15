package com.demo.student.model.dto;

import java.util.Date;

/**
 * @Author: chenyuhao
 * @Date: 2019/7/15 18:32
 * @Version 1.0
 */
public class DemoTest {

    private Long id;

    private String name;

    private Integer number;

    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
