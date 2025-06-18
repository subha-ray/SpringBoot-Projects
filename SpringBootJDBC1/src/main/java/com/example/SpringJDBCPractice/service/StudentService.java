package com.example.SpringJDBCPractice.service;

import com.example.SpringJDBCPractice.model.Student;
import com.example.SpringJDBCPractice.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepo repo;

    public StudentRepo getRepo() {
        return repo;
    }
    @Autowired
    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }

    public void addStudent(Student s) {
        repo.save(s);
    }
    public void deleteStudent(Student s) {
        repo.delete(s);
    }

    public List<Student> getStudents() {
        return repo.findAll();
    }
}
