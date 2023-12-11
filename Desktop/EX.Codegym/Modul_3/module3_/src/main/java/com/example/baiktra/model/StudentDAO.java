package com.example.baiktra.model;

import com.example.baiktra.entity.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> getAll();
     void studentAdd(Student student);
     Student findStudentById(int id);
     void studentRemove(int id);
     void studentUpdate(Student student);
     List<Student> studentSearch(String key);
}
