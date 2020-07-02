package com.wizzstudio.database_homework.dto;

import com.wizzstudio.database_homework.entity.ScoreEntity;

public class StudentScoreGetDto {
    private long scoreId;
    private double firstScore;
    private double secondScore;
    private String courseName;
    private Integer courseType;
    private double courseCredit;

    public static StudentScoreGetDto fromScoreEntity(ScoreEntity scoreEntity) {
        StudentScoreGetDto studentScoreGetDto = new StudentScoreGetDto();
        studentScoreGetDto.setScoreId(scoreEntity.getScoreId());

        var courseEntity=scoreEntity.getCourseEntity();
        studentScoreGetDto.setCourseName(courseEntity.getName());
        studentScoreGetDto.setCourseCredit(courseEntity.getCredit());
        studentScoreGetDto.setCourseType(courseEntity.getType());


        studentScoreGetDto.setFirstScore(scoreEntity.getFirstScore());
        studentScoreGetDto.setSecondScore(scoreEntity.getSecondScore());

        return studentScoreGetDto;
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

    public void setSecondScore(double secondScore) {
        this.secondScore = secondScore;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCourseType() {
        return courseType;
    }

    public void setCourseType(Integer courseType) {
        this.courseType = courseType;
    }

    public double getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(double courseCredit) {
        this.courseCredit = courseCredit;
    }
}
