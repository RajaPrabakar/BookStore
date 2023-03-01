package com.example.student.demo.Model;


import javax.persistence.*;

@Entity
@Table(name = "student")

public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

     private String studentName;
     public String getStudentName()
    {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
