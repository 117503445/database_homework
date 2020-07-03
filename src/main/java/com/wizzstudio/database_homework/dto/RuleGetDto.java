package com.wizzstudio.database_homework.dto;

import com.wizzstudio.database_homework.entity.ClassEntity;
import com.wizzstudio.database_homework.entity.RuleEntity;

import java.util.List;
import java.util.stream.Collectors;

public class RuleGetDto {
    private long ruleEntityId;

    private double maxBiXiuFailedCredit;//必修课允许最多挂多少学分
    private double maxXianXuanFailedCredit;//限选课允许最多挂多少学分
    private double maxRenXuanFailedCredit;//任选课允许最多挂多少学分

    private double minBiXiuCredit;//必修课最少要修多少学分
    private double minXianXuanCredit;//限选课最少要修多少学分
    private double minRenXuanCredit;//任选课最少要修多少学分

    private List<Long> classesId;

    public static RuleGetDto fromEntity(RuleEntity ruleEntity) {
        RuleGetDto ruleGetDto = new RuleGetDto();
        ruleGetDto.setMaxBiXiuFailedCredit(ruleEntity.getMaxBiXiuFailedCredit());
        if (ruleEntity.getClassEntities() != null) {
            ruleGetDto.setClassesId(ruleEntity.getClassEntities().stream().map(ClassEntity::getClassId).collect(Collectors.toList()));
        }
        ruleGetDto.setMaxRenXuanFailedCredit(ruleEntity.getMaxRenXuanFailedCredit());
        ruleGetDto.setMaxXianXuanFailedCredit(ruleEntity.getMaxXianXuanFailedCredit());
        ruleGetDto.setRuleEntityId(ruleEntity.getRuleEntityId());

        ruleGetDto.setMinBiXiuCredit(ruleEntity.getMinBiXiuCredit());
        ruleGetDto.setMinXianXuanCredit(ruleEntity.getMinXianXuanCredit());
        ruleGetDto.setMinRenXuanCredit(ruleEntity.getMinRenXuanCredit());

        return ruleGetDto;
    }

    public long getRuleEntityId() {
        return ruleEntityId;
    }

    public void setRuleEntityId(long ruleEntityId) {
        this.ruleEntityId = ruleEntityId;
    }

    public double getMaxBiXiuFailedCredit() {
        return maxBiXiuFailedCredit;
    }

    public void setMaxBiXiuFailedCredit(double maxBiXiuFailedCredit) {
        this.maxBiXiuFailedCredit = maxBiXiuFailedCredit;
    }

    public double getMaxXianXuanFailedCredit() {
        return maxXianXuanFailedCredit;
    }

    public void setMaxXianXuanFailedCredit(double maxXianXuanFailedCredit) {
        this.maxXianXuanFailedCredit = maxXianXuanFailedCredit;
    }

    public double getMaxRenXuanFailedCredit() {
        return maxRenXuanFailedCredit;
    }

    public void setMaxRenXuanFailedCredit(double maxRenXuanFailedCredit) {
        this.maxRenXuanFailedCredit = maxRenXuanFailedCredit;
    }

    public List<Long> getClassesId() {
        return classesId;
    }

    public void setClassesId(List<Long> classesId) {
        this.classesId = classesId;
    }

    public double getMinBiXiuCredit() {
        return minBiXiuCredit;
    }

    public void setMinBiXiuCredit(double minBiXiuCredit) {
        this.minBiXiuCredit = minBiXiuCredit;
    }

    public double getMinXianXuanCredit() {
        return minXianXuanCredit;
    }

    public void setMinXianXuanCredit(double minXianXuanCredit) {
        this.minXianXuanCredit = minXianXuanCredit;
    }

    public double getMinRenXuanCredit() {
        return minRenXuanCredit;
    }

    public void setMinRenXuanCredit(double minRenXuanCredit) {
        this.minRenXuanCredit = minRenXuanCredit;
    }
}
