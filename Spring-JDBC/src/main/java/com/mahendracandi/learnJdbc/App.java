package com.mahendracandi.learnJdbc;

import com.mahendracandi.learnJdbc.config.AppConfig;
import com.mahendracandi.learnJdbc.jdbcTemplates.StudentJdbcTemplate;
import com.mahendracandi.learnJdbc.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext appContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
//                new ClassPathXmlApplicationContext("config.xml");

        StudentJdbcTemplate studentJdbcTemplate = (StudentJdbcTemplate)
                appContext.getBean("StudentJdbcTemplate");

        System.out.println("------------ record creation ---------------");
        studentJdbcTemplate.createStudent("Caca", 16);
        studentJdbcTemplate.createStudent("Cici", 17);
        studentJdbcTemplate.createStudent("Coco", 18);

        System.out.println("------------ list record ---------------");
        List<Student> students = studentJdbcTemplate.getAllStudents();
        students.forEach(System.out::println);
    }
}
