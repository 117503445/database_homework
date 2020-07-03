package com.wizzstudio.database_homework.repository;

import com.wizzstudio.database_homework.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClassRepository extends JpaRepository<ClassEntity, Long> {
    Optional<ClassEntity> findByClassName(String name);

}
