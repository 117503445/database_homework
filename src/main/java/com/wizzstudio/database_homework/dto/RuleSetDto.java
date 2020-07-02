package com.wizzstudio.database_homework.dto;

import com.wizzstudio.database_homework.entity.RuleEntity;

public class RuleSetDto {
    private double maxBiXiuFailedCredit;//必修课允许最多挂多少学分
    private double maxXianXuanFailedCredit;//必修课允许最多挂多少学分
    private double maxRenXuanFailedCredit;//必修课允许最多挂多少学分

    public RuleEntity toEntity() {
        RuleEntity ruleEntity = new RuleEntity();
        ruleEntity.setMaxBiXiuFailedCredit(maxBiXiuFailedCredit);
        ruleEntity.setMaxRenXuanFailedCredit(maxXianXuanFailedCredit);
        ruleEntity.setMaxXianXuanFailedCredit(maxRenXuanFailedCredit);
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
}
