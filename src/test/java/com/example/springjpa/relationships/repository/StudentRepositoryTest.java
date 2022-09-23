package com.example.springjpa.relationships.repository;

import com.example.springjpa.relationships.entity.Guardian;
import com.example.springjpa.relationships.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
   private StudentRepository studentRepository;

    @Test
    public void addStudent(){
        Student student= Student.builder()
                .firstName("rahul").lastName("vijay")
                .emailId("frederickraghul@gmail.com")
                //.guardianEmail("frederickraghul@gmail.com")
                //.guardianMobile("9677210944").guardianName("Rahul")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList= studentRepository.findAll();

        System.out.println("students" + studentList);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian=Guardian.builder()
                .email("frederickrahul@gmail.com")
                .name("Rahul")
                .mobile("9677210944")
                .build();
        Student student= Student.builder()
                .firstName("Praveen")
                .emailId("praveen@gmail.com")
                .lastName("kumar")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void findByFirstName(){
        List<Student> student=studentRepository.findByFirstName("Praveen");

        System.out.println("students"  +student);
    }

    @Test
    public  void findByFirstNameContaining(){
        List<Student> student = studentRepository.findByFirstNameContaining("p");

        System.out.println("student" +student);

    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> student=studentRepository.findByGuardianName("Rahul");
        System.out.println("Student" +student);
    }

    @Test
    public void printGetStudentByEmailAddress(){
        Student student=studentRepository.getStudentByEmailAddress("frederickraghul@gmail.com");
        System.out.println("student =" +student);
    }

    @Test
    public void printGetStudentByFirstNameByEmailAddress(){
        String firstName=studentRepository.getStudentByFirstNameByEmailAddress("frederickraghul@gmail.com");
        System.out.println("student= "+ firstName);
    }

    @Test
    public void printGetStudentByEmailAddressNative(){
        Student student=studentRepository.getStudentByEmailAddressNative("frederickraghul@gmail.com");
        System.out.println("student=" +student);
    }

    @Test
    public void printGetStudentByEmailAddressNativeNamedParam(){
        Student student=studentRepository.getStudentByEmailAddressNativeNamedParam("frederickraghul@gmail.com");
        System.out.println("student =" +student);

    }

    @Test
    public void  updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId("Ravi","frederickraghul@gmail.com");
    }
}