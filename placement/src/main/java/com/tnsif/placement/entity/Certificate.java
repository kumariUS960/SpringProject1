package com.tnsif.placement.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "certificates")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentName;
    private String rollNo;
    private String course;
    private String branch;
    private String company;
    private LocalDate issueDate;
    private String grade;

    // Constructors
    public Certificate() {}

    public Certificate(String studentName, String rollNo, String course, String branch, String company, LocalDate issueDate, String grade) {
        this.studentName = studentName;
        this.rollNo = rollNo;
        this.course = course;
        this.branch = branch;
        this.company = company;
        this.issueDate = issueDate;
        this.grade = grade;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getRollNo() { return rollNo; }
    public void setRollNo(String rollNo) { this.rollNo = rollNo; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public String getBranch() { return branch; }
    public void setBranch(String branch) { this.branch = branch; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public LocalDate getIssueDate() { return issueDate; }
    public void setIssueDate(LocalDate issueDate) { this.issueDate = issueDate; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
}

