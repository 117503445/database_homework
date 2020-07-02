package com.wizzstudio.database_homework.controller;

import com.wizzstudio.database_homework.dto.ClassGetDto;
import com.wizzstudio.database_homework.dto.ClassSetDto;
import com.wizzstudio.database_homework.error.CustomException;
import com.wizzstudio.database_homework.repository.ClassRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/class")
@RestController
public class ClassController {
    private final ClassRepository classRepository;

    public ClassController(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @GetMapping()
    public Page<ClassGetDto> pageQuery(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        return classRepository.findAll(PageRequest.of(pageNum - 1, pageSize)).map(ClassGetDto::fromEntity);
    }

    @PostMapping
    public ClassGetDto save(@RequestBody ClassSetDto classSetDto) throws CustomException {
        return ClassGetDto.fromEntity(classRepository.save(classSetDto.toEntity()));
    }
}
