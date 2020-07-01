package com.wizzstudio.database_homework.dto;

import com.wizzstudio.database_homework.entity.CollegeEntity;

public class CollegeSetDto {
    private String name;

    public CollegeEntity toEntity() {
        CollegeEntity collegeEntity = new CollegeEntity();
        collegeEntity.setName(name);
        return collegeEntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
