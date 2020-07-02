package com.wizzstudio.database_homework.dto;

import com.wizzstudio.database_homework.entity.ClassEntity;

import java.util.Set;
import java.util.stream.Collectors;

public class ClassGetDto {
    private long classId;
    private String className;
    private Set<StudentGetDto> studentGetDtos;

    public static ClassGetDto fromEntity(ClassEntity classEntity) {
        ClassGetDto classGetDto=new ClassGetDto();
        classGetDto.setClassId(classEntity.getClassId());
        classGetDto.setClassName(classEntity.getClassName());
        classGetDto.setStudentGetDtos(classEntity.getStudentEntities().stream().map(StudentGetDto::fromEntity).collect(Collectors.toSet()));

        return classGetDto;
    }



    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Set<StudentGetDto> getStudentGetDtos() {
        return studentGetDtos;
    }

    public void setStudentGetDtos(Set<StudentGetDto> studentGetDtos) {
        this.studentGetDtos = studentGetDtos;
    }

    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }
}
