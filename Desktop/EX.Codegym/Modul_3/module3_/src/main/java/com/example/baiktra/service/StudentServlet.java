package com.example.baiktra.service;

import com.example.baiktra.controller.StudentController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentServlet",urlPatterns = "/student")
public class StudentServlet extends HttpServlet {
    public StudentController studentController;

    @Override
    public void init() throws ServletException {
        this.studentController = new StudentController();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        try {
            switch(action){
                case "addStudent":
                    studentController.showFormAdd(req,resp);
                    break;
                case "update":
                    studentController.showFormUpdate(req,resp);
                    break;
                case "delete":
                    studentController.deleteStudent(req,resp);
                    break;
                default:
                    studentController.showListStudent(req, resp);
                    break;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        try {
            switch(action){
                case "addStudent":
                    studentController.addStudent(req,resp);
                    break;
                case "update":
                    studentController.studentUpdate(req,resp);
                    break;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
