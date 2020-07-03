package com.wizzstudio.database_homework.dto;

import com.wizzstudio.database_homework.entity.RuleEntity;

public class RuleSetDto {
    private double maxBiXiuFailedCredit;//必修课允许最多挂多少学分
    private double maxXianXuanFailedCredit;//限选课允许最多挂多少学分
    private double maxRenXuanFailedCredit;//任选课允许最多挂多少学分

    private double minBiXiuCredit;//必修课最少要修多少学分
    private double minXianXuanCredit;//限选课最少要修多少学分
    private double minRenXuanCredit;//任选课最少要修多少学分

    public RuleEntity toEntity() {
        RuleEntity ruleEntity = new RuleEntity();
        ruleEntity.setMaxBiXiuFailedCredit(maxBiXiuFailedCredit);
        ruleEntity.setMaxRenXuanFailedCredit(maxXianXuanFailedCredit);
        ruleEntity.setMaxXianXuanFailedCredit(maxRenXuanFailedCredit);

        ruleEntity.setMinBiXiuCredit(minBiXiuCredit);
        ruleEntity.setMinXianXuanCredit(minXianXuanCredit);
        ruleEntity.setMinRenXuanCredit(minRenXuanCredit);
        return ruleEntity;
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
