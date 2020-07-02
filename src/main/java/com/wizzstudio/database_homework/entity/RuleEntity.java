package com.wizzstudio.database_homework.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "rule")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "classId")
public class RuleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "rule_id")
    private long ruleEntityId;

    private double maxBiXiuFailedCredit;//必修课允许最多挂多少学分
    private double maxXianXuanFailedCredit;//必修课允许最多挂多少学分
    private double maxRenXuanFailedCredit;//必修课允许最多挂多少学分

    @OneToMany(mappedBy = "ruleEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ClassEntity> classEntities;

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

    public Set<ClassEntity> getClassEntities() {
        return classEntities;
    }

    public void setClassEntities(Set<ClassEntity> classEntities) {
        this.classEntities = classEntities;
    }
}
