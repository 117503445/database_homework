package com.wizzstudio.database_homework.repository;

import com.wizzstudio.database_homework.entity.CollegeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CollegeRepository extends JpaRepository<CollegeEntity, Long> {
    Optional<CollegeEntity> findByName(String name);
}
