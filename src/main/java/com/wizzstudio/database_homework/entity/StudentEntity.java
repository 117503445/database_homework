package com.wizzstudio.database_homework.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Set;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "studentId")
@Entity
@Table(name = "student")
public class StudentEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "student_id", unique = true)
    private long studentId;
    @Column(length = 10)
    private String name;

    private boolean isMale;

    private long birthDate;

    @ApiModelProperty("学号")
    private long studentNum;

    @ManyToOne(targetEntity = ClassEntity.class)
    @JoinColumn(name = "class_id", referencedColumnName = "class_id", foreignKey = @ForeignKey(name = "fk_student_class"))
    private ClassEntity classEntity;

    @OneToMany(mappedBy = "studentEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ScoreEntity> scoreEntities;

    public StudentEntity() {
    }

    public StudentEntity(String name, boolean isMale, long birthDate, long studentNum, ClassEntity classEntity) {
        this.name = name;
        this.isMale = isMale;
        this.birthDate = birthDate;
        this.studentNum = studentNum;
        this.classEntity = classEntity;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
    }

    public ClassEntity getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(ClassEntity classEntity) {
        this.classEntity = classEntity;
    }

    public long getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(long studentNum) {
        this.studentNum = studentNum;
    }

    public Set<ScoreEntity> getScoreEntities() {
        return scoreEntities;
    }

    public void setScoreEntities(Set<ScoreEntity> scoreEntities) {
        this.scoreEntities = scoreEntities;
    }
}
