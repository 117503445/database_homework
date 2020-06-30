package com.wizzstudio.database_homework.repository;

import com.wizzstudio.database_homework.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<ClassEntity, Long> {
}
