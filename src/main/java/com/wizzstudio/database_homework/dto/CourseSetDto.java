package com.wizzstudio.database_homework.dto;

import com.wizzstudio.database_homework.entity.CourseEntity;
import com.wizzstudio.database_homework.error.CustomException;
import com.wizzstudio.database_homework.util.RepositoryUtil;
import org.springframework.http.HttpStatus;

public class CourseSetDto {

    private String name;

    private Integer type;//0 -> 必修  1 -> 限选  2 -> 任选

    private long classId;
    private long teacherId;

    public CourseEntity toEntity() throws CustomException {

        var oClass = RepositoryUtil.getClassRepository().findById(classId);

        if (oClass.isEmpty()) {
            throw new CustomException(HttpStatus.NOT_FOUND, "Class Not Found");
        }

        var oTeacher = RepositoryUtil.getTeacherRepository().findById(teacherId);
        if (oTeacher.isEmpty()) {
            throw new CustomException(HttpStatus.NOT_FOUND, "Teacher Not Found");
        }

        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setName(name);
        courseEntity.setType(type);
        courseEntity.setClassEntity(oClass.get());
        courseEntity.setTeacherEntity(oTeacher.get());

        return courseEntity;
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

    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }
}
