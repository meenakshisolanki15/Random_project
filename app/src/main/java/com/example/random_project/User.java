package com.example.random_project;


import java.sql.Date;

public class User {

    public static class Student {
        private String name;

        public Student(String name) {
            this.name = name;
        }

        // Getters and setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Attendance {
        private Student student;
        private Date date;

        public Attendance(Student student, Date date) {
            this.student = student;
            this.date = date;
        }

        // Getters and setters
        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }
    }




}
