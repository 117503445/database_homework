package com.wizzstudio.database_homework.dto;

import com.wizzstudio.database_homework.entity.SubjectEntity;
import com.wizzstudio.database_homework.error.CustomException;
import com.wizzstudio.database_homework.util.RepositoryUtil;
import org.springframework.http.HttpStatus;

public class SubjectSetDto {
    private long collegeId;
    private String name;

    public SubjectEntity toEntity() throws CustomException {

        var oCollege = RepositoryUtil.getCollegeRepository().findById(collegeId);
        if (oCollege.isEmpty()) {
            throw new CustomException(HttpStatus.NOT_FOUND, "College Not Found");
        }

        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setName(name);
        subjectEntity.setCollegeEntity(oCollege.get());
        return subjectEntity;
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
}
