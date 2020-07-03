package com.wizzstudio.database_homework.controller;

import com.wizzstudio.database_homework.dto.CourseGetDto;
import com.wizzstudio.database_homework.dto.CourseSetDto;
import com.wizzstudio.database_homework.entity.CourseEntity;
import com.wizzstudio.database_homework.error.CustomException;
import com.wizzstudio.database_homework.repository.CourseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/course")
@RestController
public class CourseController {
    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping()
    public Page<CourseGetDto> pageQuery(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        return courseRepository.findAll(PageRequest.of(pageNum - 1, pageSize)).map(CourseGetDto::fromEntity);
    }

    @PostMapping
    public CourseGetDto save(@RequestBody CourseSetDto courseSetDto) throws CustomException {
        var courseEntity = courseSetDto.toEntity();
        if (courseEntity.getTeacherEntity().getCourseEntities().stream().map(CourseEntity::getClassEntity).anyMatch(c -> c == courseEntity.getClassEntity())) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "1个老师不能同时给1个班级上多门课程");
        }
        return CourseGetDto.fromEntity(courseRepository.save(courseEntity));
    }


}
