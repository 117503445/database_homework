package com.wizzstudio.database_homework.util;

import com.wizzstudio.database_homework.repository.ClassRepository;
import com.wizzstudio.database_homework.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositoryUtil {
    private static StudentRepository studentRepository;
    private static ClassRepository classRepository;

    @Autowired
    public RepositoryUtil(StudentRepository studentRepository, ClassRepository classRepository) {
        RepositoryUtil.studentRepository = studentRepository;
        RepositoryUtil.classRepository = classRepository;
    }

    public static StudentRepository getStudentRepository() {
        return studentRepository;
    }

    public static ClassRepository getClassRepository() {
        return classRepository;
    }
}
