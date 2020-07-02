package com.wizzstudio.database_homework.util;

import com.wizzstudio.database_homework.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositoryUtil {
    private static StudentRepository studentRepository;
    private static ClassRepository classRepository;
    private static TeacherRepository teacherRepository;
    private static CourseRepository courseRepository;
    private static SubjectRepository subjectRepository;
    private static CollegeRepository collegeRepository;
    private static ScoreRepository scoreRepository;

    @Autowired
    public RepositoryUtil(StudentRepository studentRepository, ClassRepository classRepository, TeacherRepository teacherRepository, CourseRepository courseRepository, SubjectRepository subjectRepository, CollegeRepository collegeRepository, ScoreRepository scoreRepository) {
        RepositoryUtil.studentRepository = studentRepository;
        RepositoryUtil.classRepository = classRepository;
        RepositoryUtil.teacherRepository = teacherRepository;
        RepositoryUtil.courseRepository = courseRepository;
        RepositoryUtil.subjectRepository = subjectRepository;
        RepositoryUtil.collegeRepository = collegeRepository;
        RepositoryUtil.scoreRepository = scoreRepository;
    }

    public static StudentRepository getStudentRepository() {
        return studentRepository;
    }

    public static ClassRepository getClassRepository() {
        return classRepository;
    }

    public static TeacherRepository getTeacherRepository() {
        return teacherRepository;
    }

    public static CourseRepository getCourseRepository() {
        return courseRepository;
    }

    public static SubjectRepository getSubjectRepository() {
        return subjectRepository;
    }

    public static CollegeRepository getCollegeRepository() {
        return collegeRepository;
    }

    public static ScoreRepository getScoreRepository() {
        return scoreRepository;
    }
}
