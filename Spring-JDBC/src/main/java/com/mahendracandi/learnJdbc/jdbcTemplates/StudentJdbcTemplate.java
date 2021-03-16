package com.mahendracandi.learnJdbc.jdbcTemplates;

import com.mahendracandi.learnJdbc.dao.StudentDao;
import com.mahendracandi.learnJdbc.mapper.StudentMapper;
import com.mahendracandi.learnJdbc.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class StudentJdbcTemplate implements StudentDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataResource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void createStudent(String name, Integer age) {
        String SQL = "INSERT INTO student (name, age) VALUES (?, ?)";
        jdbcTemplate.update(SQL, name, age);
        System.out.printf("create student name: %s age: %s \n", name, age);
    }

    public Student getStudent(Integer id) {
        return getAllStudents().stream()
                .filter(p -> p.getId() == id).findAny().orElse(null);
    }

    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM student";
        List<Student> students = jdbcTemplate.query(sql, new StudentMapper());

        return students;
    }
}
