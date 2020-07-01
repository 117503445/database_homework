package com.wizzstudio.database_homework.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "subject")
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "subject_id")
    private long subjectId;

    @OneToMany(mappedBy = "subjectEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ClassEntity> classEntities;

    private String name;

    @ManyToOne(targetEntity = CollegeEntity.class)
    @JoinColumn(name = "college_id", referencedColumnName = "college_id")
    private CollegeEntity collegeEntity;

    public Set<ClassEntity> getClassEntities() {
        return classEntities;
    }

    public void setClassEntities(Set<ClassEntity> classEntities) {
        this.classEntities = classEntities;
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

    public CollegeEntity getCollegeEntity() {
        return collegeEntity;
    }

    public void setCollegeEntity(CollegeEntity collegeEntity) {
        this.collegeEntity = collegeEntity;
    }
}
