package com.wizzstudio.database_homework.dto;

import com.wizzstudio.database_homework.entity.StudentEntity;
import io.swagger.annotations.ApiModelProperty;

public class StudentGetDto {

    private long studentId;

    private String name;

    private boolean isMale;

    private long birthDate;

    private String className;

    private String subjectName;

    private String collegeName;

    @ApiModelProperty("学号")
    private long studentNum;


    public static StudentGetDto fromEntity(StudentEntity studentEntity) {
        StudentGetDto studentGetDto = new StudentGetDto();

        var classEntity = studentEntity.getClassEntity();
        var subjectEntity = classEntity.getSubjectEntity();
        var collegeEntity = subjectEntity.getCollegeEntity();

        studentGetDto.setClassName(classEntity.getClassName());

        studentGetDto.setSubjectName(subjectEntity.getName());

        studentGetDto.setCollegeName(collegeEntity.getName());

        studentGetDto.setStudentId(studentEntity.getStudentId());
        studentGetDto.setBirthDate(studentEntity.getBirthDate());
        studentGetDto.setMale(studentEntity.isMale());
        studentGetDto.setName(studentEntity.getName());
        studentGetDto.setStudentNum(studentEntity.getStudentNum());
        return studentGetDto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
    }

    public long getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(long studentNum) {
        this.studentNum = studentNum;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }
}
