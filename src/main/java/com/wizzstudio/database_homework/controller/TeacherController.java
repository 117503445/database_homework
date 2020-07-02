package com.wizzstudio.database_homework.controller;

import com.wizzstudio.database_homework.dto.TeacherGetDto;
import com.wizzstudio.database_homework.dto.TeacherSetDto;
import com.wizzstudio.database_homework.repository.TeacherRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/teacher")
@RestController
public class TeacherController {
    private final TeacherRepository teacherRepository;

    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @GetMapping()
    public Page<TeacherGetDto> pageQuery(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        return teacherRepository.findAll(PageRequest.of(pageNum - 1, pageSize)).map(TeacherGetDto::fromEntity);
    }

    @PostMapping
    public TeacherGetDto save(@RequestBody TeacherSetDto teacherSetDto) {
        return TeacherGetDto.fromEntity(teacherRepository.save(teacherSetDto.toEntity()));
    }
}
