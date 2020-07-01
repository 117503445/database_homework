package com.wizzstudio.database_homework.controller;

import com.wizzstudio.database_homework.dto.CourseSetDto;
import com.wizzstudio.database_homework.entity.CourseEntity;
import com.wizzstudio.database_homework.error.CustomException;
import com.wizzstudio.database_homework.repository.CourseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/course")
@RestController
public class CourseController {
    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping()
    public Page<CourseEntity> pageQuery(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        return courseRepository.findAll(PageRequest.of(pageNum - 1, pageSize));
    }

    @PostMapping
    public CourseEntity save(@RequestBody CourseSetDto courseSetDto) throws CustomException {
        return courseRepository.save(courseSetDto.toEntity());
    }
}
