package com.wizzstudio.database_homework.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "course")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "course_id")
    private long courseId;


    @ManyToOne(targetEntity = ClassEntity.class)
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    private ClassEntity classEntity;

    @ManyToOne(targetEntity = TeacherEntity.class)
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
    private TeacherEntity teacherEntity;

    @OneToMany(mappedBy = "courseEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ScoreEntity> scoreEntities;

    private String name;

    private Integer type;//0 -> 必修  1 -> 限选  2 -> 任选

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
}
