package com.example.springjpa.relationships.repository;

import com.example.springjpa.relationships.entity.Course;
import com.example.springjpa.relationships.entity.Student;
import com.example.springjpa.relationships.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {


    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourse(){
        List<Course> courses=courseRepository.findAll();
        System.out.println("course " +courses);
    }

    @Test //manytoone
    public void saveCourseWithTeacher(){
        Teacher teacher= Teacher.builder().firstName("ragu").lastName("veera").build();
        Course course = Course.builder().title("python").credit(8).teacher(teacher).build();
        courseRepository.save(course);
    }
    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher= Teacher.builder().firstName("Praveen").lastName("Kumar").build();
        Student student= Student.builder().firstName("Rahul").lastName("vijay").emailId("supraveen@gmail.com").build();
        Course course=Course.builder().
                title("AI").credit(10).teacher(teacher).build();
            course.addStudents(student);
            courseRepository.save(course);
    }



}