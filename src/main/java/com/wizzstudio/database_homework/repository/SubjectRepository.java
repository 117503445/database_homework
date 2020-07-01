package com.wizzstudio.database_homework.repository;

import com.wizzstudio.database_homework.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
}
