package com.wizzstudio.database_homework.repository;

import com.wizzstudio.database_homework.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
