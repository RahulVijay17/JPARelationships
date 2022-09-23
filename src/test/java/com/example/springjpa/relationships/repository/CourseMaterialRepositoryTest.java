package com.example.springjpa.relationships.repository;

import com.example.springjpa.relationships.entity.Course;
import com.example.springjpa.relationships.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder().title("Java").credit(10).build();
        CourseMaterial courseMaterial= CourseMaterial.builder().
                                        url("WWW.GOOGLE.COM")
                                        .course(course).build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterial(){
        List<CourseMaterial> courseMaterial = courseMaterialRepository.findAll();

        System.out.println("courseMaterial= "+ courseMaterial);
    }
}