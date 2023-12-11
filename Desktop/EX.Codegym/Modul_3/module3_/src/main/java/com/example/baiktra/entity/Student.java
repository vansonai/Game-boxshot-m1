package com.example.baiktra.entity;


public class Student {
    private int id;
    private String name;
    private String email;
    private String dateOfBirth;
    private String address;
    private String phoneNumber;
    private int classroomId;
    private String classroom;

    public Student(int id, String name, String dateOfBirth,String email, String address, String phoneNumber, String classroom) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.classroom = classroom;
    }

    public Student(String name, String dateOfBirth,String email, String address, String phoneNumber, int classroomId) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.classroomId = classroomId;
    }

    public Student(int id, String name, String dateOfBirth, String email, String address, String phoneNumber, int classroomId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.classroomId = classroomId;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getClassroom() {
        return classroom;
    }
}
