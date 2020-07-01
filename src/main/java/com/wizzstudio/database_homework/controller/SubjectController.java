package com.wizzstudio.database_homework.controller;

import com.wizzstudio.database_homework.dto.SubjectSetDto;
import com.wizzstudio.database_homework.entity.SubjectEntity;
import com.wizzstudio.database_homework.error.CustomException;
import com.wizzstudio.database_homework.repository.SubjectRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/subject")
@RestController
public class SubjectController {
    private final SubjectRepository subjectRepository;

    public SubjectController(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @GetMapping()
    public Page<SubjectEntity> pageQuery(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        return subjectRepository.findAll(PageRequest.of(pageNum - 1, pageSize));
    }

    @PostMapping
    public SubjectEntity save(@RequestBody SubjectSetDto subjectSetDto) throws CustomException {
        return subjectRepository.save(subjectSetDto.toEntity());
    }
}
