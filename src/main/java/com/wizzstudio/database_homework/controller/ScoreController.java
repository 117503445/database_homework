package com.wizzstudio.database_homework.controller;

import com.wizzstudio.database_homework.dto.ScoreSetDto;
import com.wizzstudio.database_homework.entity.ScoreEntity;
import com.wizzstudio.database_homework.error.CustomException;
import com.wizzstudio.database_homework.repository.ScoreRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/score")
@RestController
public class ScoreController {
    private final ScoreRepository scoreRepository;

    public ScoreController(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @GetMapping()
    public Page<ScoreEntity> pageQuery(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        return scoreRepository.findAll(PageRequest.of(pageNum - 1, pageSize));
    }

    @PostMapping
    public ScoreEntity save(@RequestBody ScoreSetDto scoreSetDto) throws CustomException {
        return scoreRepository.save(scoreSetDto.toEntity());
    }
}