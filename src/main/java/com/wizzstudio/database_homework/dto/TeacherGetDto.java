package com.wizzstudio.database_homework.dto;

import com.wizzstudio.database_homework.entity.CourseEntity;
import com.wizzstudio.database_homework.entity.TeacherEntity;

import java.util.List;
import java.util.stream.Collectors;

public class TeacherGetDto {
    private long teacherId;
    private String name;
    private boolean isMale;
    private List<Long> coursesId;

    public static TeacherGetDto fromEntity(TeacherEntity teacherEntity) {
        TeacherGetDto teacherGetDto = new TeacherGetDto();
        teacherGetDto.setMale(teacherEntity.isMale());
        teacherGetDto.setName(teacherEntity.getName());
        teacherGetDto.setTeacherId(teacherEntity.getTeacherId());
        teacherGetDto.setCoursesId(teacherEntity.getCourseEntities().stream().map(CourseEntity::getCourseId).collect(Collectors.toList()));
        return teacherGetDto;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
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

    public List<Long> getCoursesId() {
        return coursesId;
    }

    public void setCoursesId(List<Long> coursesId) {
        this.coursesId = coursesId;
    }
}
