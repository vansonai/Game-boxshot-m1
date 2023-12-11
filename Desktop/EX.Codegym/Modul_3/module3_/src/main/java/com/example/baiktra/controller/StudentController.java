package com.example.baiktra.controller;

import com.example.baiktra.entity.Student;
import com.example.baiktra.model.StudentDAO;
import com.example.baiktra.model.StudentModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentController {
    StudentDAO studentDAO;
    public  StudentController(){
        this.studentDAO = new StudentModel();
    }
    public void showListStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Student> data;
        data = studentDAO.getAll();
        req.setAttribute("students", data);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/listStudent.jsp");
        dispatcher.forward(req,resp);

    }
    public void showFormAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/addStudent.jsp");
        dispatcher.forward(req,resp);
    }
    public void addStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String date = req.getParameter("date");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        int classroom = Integer.parseInt(req.getParameter("class"));
        studentDAO.studentAdd(new Student(name, date,email,address,phone,classroom));
        resp.sendRedirect("/student");
    }
    public void studentUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String date = req.getParameter("date");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        int classroom = Integer.parseInt(req.getParameter("class"));
        studentDAO.studentUpdate(new Student(id,name, date,email,address,phone,classroom));
        resp.sendRedirect("/student");
    }
    public void showFormUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Student students = studentDAO.findStudentById(id);
        req.setAttribute("students", students);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/updateStudent.jsp");
        dispatcher.forward(req,resp);
    }
    public void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        this.studentDAO.studentRemove(id);
        resp.sendRedirect("/student");
    }

}
