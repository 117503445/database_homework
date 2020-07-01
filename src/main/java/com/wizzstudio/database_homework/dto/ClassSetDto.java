package com.wizzstudio.database_homework.dto;

import com.wizzstudio.database_homework.entity.ClassEntity;

public class ClassSetDto {
    private String className;

    public static ClassEntity toEntity(ClassSetDto classSetDto) {
        ClassEntity classEntity = new ClassEntity();
        classEntity.setClassName(classSetDto.getClassName());
        return classEntity;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
