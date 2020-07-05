package com.wizzstudio.database_homework.controller;

import com.wizzstudio.database_homework.dto.DataSetDto;
import com.wizzstudio.database_homework.entity.*;
import com.wizzstudio.database_homework.error.CustomException;
import com.wizzstudio.database_homework.util.RepositoryUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@RequestMapping("/data")
@RestController
public class DataController {
    @ApiOperation("录入学生的数据")
    @PostMapping
    public ResponseEntity<Long> save(@RequestBody DataSetDto dataSetDto) throws CustomException {

        if (dataSetDto.getStudentName().equals("测试数据")) {
            return ResponseEntity.ok(-1L);
        }

        TeacherEntity chineseTeacher;
        var oChineseTeacher = RepositoryUtil.getTeacherRepository().findByName(dataSetDto.getChineseTeacherName());
        if (oChineseTeacher.isEmpty()) {
            chineseTeacher = RepositoryUtil.getTeacherRepository().save(new TeacherEntity(dataSetDto.getChineseTeacherName()));
        } else {
            chineseTeacher = oChineseTeacher.get();
        }

        TeacherEntity mathTeacher;
        var oMathTeacher = RepositoryUtil.getTeacherRepository().findByName(dataSetDto.getMathTeacherName());
        if (oMathTeacher.isEmpty()) {
            mathTeacher = RepositoryUtil.getTeacherRepository().save(new TeacherEntity(dataSetDto.getMathTeacherName()));
        } else {
            mathTeacher = oMathTeacher.get();
        }

        TeacherEntity englishTeacher;
        var oEnglishTeacher = RepositoryUtil.getTeacherRepository().findByName(dataSetDto.getEnglishTeacherName());
        if (oEnglishTeacher.isEmpty()) {
            englishTeacher = RepositoryUtil.getTeacherRepository().save(new TeacherEntity(dataSetDto.getEnglishTeacherName()));
        } else {
            englishTeacher = oEnglishTeacher.get();
        }


        TeacherEntity xianXuanTeacher;
        var oXianXuanTeacher = RepositoryUtil.getTeacherRepository().findByName(dataSetDto.getXianXuanTeacherName());
        if (oXianXuanTeacher.isEmpty()) {
            xianXuanTeacher = RepositoryUtil.getTeacherRepository().save(new TeacherEntity(dataSetDto.getXianXuanTeacherName()));
        } else {
            xianXuanTeacher = oXianXuanTeacher.get();
        }

        TeacherEntity renXuanTeacher;
        var oRenXuanTeacher = RepositoryUtil.getTeacherRepository().findByName(dataSetDto.getRenXuanTeacherName());
        if (oRenXuanTeacher.isEmpty()) {
            renXuanTeacher = RepositoryUtil.getTeacherRepository().save(new TeacherEntity(dataSetDto.getRenXuanTeacherName()));
        } else {
            renXuanTeacher = oRenXuanTeacher.get();
        }

        CollegeEntity collegeEntity;
        var oCollegeEntity = RepositoryUtil.getCollegeRepository().findByName(dataSetDto.getCollegeName());
        if (oCollegeEntity.isEmpty()) {
            collegeEntity = RepositoryUtil.getCollegeRepository().save(new CollegeEntity(dataSetDto.getCollegeName()));
        } else {
            collegeEntity = oCollegeEntity.get();
        }

        SubjectEntity subjectEntity;
        var oSubjectEntity = RepositoryUtil.getSubjectRepository().findByName(dataSetDto.getSubjectName());
        if (oSubjectEntity.isEmpty()) {
            subjectEntity = RepositoryUtil.getSubjectRepository().save(new SubjectEntity(dataSetDto.getSubjectName(), collegeEntity));
        } else {
            subjectEntity = oSubjectEntity.get();
        }


        ClassEntity classEntity;
        var oClassEntity = RepositoryUtil.getClassRepository().findByClassName(dataSetDto.getClassName());
        if (oClassEntity.isEmpty()) {
            classEntity = RepositoryUtil.getClassRepository().save(new ClassEntity(dataSetDto.getClassName(), subjectEntity));

            classEntity.setCourseEntities(Set.of(
                    RepositoryUtil.getCourseRepository().save(new CourseEntity("语文", 0, 10, classEntity, RepositoryUtil.getTeacherRepository().findAll().get(0))),
                    RepositoryUtil.getCourseRepository().save(new CourseEntity("数学", 0, 10, classEntity, RepositoryUtil.getTeacherRepository().findAll().get(1))),
                    RepositoryUtil.getCourseRepository().save(new CourseEntity("英语", 0, 8, classEntity, RepositoryUtil.getTeacherRepository().findAll().get(2))),
                    RepositoryUtil.getCourseRepository().save(new CourseEntity("限选", 1, 10, classEntity, RepositoryUtil.getTeacherRepository().findAll().get(3))),
                    RepositoryUtil.getCourseRepository().save(new CourseEntity("任选", 2, 6, classEntity, RepositoryUtil.getTeacherRepository().findAll().get(4)))
            ));
        } else {
            classEntity = oClassEntity.get();
        }

        StudentEntity studentEntity = RepositoryUtil.getStudentRepository().save(new StudentEntity(dataSetDto.getStudentName(), dataSetDto.isStudentIsMale(), dataSetDto.getStudentBirthDate(), dataSetDto.getStudentNum(), classEntity));

        CourseEntity chineseCourseEntity = classEntity.getCourseEntities().stream().filter(c -> Objects.equals(c.getName(), "语文")).collect(Collectors.toList()).get(0);
        CourseEntity mathCourseEntity = classEntity.getCourseEntities().stream().filter(c -> Objects.equals(c.getName(), "数学")).collect(Collectors.toList()).get(0);
        CourseEntity englishCourseEntity = classEntity.getCourseEntities().stream().filter(c -> Objects.equals(c.getName(), "英语")).collect(Collectors.toList()).get(0);
        CourseEntity xianXuanCourseEntity = classEntity.getCourseEntities().stream().filter(c -> Objects.equals(c.getName(), "限选")).collect(Collectors.toList()).get(0);
        CourseEntity renXuanCourseEntity = classEntity.getCourseEntities().stream().filter(c -> Objects.equals(c.getName(), "任选")).collect(Collectors.toList()).get(0);

        RepositoryUtil.getScoreRepository().save(new ScoreEntity(dataSetDto.getChineseFirstScore(), dataSetDto.getChineseSecondScore(), studentEntity, chineseCourseEntity));
        RepositoryUtil.getScoreRepository().save(new ScoreEntity(dataSetDto.getMathFirstScore(), dataSetDto.getMathSecondScore(), studentEntity, mathCourseEntity));
        RepositoryUtil.getScoreRepository().save(new ScoreEntity(dataSetDto.getEnglishFirstScore(), dataSetDto.getEnglishSecondScore(), studentEntity, englishCourseEntity));
        RepositoryUtil.getScoreRepository().save(new ScoreEntity(dataSetDto.getXianXuanFirstScore(), dataSetDto.getXianXuanSecondScore(), studentEntity, xianXuanCourseEntity));
        RepositoryUtil.getScoreRepository().save(new ScoreEntity(dataSetDto.getRenXuanFirstScore(), dataSetDto.getRenXuanSecondScore(), studentEntity, renXuanCourseEntity));

        return ResponseEntity.ok(studentEntity.getStudentId());
    }
}
