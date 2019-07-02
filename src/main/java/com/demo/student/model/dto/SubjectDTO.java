package com.demo.student.model.dto;

/**
 * @Author: chenyuhao
 * @Date: 2019/7/2 10:32
 * @Version 1.0
 */
public class SubjectDTO {

    private String subjectName;
    private String subjectScore;

    public SubjectDTO(String subjectName, String subjectScore) {
        this.subjectName = subjectName;
        this.subjectScore = subjectScore;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectScore() {
        return subjectScore;
    }

    public void setSubjectScore(String subjectScore) {
        this.subjectScore = subjectScore;
    }
}
