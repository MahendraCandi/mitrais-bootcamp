package com.mahendracandi.learnJdbc;

import com.mahendracandi.learnJdbc.config.AppConfig;
import com.mahendracandi.learnJdbc.jdbc.PlainJdbc;
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

        System.out.println("------------ record creation JDBCTemplate ---------------");
        studentJdbcTemplate.createStudent("Caca", 16);
        studentJdbcTemplate.createStudent("Cici", 17);
        studentJdbcTemplate.createStudent("Coco", 18);

        System.out.println("------------ list record JDBCTemplate ---------------");
        List<Student> students = studentJdbcTemplate.getAllStudents();
        students.forEach(System.out::println);

        PlainJdbc plainJdbc = (PlainJdbc) appContext.getBean("PlainJdbc");

        System.out.println("------------ record creation PlainJdbc ---------------");
        plainJdbc.createStudent("dada", 13);
        plainJdbc.createStudent("didi", 14);
        plainJdbc.createStudent("dede", 15);

        System.out.println("------------ list record PlainJdbc ---------------");
        List<Student> studentsP = plainJdbc.getAllStudents();
        studentsP.forEach(System.out::println);
    }
}
