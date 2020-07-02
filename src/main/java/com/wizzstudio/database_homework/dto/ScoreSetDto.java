package com.wizzstudio.database_homework.dto;

import com.wizzstudio.database_homework.entity.ScoreEntity;
import com.wizzstudio.database_homework.error.CustomException;
import com.wizzstudio.database_homework.util.RepositoryUtil;
import org.springframework.http.HttpStatus;

public class ScoreSetDto {

    private double firstScore = -1;//正考成绩,未考试为-1

    private double secondScore = -1;//补考成绩,未考试为-1

    private long studentId;

    private long courseId;

    public ScoreEntity toEntity() throws CustomException {

        var oStudent = RepositoryUtil.getStudentRepository().findById(studentId);

        if (oStudent.isEmpty()) {
            throw new CustomException(HttpStatus.NOT_FOUND, "Student Not Found");
        }

        var oCourse = RepositoryUtil.getCourseRepository().findById(courseId);
        if (oCourse.isEmpty()) {
            throw new CustomException(HttpStatus.NOT_FOUND, "Course Not Found");
        }

        ScoreEntity scoreEntity = new ScoreEntity();
        scoreEntity.setFirstScore(firstScore);
        scoreEntity.setSecondScore(secondScore);

        scoreEntity.setStudentEntity(oStudent.get());
        scoreEntity.setCourseEntity(oCourse.get());

        return scoreEntity;
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
