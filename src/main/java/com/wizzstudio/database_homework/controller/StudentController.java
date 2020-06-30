package com.wizzstudio.database_homework.controller;

import com.wizzstudio.database_homework.entity.StudentEntity;
import com.wizzstudio.database_homework.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/student")
@RestController
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping()
    public Page<StudentEntity> pageQuery(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        return studentRepository.findAll(PageRequest.of(pageNum - 1, pageSize));
    }

    @PostMapping
    public StudentEntity save(@RequestBody StudentEntity studentEntity){
        return studentRepository.save(studentEntity);
    }
}
