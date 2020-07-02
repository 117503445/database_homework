package com.wizzstudio.database_homework.dto;

import com.wizzstudio.database_homework.entity.ScoreEntity;

public class ScoreGetDto {
    private long scoreId;
    private double firstScore;
    private double secondScore;
    private long studentId;
    private long courseId;

    public static ScoreGetDto fromEntity(ScoreEntity scoreEntity) {
        ScoreGetDto scoreGetDto = new ScoreGetDto();
        scoreGetDto.setScoreId(scoreEntity.getScoreId());

        scoreGetDto.setCourseId(scoreEntity.getCourseEntity().getCourseId());
        scoreGetDto.setStudentId(scoreEntity.getStudentEntity().getStudentId());

        scoreGetDto.setFirstScore(scoreEntity.getFirstScore());
        scoreGetDto.setSecondScore(scoreEntity.getSecondScore());

        return scoreGetDto;

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

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }
}
