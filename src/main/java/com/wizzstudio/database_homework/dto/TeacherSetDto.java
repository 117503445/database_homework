package com.wizzstudio.database_homework.dto;

import com.wizzstudio.database_homework.entity.TeacherEntity;

public class TeacherSetDto {
    private String name;
    private boolean isMale;

    public TeacherEntity toEntity() {
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setMale(isMale);
        teacherEntity.setName(name);
        return teacherEntity;
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
}
