package com.example.springjpa.relationships.repository;

import com.example.springjpa.relationships.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
