package com.wizzstudio.database_homework.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "course")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "courseId")
public class CourseEntity implements Comparable<CourseEntity> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "course_id", unique = true)
    private long courseId;


    @ManyToOne(targetEntity = ClassEntity.class)
    @JoinColumn(name = "class_id", referencedColumnName = "class_id", foreignKey = @ForeignKey(name = "fk_course_class"))
    private ClassEntity classEntity;

    @ManyToOne(targetEntity = TeacherEntity.class)
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id", foreignKey = @ForeignKey(name = "fk_course_teacher"))
    private TeacherEntity teacherEntity;

    @OneToMany(mappedBy = "courseEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ScoreEntity> scoreEntities;
    @Column(length = 10)
    private String name;

    private Integer type;//0 -> 必修  1 -> 限选  2 -> 任选

    private double credit;//学分

    public CourseEntity() {
    }

    public CourseEntity(String name, Integer type, double credit, ClassEntity classEntity, TeacherEntity teacherEntity) {
        this.name = name;
        this.type = type;
        this.credit = credit;
        this.classEntity = classEntity;
        this.teacherEntity = teacherEntity;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public ClassEntity getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(ClassEntity classEntity) {
        this.classEntity = classEntity;
    }

    public TeacherEntity getTeacherEntity() {
        return teacherEntity;
    }

    public void setTeacherEntity(TeacherEntity teacherEntity) {
        this.teacherEntity = teacherEntity;
    }

    public Set<ScoreEntity> getScoreEntities() {
        return scoreEntities;
    }

    public void setScoreEntities(Set<ScoreEntity> scoreEntities) {
        this.scoreEntities = scoreEntities;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    @Override
    public int compareTo(CourseEntity o) {
        return (int) (this.getCourseId() - o.getCourseId());
    }
}
