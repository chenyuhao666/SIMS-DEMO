package com.demo.student.controller;

import com.demo.student.model.dto.StudentDTO;
import com.demo.student.service.StudentService;
import com.demo.student.util.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: chenyuhao
 * @Date: 2019/7/2 10:34
 * @Version 1.0
 */

@RestController
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/export")
    public void getTest(HttpServletRequest request, HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        List<Object> studentDTOS = new ArrayList<>();
        studentDTOS.add(new StudentDTO(1,"jack",20));
        studentDTOS.add(new StudentDTO(2,"ben",20));
        studentDTOS.add(new StudentDTO(3,"alex",20));
        String[] titles = {"学号","姓名","年龄"};
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook("学生信息表",titles,studentDTOS,null);
        String fileName = "学生信息表"+System.currentTimeMillis()+".xls";
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @GetMapping("/import")
    public void StudentImport(@RequestParam("file") MultipartFile file) throws IOException {
        Map<String, String> mapper = new HashMap<>();
        mapper.put("学号","id");
        mapper.put("姓名","studentName");
        mapper.put("年龄","age");
        studentService.importStudent(file);
    }

    @GetMapping("/get")
    public List<StudentDTO> getStudents(){
        return studentService.getStudents();
    }

    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



}
