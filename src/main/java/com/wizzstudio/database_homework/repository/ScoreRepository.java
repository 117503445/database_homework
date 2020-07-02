package com.wizzstudio.database_homework.repository;

import com.wizzstudio.database_homework.entity.ScoreEntity;
import com.wizzstudio.database_homework.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreRepository extends JpaRepository<ScoreEntity, Long> {
    List<ScoreEntity> findAllByStudentEntity(StudentEntity s);
}
