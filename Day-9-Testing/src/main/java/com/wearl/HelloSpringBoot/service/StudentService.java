package com.wearl.HelloSpringBoot.service;

import com.wearl.HelloSpringBoot.dto.StudentDTO;
import com.wearl.HelloSpringBoot.exception.ResourceNotFoundException;
import com.wearl.HelloSpringBoot.mapper.StudentMapper;
import com.wearl.HelloSpringBoot.model.Student;
import com.wearl.HelloSpringBoot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(int id, Student updatedStudent) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with ID: " + id));

        student.setName(updatedStudent.getName());
//        student.setEmail(updatedStudent.getEmail());

        studentRepository.save(student);
    }

    public void deleteStudent(int id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with ID: " + id));
        studentRepository.delete(student);
    }
   
}
