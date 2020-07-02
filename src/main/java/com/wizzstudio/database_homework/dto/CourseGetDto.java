package com.wizzstudio.database_homework.dto;

import com.wizzstudio.database_homework.entity.CourseEntity;
import com.wizzstudio.database_homework.entity.ScoreEntity;

import java.util.List;
import java.util.stream.Collectors;

public class CourseGetDto {
    private long courseId;
    private String name;
    private Integer type;//0 -> 必修  1 -> 限选  2 -> 任选
    private double credit;//学分
    private long teacherId;
    private List<Long> scoresId;

    public static CourseGetDto fromEntity(CourseEntity courseEntity) {
        CourseGetDto courseGetDto = new CourseGetDto();
        courseGetDto.setCourseId(courseEntity.getCourseId());
        courseGetDto.setCredit(courseEntity.getCredit());
        courseGetDto.setName(courseEntity.getName());
        if (courseEntity.getScoreEntities() != null) {
            courseGetDto.setScoresId(courseEntity.getScoreEntities().stream().map(ScoreEntity::getScoreId).collect(Collectors.toList()));
        }
        courseGetDto.setTeacherId(courseEntity.getCourseId());
        courseGetDto.setType(courseEntity.getType());
        return courseGetDto;
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

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public List<Long> getScoresId() {
        return scoresId;
    }

    public void setScoresId(List<Long> scoresId) {
        this.scoresId = scoresId;
    }
}
