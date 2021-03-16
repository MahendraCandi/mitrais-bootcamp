package com.mahendracandi.learnJdbc.dao;

import com.mahendracandi.learnJdbc.model.Student;

import javax.sql.DataSource;
import java.util.List;

public interface StudentDao {

    void setDataResource(DataSource dataSource);

    void createStudent(String name, Integer age);

    Student getStudent(Integer id);

    List<Student> getAllStudents();
}
