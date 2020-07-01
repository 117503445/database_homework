package com.wizzstudio.database_homework.repository;

import com.wizzstudio.database_homework.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
}
