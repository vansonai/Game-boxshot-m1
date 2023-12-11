package com.example.baiktra.model;

import com.example.baiktra.database.Database;
import com.example.baiktra.entity.Student;
import com.mysql.cj.protocol.Resultset;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentModel implements StudentDAO{
    protected Connection conn;
    public StudentModel(){
        Database database = Database.getInstance();
        this.conn = database.Connection();
    }
    @Override
    public List<Student> getAll() {
        List<Student> students = new ArrayList();
        try {
            String sql = "select student.id,student.name,student.dateOfBirth,student.email,student.address,student.phone,classroom.classroom from classroom join student on classroom.id = student.classroom_id order by student.id";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String dateOfBirth = rs.getString(3);
                String email = rs.getString(4);
                String address = rs.getString(5);
                String phone = rs.getString(6);
                String classroom = rs.getString(7);
                Student student = new Student(id,name,dateOfBirth,email,address,phone,classroom);
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }
    @Override
    public void studentAdd(Student student) {
       try {
           String sql = "INSERT INTO student (name,dateOfBirth,email,address,phone,classroom_id) VALUES(?,?,?,?,?,?)";
           PreparedStatement statement = conn.prepareStatement(sql);
           statement.setString(1, student.getName());
           statement.setString(2, student.getDateOfBirth());
           statement.setString(3, student.getEmail());
           statement.setString(4, student.getAddress());
           statement.setString(5, student.getPhoneNumber());
           statement.setInt(6, student.getClassroomId());
           statement.executeUpdate();
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
    }
    @Override
    public Student findStudentById(int id) {
        Student student = null;
        try {
            String sql = "SELECT * FROM student WHERE id =?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String name = rs.getString(2);
                String date = rs.getString(3);
                String email = rs.getString(4);
                String address = rs.getString(5);
                String phone = rs.getString(6);
                int classroom_id = rs.getInt(7);
                student = new Student(name,date,email,address,phone,classroom_id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }

    @Override
    public void studentRemove(int id) {
        try {
            String sql ="delete from student where id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void studentUpdate(Student student) {
        try {
            String sql ="UPDATE student SET name = ?,dateOfBirth = ?, email = ?,address = ?,phone = ?,classroom_id = ? where id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.setString(2, student.getDateOfBirth());
            statement.setString(3, student.getEmail());
            statement.setString(4, student.getAddress());
            statement.setString(5, student.getPhoneNumber());
            statement.setInt(6, student.getClassroomId());
            statement.setInt(7, student.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Student> studentSearch(String key) {
        return null;
    }
}
