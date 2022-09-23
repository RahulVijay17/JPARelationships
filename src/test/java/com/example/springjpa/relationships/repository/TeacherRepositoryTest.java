package com.example.springjpa.relationships.repository;

import com.example.springjpa.relationships.entity.Course;
import com.example.springjpa.relationships.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course course =Course.builder().title("c++").credit(8).build();

        Teacher teacher=Teacher.builder().firstName("Rahul").lastName("Raj")
                //.courses(List.of(course))
                .build();
        teacherRepository.save(teacher);

    }


}