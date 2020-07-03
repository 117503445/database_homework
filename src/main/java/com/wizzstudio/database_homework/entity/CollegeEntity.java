package com.wizzstudio.database_homework.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "college")
public class CollegeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "college_id", unique = true)
    private long collegeId;

    @Column(length = 10)
    private String name;

    @OneToMany(mappedBy = "collegeEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<SubjectEntity> subjectEntities;

    public CollegeEntity() {
    }

    public CollegeEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<SubjectEntity> getSubjectEntities() {
        return subjectEntities;
    }

    public void setSubjectEntities(Set<SubjectEntity> subjectEntities) {
        this.subjectEntities = subjectEntities;
    }

    public long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(long collegeId) {
        this.collegeId = collegeId;
    }
}
