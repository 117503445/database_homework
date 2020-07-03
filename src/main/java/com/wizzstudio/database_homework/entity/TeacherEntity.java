package com.wizzstudio.database_homework.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "teacher")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "teacherId")
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "teacher_id", unique = true)
    private long teacherId;

    @Column(length = 10)
    private String name;
    private boolean isMale;

    @OneToMany(mappedBy = "teacherEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<CourseEntity> courseEntities;

    public TeacherEntity() {
    }

    /**
     * 默认 isMale = true
     *
     * @param name 老师姓名
     */
    public TeacherEntity(String name) {
        this.name = name;
        isMale = true;
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

    public Set<CourseEntity> getCourseEntities() {
        return courseEntities;
    }

    public void setCourseEntities(Set<CourseEntity> courseEntities) {
        this.courseEntities = courseEntities;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }
}
