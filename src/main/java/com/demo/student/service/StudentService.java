package com.demo.student.service;

import com.demo.student.common.StudentDB;
import com.demo.student.model.dto.StudentDTO;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<StudentDTO> getStudents(){
        return StudentDB.getStudentDTOList();
    }

    public void importStudent(MultipartFile file) throws IOException {
        String fileName=file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        Workbook wb=null;
        InputStream is=file.getInputStream();
        if(suffix.equals("xlsx")){
            wb = new XSSFWorkbook(is);
        }else if(suffix.equals("xls")){
            wb = new HSSFWorkbook(is);
        }

        Map<Integer,String> titles = new HashMap<>();
        List<String[]> valueList = new ArrayList<>();

        //**获得第一个sheet/
        Sheet sheet=wb.getSheetAt(0);
        int totalRows = sheet.getPhysicalNumberOfRows();
        Row row=null;
        int totalCells=0;
        for(int i = 0 ; i < totalRows ; i ++){
            row=sheet.getRow(i);
            totalCells= row.getPhysicalNumberOfCells();

            String[] values = new String[totalCells];
            for(int j = 0 ; j < totalCells ; j ++){
                if(row.getCell(j) != null){
                    row.getCell(j).setCellType(CellType.STRING);
                    values[j] = row.getCell(j).getStringCellValue();
                }
            }
            valueList.add(values);
        }

        for(int i = 0 ; i < valueList.size() ; i ++){
            if(i != 0){
                StudentDTO studentDTO = new StudentDTO(Integer.parseInt(valueList.get(i)[0]), valueList.get(i)[1] ,Integer.parseInt(valueList.get(i)[2]));
                addStudent(studentDTO);
            }
        }
    }

}
