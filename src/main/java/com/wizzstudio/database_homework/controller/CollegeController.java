package com.wizzstudio.database_homework.controller;


import com.wizzstudio.database_homework.dto.CollegeSetDto;
import com.wizzstudio.database_homework.entity.CollegeEntity;
import com.wizzstudio.database_homework.repository.CollegeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/college")
@RestController
public class CollegeController {
    private final CollegeRepository collegeRepository;

    public CollegeController(CollegeRepository collegeRepository) {
        this.collegeRepository = collegeRepository;
    }

    @GetMapping()
    public Page<CollegeEntity> pageQuery(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        return collegeRepository.findAll(PageRequest.of(pageNum - 1, pageSize));
    }

    @PostMapping
    public CollegeEntity save(@RequestBody CollegeSetDto collegeSetDto){
        return collegeRepository.save(collegeSetDto.toEntity());
    }
}
