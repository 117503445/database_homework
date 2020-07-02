package com.wizzstudio.database_homework.dto;

import com.wizzstudio.database_homework.entity.CollegeEntity;
import com.wizzstudio.database_homework.entity.SubjectEntity;

import java.util.List;
import java.util.stream.Collectors;

public class CollegeGetDto {
    private long collegeId;
    private String name;
    private List<Long> subjectsId;

    public static CollegeGetDto fromEntity(CollegeEntity collegeEntity) {
        CollegeGetDto collegeGetDto = new CollegeGetDto();
        collegeGetDto.setName(collegeEntity.getName());
        collegeGetDto.setCollegeId(collegeEntity.getCollegeId());
        if (collegeEntity.getSubjectEntities() != null) {
            collegeGetDto.setSubjectsId(collegeEntity.getSubjectEntities().stream().map(SubjectEntity::getSubjectId).collect(Collectors.toList()));
        }
        return collegeGetDto;
    }

    public long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(long collegeId) {
        this.collegeId = collegeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Long> getSubjectsId() {
        return subjectsId;
    }

    public void setSubjectsId(List<Long> subjectsId) {
        this.subjectsId = subjectsId;
    }
}
