package com.wizzstudio.database_homework.controller;

import com.wizzstudio.database_homework.dto.StudentGetDto;
import com.wizzstudio.database_homework.dto.StudentScoreGetDto;
import com.wizzstudio.database_homework.dto.StudentSetDto;
import com.wizzstudio.database_homework.dto.StudentTeacherGetDto;
import com.wizzstudio.database_homework.error.CustomException;
import com.wizzstudio.database_homework.repository.StudentRepository;
import com.wizzstudio.database_homework.service.StudentService;
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
    public StudentGetDto save(@RequestBody StudentSetDto studentSetDto) throws CustomException {
        return StudentGetDto.fromEntity(studentRepository.save(StudentSetDto.toEntity(studentSetDto)));
    }

    @GetMapping("/{id}")
    public StudentGetDto getOneById(@PathVariable long id) throws CustomException {
        var oStudent = studentRepository.findById(id);
        if (oStudent.isEmpty()) {
            throw new CustomException(HttpStatus.NOT_FOUND, "Student Not Found");
        }

        return StudentGetDto.fromEntity(oStudent.get());
    }

    @ApiOperation("查询指定 name 学生的基本信息")
    @GetMapping("/name/{name}")
    public StudentGetDto getOneByName(@PathVariable String name) throws CustomException {
        var oStudent = studentRepository.findByName(name);
        if (oStudent.isEmpty()) {
            throw new CustomException(HttpStatus.NOT_FOUND, "Student Not Found");
        }

        return StudentGetDto.fromEntity(oStudent.get());
    }

    @ApiOperation("查询指定 学号 学生的基本信息")
    @GetMapping("/num/{num}")
    public StudentGetDto getOneByNum(@PathVariable long num) throws CustomException {
        var oStudent = studentRepository.findByStudentNum(num);
        if (oStudent.isEmpty()) {
            throw new CustomException(HttpStatus.NOT_FOUND, "Student Not Found");
        }

        return StudentGetDto.fromEntity(oStudent.get());
    }

    @ApiOperation("查询指定 id 学生的成绩")
    @GetMapping("/score")
    public List<StudentScoreGetDto> getScores(@RequestParam long id) throws CustomException {
        var oStudent = studentRepository.findById(id);
        if (oStudent.isEmpty()) {
            throw new CustomException(HttpStatus.NOT_FOUND, "Student Not Found");
        }

        return RepositoryUtil.getScoreRepository().findAllByStudentEntity(oStudent.get()).stream().map(StudentScoreGetDto::fromScoreEntity).collect(Collectors.toList());
    }


    @ApiOperation("查询指定 id 学生的老师")
    @GetMapping("/teacher")
    public List<StudentTeacherGetDto> getTeachers(@RequestParam long id) throws CustomException {
        var oStudent = studentRepository.findById(id);
        if (oStudent.isEmpty()) {
            throw new CustomException(HttpStatus.NOT_FOUND, "Student Not Found");
        }

        return oStudent.get().getClassEntity().getCourseEntities().stream().sorted().map(StudentTeacherGetDto::fromCourseEntity).collect(Collectors.toList());
    }

    @ApiOperation("查询快要退学的学生")
    @GetMapping("/firing")
    public List<StudentGetDto> getFiringStudents() {
        return studentRepository.findAll().stream().filter(StudentService::isFiring).map(StudentGetDto::fromEntity).collect(Collectors.toList());
    }


    @GetMapping("/fired")
    public List<StudentGetDto> getFiredStudents() {
        return studentRepository.findAll().stream().filter(StudentService::isFired).map(StudentGetDto::fromEntity).collect(Collectors.toList());
    }
}
