package com.wizzstudio.database_homework.repository;

import com.wizzstudio.database_homework.entity.ScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<ScoreEntity, Long> {
}
