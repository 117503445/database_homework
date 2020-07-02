package com.wizzstudio.database_homework.dto;

import com.wizzstudio.database_homework.entity.ClassEntity;
import com.wizzstudio.database_homework.error.CustomException;
import com.wizzstudio.database_homework.util.RepositoryUtil;
import org.springframework.http.HttpStatus;

public class ClassSetDto {
    private String className;

    private long subjectId;
    private long ruleId;

    public ClassEntity toEntity() throws CustomException {

        var oSubject = RepositoryUtil.getSubjectRepository().findById(subjectId);

        if (oSubject.isEmpty()) {
            throw new CustomException(HttpStatus.NOT_FOUND, "Subject Not Found");
        }

        var oRule = RepositoryUtil.getRuleRepository().findById(ruleId);
        if (oRule.isEmpty()) {
            throw new CustomException(HttpStatus.NOT_FOUND, "Rule Not Found");
        }

        ClassEntity classEntity = new ClassEntity();
        classEntity.setClassName(className);
        classEntity.setSubjectEntity(oSubject.get());
        classEntity.setRuleEntity(oRule.get());
        return classEntity;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public long getRuleId() {
        return ruleId;
    }

    public void setRuleId(long ruleId) {
        this.ruleId = ruleId;
    }
}
