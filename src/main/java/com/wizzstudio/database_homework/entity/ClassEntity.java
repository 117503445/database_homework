package com.wizzstudio.database_homework.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "class")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "classId")
public class ClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "class_id")
    private long classId;

    //    @OneToMany(targetEntity = StudentEntity.class, fetch = FetchType.EAGER)
//    @JoinColumn(name = "student_id",referencedColumnName = "class_id")
//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @OneToMany(mappedBy = "classEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<StudentEntity> studentEntities;

    @OneToMany(mappedBy = "classEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<CourseEntity> courseEntities;

    private String className;

    @ManyToOne(targetEntity = SubjectEntity.class)
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    private SubjectEntity subjectEntity;

    @ManyToOne(targetEntity = RuleEntity.class)
    @JoinColumn(name = "rule_id", referencedColumnName = "rule_id")
    private RuleEntity ruleEntity;

    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }


    public Set<StudentEntity> getStudentEntities() {
        return studentEntities;
    }

    public void setStudentEntities(Set<StudentEntity> studentEntities) {
        this.studentEntities = studentEntities;
    }

    public Set<CourseEntity> getCourseEntities() {
        return courseEntities;
    }

    public void setCourseEntities(Set<CourseEntity> courseEntities) {
        this.courseEntities = courseEntities;
    }

    public SubjectEntity getSubjectEntity() {
        return subjectEntity;
    }

    public void setSubjectEntity(SubjectEntity subjectEntity) {
        this.subjectEntity = subjectEntity;
    }

    public RuleEntity getRuleEntity() {
        return ruleEntity;
    }

    public void setRuleEntity(RuleEntity ruleEntity) {
        this.ruleEntity = ruleEntity;
    }
}
