package com.wizzstudio.database_homework.controller;

import com.wizzstudio.database_homework.dto.StudentGetDto;
import com.wizzstudio.database_homework.dto.StudentScoreGetDto;
import com.wizzstudio.database_homework.dto.StudentSetDto;
import com.wizzstudio.database_homework.entity.StudentEntity;
import com.wizzstudio.database_homework.error.CustomException;
import com.wizzstudio.database_homework.repository.StudentRepository;
import com.wizzstudio.database_homework.util.RepositoryUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
        return studentRepository.findAll(PageRequest.of(pageNum - 1, pageSize)).map(StudentGetDto::fromEntity);
    }

    @PostMapping
    public StudentEntity save(@RequestBody StudentSetDto studentSetDto) throws CustomException {
        return studentRepository.save(StudentSetDto.toEntity(studentSetDto));
    }

    @GetMapping("/{id}")
    public StudentGetDto getOne(@PathVariable long id) throws CustomException {
        var oStudent = studentRepository.findById(id);
        if (oStudent.isEmpty()) {
            throw new CustomException(HttpStatus.NOT_FOUND, "Student Not Found");
        }

        return StudentGetDto.fromEntity(oStudent.get());
    }

    @ApiOperation("查询指定 id 学生的成绩")
    @GetMapping("/{id}/score")
    public List<StudentScoreGetDto> getScore(@PathVariable long id) throws CustomException {
        var oStudent = studentRepository.findById(id);
        if (oStudent.isEmpty()) {
            throw new CustomException(HttpStatus.NOT_FOUND, "Student Not Found");
        }

        return RepositoryUtil.getScoreRepository().findAllByStudentEntity(oStudent.get()).stream().map(StudentScoreGetDto::fromScoreEntity).collect(Collectors.toList());
    }

}
