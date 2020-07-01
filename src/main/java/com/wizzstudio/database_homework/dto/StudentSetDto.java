package com.wizzstudio.database_homework.dto;

import com.wizzstudio.database_homework.entity.StudentEntity;
import com.wizzstudio.database_homework.error.CustomException;
import com.wizzstudio.database_homework.util.RepositoryUtil;
import org.springframework.http.HttpStatus;

public class StudentSetDto {
    private String name;

    private boolean isMale;

    private long birthDate;

    private long classId;

    private long studentNum;//学号

    public static StudentEntity toEntity(StudentSetDto studentSetDto) throws CustomException {

        var oClass = RepositoryUtil.getClassRepository().findById(studentSetDto.classId);

        if (oClass.isEmpty()) {
            throw new CustomException(HttpStatus.NOT_FOUND, "Class Not Found");
        }

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setBirthDate(studentSetDto.getBirthDate());
        studentEntity.setMale(studentSetDto.isMale);
        studentEntity.setName(studentSetDto.getName());
        studentEntity.setStudentNum(studentSetDto.studentNum);

        studentEntity.setClassEntity(oClass.get());

        return studentEntity;
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

    public long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
    }

    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    public long getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(long studentNum) {
        this.studentNum = studentNum;
    }
}
