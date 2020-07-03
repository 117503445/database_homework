package com.wizzstudio.database_homework.repository;

import com.wizzstudio.database_homework.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {
    Optional<TeacherEntity> findByName(String name);
}
