package com.wizzstudio.database_homework.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.wizzstudio.database_homework.error.CustomException;
import org.hibernate.annotations.Check;
import org.springframework.http.HttpStatus;

import javax.persistence.*;

@Entity
@Table(name = "score")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "scoreId")
@Check(constraints = "first_score <= 100 and second_score <= 100 and ((first_score = -1 and second_score = -1) or (first_score > -1 and second_score = -1) or (first_score > -1 and second_score > -1))")
public class ScoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "score_id", unique = true)
    private long scoreId;

    private double firstScore = -1;//正考成绩,未考试为-1

    private double secondScore = -1;//补考成绩,未考试为-1

    @ManyToOne(targetEntity = StudentEntity.class)
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", foreignKey = @ForeignKey(name = "fk_score_student"))
    private StudentEntity studentEntity;

    @ManyToOne(targetEntity = CourseEntity.class)
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", foreignKey = @ForeignKey(name = "fk_score_course"))
    private CourseEntity courseEntity;

    public ScoreEntity() {
    }

    public ScoreEntity(double firstScore, double secondScore, StudentEntity studentEntity, CourseEntity courseEntity) throws CustomException {
        setFirstScore(firstScore);
        setSecondScore(secondScore);
        setStudentEntity(studentEntity);
        setCourseEntity(courseEntity);
    }

    public long getScoreId() {
        return scoreId;
    }

    public void setScoreId(long scoreId) {
        this.scoreId = scoreId;
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

    public void setSecondScore(double secondScore) throws CustomException {
        if (secondScore >= 0 && firstScore < 0) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "不允许在正考前进行补考");
        }
        if (firstScore >= 60 && secondScore >= 0) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "正考及格不允许补考");
        }
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
