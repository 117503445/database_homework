package com.wizzstudio.database_homework.dto;

import io.swagger.annotations.ApiModelProperty;

public class DataSetDto {
    @ApiModelProperty("学生姓名")
    private String studentName;
    @ApiModelProperty("学生学号")
    private long studentNum;
    @ApiModelProperty("学生性别")
    private boolean studentIsMale;
    @ApiModelProperty("学生出生日期时间戳")
    private long studentBirthDate;
    @ApiModelProperty("学院名")
    private String collegeName;
    @ApiModelProperty("专业名")
    private String subjectName;
    @ApiModelProperty("班级名")
    private String className;

    @ApiModelProperty("语文老师名")
    private String chineseTeacherName;
    @ApiModelProperty("语文正考成绩")
    private double chineseFirstScore;
    @ApiModelProperty("语文补考成绩")
    private double chineseSecondScore;

    private String mathTeacherName;
    private double mathFirstScore;
    private double mathSecondScore;

    private String englishTeacherName;
    private double englishFirstScore;
    private double englishSecondScore;

    private String xianXuanTeacherName;
    private double xianXuanFirstScore;
    private double xianXuanSecondScore;

    private String renXuanTeacherName;
    private double renXuanFirstScore;
    private double renXuanSecondScore;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getChineseTeacherName() {
        return chineseTeacherName;
    }

    public void setChineseTeacherName(String chineseTeacherName) {
        this.chineseTeacherName = chineseTeacherName;
    }

    public double getChineseFirstScore() {
        return chineseFirstScore;
    }

    public void setChineseFirstScore(double chineseFirstScore) {
        this.chineseFirstScore = chineseFirstScore;
    }

    public double getChineseSecondScore() {
        return chineseSecondScore;
    }

    public void setChineseSecondScore(double chineseSecondScore) {
        this.chineseSecondScore = chineseSecondScore;
    }

    public String getMathTeacherName() {
        return mathTeacherName;
    }

    public void setMathTeacherName(String mathTeacherName) {
        this.mathTeacherName = mathTeacherName;
    }

    public double getMathFirstScore() {
        return mathFirstScore;
    }

    public void setMathFirstScore(double mathFirstScore) {
        this.mathFirstScore = mathFirstScore;
    }

    public double getMathSecondScore() {
        return mathSecondScore;
    }

    public void setMathSecondScore(double mathSecondScore) {
        this.mathSecondScore = mathSecondScore;
    }

    public String getEnglishTeacherName() {
        return englishTeacherName;
    }

    public void setEnglishTeacherName(String englishTeacherName) {
        this.englishTeacherName = englishTeacherName;
    }

    public double getEnglishFirstScore() {
        return englishFirstScore;
    }

    public void setEnglishFirstScore(double englishFirstScore) {
        this.englishFirstScore = englishFirstScore;
    }

    public double getEnglishSecondScore() {
        return englishSecondScore;
    }

    public void setEnglishSecondScore(double englishSecondScore) {
        this.englishSecondScore = englishSecondScore;
    }

    public String getXianXuanTeacherName() {
        return xianXuanTeacherName;
    }

    public void setXianXuanTeacherName(String xianXuanTeacherName) {
        this.xianXuanTeacherName = xianXuanTeacherName;
    }

    public double getXianXuanFirstScore() {
        return xianXuanFirstScore;
    }

    public void setXianXuanFirstScore(double xianXuanFirstScore) {
        this.xianXuanFirstScore = xianXuanFirstScore;
    }

    public double getXianXuanSecondScore() {
        return xianXuanSecondScore;
    }

    public void setXianXuanSecondScore(double xianXuanSecondScore) {
        this.xianXuanSecondScore = xianXuanSecondScore;
    }

    public String getRenXuanTeacherName() {
        return renXuanTeacherName;
    }

    public void setRenXuanTeacherName(String renXuanTeacherName) {
        this.renXuanTeacherName = renXuanTeacherName;
    }

    public double getRenXuanFirstScore() {
        return renXuanFirstScore;
    }

    public void setRenXuanFirstScore(double renXuanFirstScore) {
        this.renXuanFirstScore = renXuanFirstScore;
    }

    public double getRenXuanSecondScore() {
        return renXuanSecondScore;
    }

    public void setRenXuanSecondScore(double renXuanSecondScore) {
        this.renXuanSecondScore = renXuanSecondScore;
    }

    public boolean isStudentIsMale() {
        return studentIsMale;
    }

    public void setStudentIsMale(boolean studentIsMale) {
        this.studentIsMale = studentIsMale;
    }

    public long getStudentBirthDate() {
        return studentBirthDate;
    }

    public void setStudentBirthDate(long studentBirthDate) {
        this.studentBirthDate = studentBirthDate;
    }

    public long getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(long studentNum) {
        this.studentNum = studentNum;
    }
}
