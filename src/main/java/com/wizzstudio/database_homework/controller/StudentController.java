package com.wizzstudio.database_homework.controller;

import com.wizzstudio.database_homework.dto.StudentGetDto;
import com.wizzstudio.database_homework.dto.StudentSetDto;
import com.wizzstudio.database_homework.entity.StudentEntity;
import com.wizzstudio.database_homework.error.CustomException;
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
    public Page<StudentGetDto> pageQuery(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        var a=studentRepository.findAll(PageRequest.of(pageNum - 1, pageSize)).map(StudentGetDto::fromEntity);
        System.out.println(a);
        return a;
    }

    @PostMapping
    public StudentEntity save(@RequestBody StudentSetDto studentSetDto) throws CustomException {
        return studentRepository.save(StudentSetDto.toEntity(studentSetDto));
    }
}
