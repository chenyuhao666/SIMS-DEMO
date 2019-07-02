package com.demo.student.common;

import com.demo.student.model.dto.StudentDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chenyuhao
 * @Date: 2019/7/2 10:35
 * @Version 1.0
 */
@Component
public class StudentDB {

    private final static List<StudentDTO> studentDTOList  = new ArrayList<>();

    public static List<StudentDTO> getStudentDTOList(){
        return studentDTOList;
    }

    public static void addStudent(StudentDTO studentDTO){
        studentDTOList.add(studentDTO);
    }

}
