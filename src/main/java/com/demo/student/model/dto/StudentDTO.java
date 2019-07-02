package com.demo.student.model.dto;

/**
 * @Author: chenyuhao
 * @Date: 2019/7/2 10:30
 * @Version 1.0
 */
public class StudentDTO {

    private Integer id;
    private String studentName;
    private Integer age;

    public StudentDTO(Integer id, String studentName, Integer age) {
        this.id = id;
        this.studentName = studentName;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", age=" + age +
                '}';
    }
}
