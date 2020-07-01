package com.wizzstudio.database_homework.repository;

import com.wizzstudio.database_homework.entity.CollegeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepository extends JpaRepository<CollegeEntity, Long> {
}
