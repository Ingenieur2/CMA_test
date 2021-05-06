package ru.package01.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Table("students")
public class Student {
    @Id
    @Column("id")
    private long id;
    @Column("first_name")
    private String firstName;
    @Column("second_name")
    private String secondName;
    @Column("middle_name")
    private String middleName;
    @Column("date_of_birth")
    private Date dateOfBirth;
    @Column("student_group")
    private String studentGroup;

    public Student() {
    }

    @PersistenceConstructor
    public Student(long id, String firstName, String secondName, String middleName, Date dateOfBirth, String studentGroup) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.studentGroup = studentGroup;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", first_name='" + firstName + '\'' +
                ", second_name='" + secondName + '\'' +
                ", middle_name='" + middleName + '\'' +
                ", date_of_birth='" + dateOfBirth + '\'' +
                ", student_group='" + studentGroup + '\'' +
                '}';
    }
}