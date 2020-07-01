package com.wizzstudio.database_homework.util;

import com.wizzstudio.database_homework.repository.ClassRepository;
import com.wizzstudio.database_homework.repository.CourseRepository;
import com.wizzstudio.database_homework.repository.StudentRepository;
import com.wizzstudio.database_homework.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositoryUtil {
    private static StudentRepository studentRepository;
    private static ClassRepository classRepository;
    private static TeacherRepository teacherRepository;
    private static CourseRepository courseRepository;

    @Autowired
    public RepositoryUtil(StudentRepository studentRepository, ClassRepository classRepository, TeacherRepository teacherRepository, CourseRepository courseRepository) {
        RepositoryUtil.studentRepository = studentRepository;
        RepositoryUtil.classRepository = classRepository;
        RepositoryUtil.teacherRepository = teacherRepository;
        RepositoryUtil.courseRepository = courseRepository;
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
}
