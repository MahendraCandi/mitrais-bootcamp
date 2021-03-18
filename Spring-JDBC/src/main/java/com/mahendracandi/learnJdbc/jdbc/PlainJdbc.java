package com.mahendracandi.learnJdbc.jdbc;

import com.mahendracandi.learnJdbc.dao.StudentDao;
import com.mahendracandi.learnJdbc.model.Student;
import com.mahendracandi.learnJdbc.properties.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component("PlainJdbc")
public class PlainJdbc implements StudentDao {

    @Autowired
    private AppProperties appProperties;

    @Override
    public void setDataResource(DataSource dataSource) {

    }

    @Override
    public void createStudent(String name, Integer age) {
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            Class.forName(appProperties.getJdbcDirverClassName()).newInstance();

            conn = DriverManager.getConnection(
                    appProperties.getJdbcUrl(),
                    appProperties.getJdbcUsername(),
                    appProperties.getJdbcPassword() == null ? "" : appProperties.getJdbcPassword()
            );

            String SQL = "INSERT INTO student (name, age) VALUES (?, ?)";
            statement = conn.prepareStatement(SQL);
            statement.setString(1, name);
            statement.setInt(2, age);

            statement.executeUpdate();

            System.out.printf("create student name: %s age: %s \n", name, age);

            statement.close();
            conn.close();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Student getStudent(Integer id) {
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        Connection conn = null;
        Statement statement = null;
        List<Student> students = new ArrayList<>();

        try {
            Class.forName(appProperties.getJdbcDirverClassName()).newInstance();

            conn = DriverManager.getConnection(
                    appProperties.getJdbcUrl(),
                    appProperties.getJdbcUsername(),
                    appProperties.getJdbcPassword() == null ? "" : appProperties.getJdbcPassword()
            );

            String SQL = "SELECT * FROM student";
            statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(SQL);
            while(rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setAge(rs.getInt("age"));

                students.add(s);
            }

            rs.close();
            statement.close();
            conn.close();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return students;
    }
}
