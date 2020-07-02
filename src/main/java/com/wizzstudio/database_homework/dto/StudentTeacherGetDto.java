package com.wizzstudio.database_homework.dto;

import com.wizzstudio.database_homework.entity.CourseEntity;

public class StudentTeacherGetDto {
    private String courseName;
    private String teacherName;

    public static StudentTeacherGetDto fromCourseEntity(CourseEntity courseEntity) {
        StudentTeacherGetDto studentTeacherGetDto = new StudentTeacherGetDto();
        studentTeacherGetDto.setCourseName(courseEntity.getName());
        studentTeacherGetDto.setTeacherName(courseEntity.getTeacherEntity().getName());
        return studentTeacherGetDto;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
