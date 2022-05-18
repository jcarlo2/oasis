package oasys.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import static oasys.util.ConstantString.*;

public interface TableCreator {
    default void createSchema() {
        try {
            String query = "CREATE SCHEMA IF NOT EXISTS student_management";
            Connection connection = DriverManager.getConnection(URL,USER,PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    default void createStudentTable() {
        try {
            String query = "CREATE TABLE IF NOT EXISTS student(id VARCHAR(255) PRIMARY KEY, name VARCHAR(255)," +
                           "email VARCHAR(255), campus VARCHAR(255), academic_level VARCHAR(255)," +
                           "section VARCHAR(255), program VARCHAR(255), year_level VARCHAR(255), adviser VARCHAR(255))";
            Connection connection = DriverManager.getConnection(URL,USER,PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    default void createTeacherTable() {
        try {
            String query = "CREATE TABLE IF NOT EXISTS teacher(no INT PRIMARY KEY AUTO_INCREMENT," +
                                "id VARCHAR(255) , name VARCHAR(255), email VARCHAR(255), campus VARCHAR(255), " +
                                 "department VARCHAR(255), consultation_hours VARCHAR(255), year VARCHAR(255))";
            Connection connection = DriverManager.getConnection(URL,USER,PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    default void createAdvisoryClassTable() {
        try {
            String query = "CREATE TABLE IF NOT EXISTS teacher_class(no INT PRIMARY KEY AUTO_INCREMENT," +
                                "id VARCHAR(255) , name VARCHAR(255)," +
                                 "section VARCHAR(255), year VARCHAR(255))";
            Connection connection = DriverManager.getConnection(URL,USER,PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    default void createConcernReport() {
        try {
            String query = "CREATE TABLE IF NOT EXISTS concern_report(no INT PRIMARY KEY NOT NULL AUTO_INCREMENT," +
             "student_name VARCHAR(255), student_id VARCHAR(255), adviser VARCHAR(255),subject VARCHAR(255)," +
              "detail VARCHAR(255), report_id VARCHAR(255),status VARCHAR(255) DEFAULT 'pending'," +
               "type VARCHAR(255), date DATETIME DEFAULT CURRENT_TIMESTAMP)";
            Connection connection = DriverManager.getConnection(URL,USER,PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    default void createUserTable() {
        try {
            String query = "CREATE TABLE IF NOT EXISTS user(id VARCHAR(255) PRIMARY KEY, " +
                            "name VARCHAR(255),password VARCHAR(255),role VARCHAR(255))";
            Connection connection = DriverManager.getConnection(URL,USER,PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    default void createAnnouncementHistoryTable() {
        try {
            String query = "CREATE TABLE IF NOT EXISTS announcement_history(no INT PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(255),id VARCHAR(255),title VARCHAR(255),detail MEDIUMTEXT" +
                     ", is_active BOOLEAN NOT NULL DEFAULT FALSE)";
            Connection connection = DriverManager.getConnection(URL,USER,PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
