package com.wizzstudio.database_homework.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "guide")
public class ScoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "score_id")
    private long scoreId;

    private double credit;//学分

    private double firstScore = -1;//正考成绩,未考试为-1

    private double secondScore = -1;//补考成绩,未考试为-1

    @ManyToOne(targetEntity = StudentEntity.class)
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private StudentEntity studentEntity;

    @ManyToOne(targetEntity = CourseEntity.class)
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    private CourseEntity courseEntity;

    public long getScoreId() {
        return scoreId;
    }

    public void setScoreId(long scoreId) {
        this.scoreId = scoreId;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getFirstScore() {
        return firstScore;
    }

    public void setFirstScore(double firstScore) {
        this.firstScore = firstScore;
    }

    public double getSecondScore() {
        return secondScore;
    }

    public void setSecondScore(double secondScore) {
        this.secondScore = secondScore;
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }


    public CourseEntity getCourseEntity() {
        return courseEntity;
    }

    public void setCourseEntity(CourseEntity courseEntity) {
        this.courseEntity = courseEntity;
    }
}
