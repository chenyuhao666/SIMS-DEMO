package com.demo.student.service;

import com.demo.student.common.StudentDB;
import com.demo.student.model.dto.StudentDTO;
import org.springframework.stereotype.Service;

/**
 * @Author: chenyuhao
 * @Date: 2019/7/2 10:35
 * @Version 1.0
 */
@Service
public class StudentService {

    public void addStudent(StudentDTO studentDTO){
        StudentDB.addStudent(studentDTO);
    }

}
