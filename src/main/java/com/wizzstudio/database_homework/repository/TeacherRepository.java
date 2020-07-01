package com.wizzstudio.database_homework.repository;

import com.wizzstudio.database_homework.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {
}
