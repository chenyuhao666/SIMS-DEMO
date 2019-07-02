package com.demo.student.util;

import org.apache.poi.hssf.usermodel.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chenyuhao
 * @Date: 2019/7/2 10:55
 * @Version 1.0
 */
public class ExcelUtil {

    public static HSSFWorkbook getHSSFWorkbook(String sheetName, String []title, List<Object> data , HSSFWorkbook wb) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if (wb == null) {
            wb = new HSSFWorkbook();
        }

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);

        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);

        //声明列对象
        HSSFCell cell = null;

        //创建标题
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
        }

        List<String> stringList = tranToString(data);
        for (int i = 0; i < stringList.size(); i++) {
            String d = stringList.get(i);
            String[] dataElements = d.split(",");
            row = sheet.createRow(i + 1);
            for(int j = 0 ; j < dataElements.length ; j ++){
                row.createCell(j).setCellValue(dataElements[j]);
            }

        }

        return wb;
    }

    public static List<String> tranToString(List<Object> objects) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<String> result = new ArrayList<>();
        for(Object object : objects){
            Class clazz = object.getClass();
            Field[] fields = clazz.getDeclaredFields();
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0 ; i < fields.length ; i ++){
                String filedName = fields[i].getName();
                Method method = clazz.getDeclaredMethod("get" +  (new StringBuilder()).append(Character.toUpperCase(filedName.charAt(0))).append(filedName.substring(1)).toString(),null);
                Object o = method.invoke(object);
                if(i == fields.length - 1){
                    stringBuilder.append(o.toString());
                }else{
                    stringBuilder.append(o.toString()).append(",");
                }
            }
            result.add(stringBuilder.toString());
        }
        return result;
    }

}
