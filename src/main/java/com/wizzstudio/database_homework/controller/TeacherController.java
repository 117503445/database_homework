package com.wizzstudio.database_homework.controller;

import com.wizzstudio.database_homework.dto.TeacherSetDto;
import com.wizzstudio.database_homework.entity.TeacherEntity;
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
    public Page<TeacherEntity> pageQuery(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        return teacherRepository.findAll(PageRequest.of(pageNum - 1, pageSize));
    }

    @PostMapping
    public TeacherEntity save(@RequestBody TeacherSetDto teacherSetDto) {
        return teacherRepository.save(teacherSetDto.toEntity());
    }
}
