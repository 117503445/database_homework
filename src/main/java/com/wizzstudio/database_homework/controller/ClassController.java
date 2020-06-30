package com.wizzstudio.database_homework.controller;

import com.wizzstudio.database_homework.entity.ClassEntity;
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
    public Page<ClassEntity> pageQuery(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        return classRepository.findAll(PageRequest.of(pageNum - 1, pageSize));
    }

    @PostMapping
    public ClassEntity save(@RequestBody ClassEntity classEntity) {
        return classRepository.save(classEntity);
    }
}
