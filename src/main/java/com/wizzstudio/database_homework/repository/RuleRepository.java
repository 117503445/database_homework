package com.wizzstudio.database_homework.repository;

import com.wizzstudio.database_homework.entity.RuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuleRepository extends JpaRepository<RuleEntity, Long> {
}
