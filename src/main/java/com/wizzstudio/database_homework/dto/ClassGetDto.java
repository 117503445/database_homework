package com.wizzstudio.database_homework.dto;

import com.wizzstudio.database_homework.entity.ClassEntity;
import com.wizzstudio.database_homework.entity.StudentEntity;

import java.util.Set;
import java.util.stream.Collectors;

public class ClassGetDto {
    private long classId;
    private String className;
    private Set<Long> studentsId;

    public static ClassGetDto fromEntity(ClassEntity classEntity) {
        ClassGetDto classGetDto=new ClassGetDto();
        classGetDto.setClassId(classEntity.getClassId());
        classGetDto.setClassName(classEntity.getClassName());
        classGetDto.setStudentsId(classEntity.getStudentEntities().stream().map(StudentEntity::getStudentId).collect(Collectors.toSet()));

        return classGetDto;
    }



    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }


    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    public Set<Long> getStudentsId() {
        return studentsId;
    }

    public void setStudentsId(Set<Long> studentsId) {
        this.studentsId = studentsId;
    }
}
