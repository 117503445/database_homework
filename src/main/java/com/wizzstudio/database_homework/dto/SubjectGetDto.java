package com.wizzstudio.database_homework.dto;

import com.wizzstudio.database_homework.entity.ClassEntity;
import com.wizzstudio.database_homework.entity.SubjectEntity;

import java.util.List;
import java.util.stream.Collectors;

public class SubjectGetDto {
    private long subjectId;
    private String name;
    private long collegeId;
    private List<Long> classesId;

    public static SubjectGetDto fromEntity(SubjectEntity subjectEntity) {
        SubjectGetDto subjectGetDto = new SubjectGetDto();
        subjectGetDto.setSubjectId(subjectEntity.getSubjectId());
        subjectGetDto.setCollegeId(subjectEntity.getCollegeEntity().getCollegeId());
        subjectGetDto.setName(subjectEntity.getName());
        if (subjectEntity.getClassEntities() != null) {
            subjectGetDto.setClassesId(subjectEntity.getClassEntities().stream().map(ClassEntity::getClassId).collect(Collectors.toList()));
        }
        return subjectGetDto;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(long collegeId) {
        this.collegeId = collegeId;
    }

    public List<Long> getClassesId() {
        return classesId;
    }

    public void setClassesId(List<Long> classesId) {
        this.classesId = classesId;
    }
}
