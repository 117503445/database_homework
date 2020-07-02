package com.wizzstudio.database_homework.controller;

import com.wizzstudio.database_homework.dto.RuleGetDto;
import com.wizzstudio.database_homework.dto.RuleSetDto;
import com.wizzstudio.database_homework.repository.RuleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/rule")
@RestController
public class RuleController {
    private final RuleRepository ruleRepository;

    public RuleController(RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @GetMapping()
    public Page<RuleGetDto> pageQuery(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        return ruleRepository.findAll(PageRequest.of(pageNum - 1, pageSize)).map(RuleGetDto::fromEntity);
    }

    @PostMapping
    public RuleGetDto save(@RequestBody RuleSetDto ruleSetDto) {
        return RuleGetDto.fromEntity(ruleRepository.save(ruleSetDto.toEntity()));
    }
}
