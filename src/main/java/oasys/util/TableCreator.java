package oasys.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import static oasys.util.Constant.*;

public interface TableCreator {
    default void createStudentTable() {
        try {
            String query = "CREATE TABLE IF NOT EXISTS student(id VARCHAR(255) PRIMARY KEY, name VARCHAR(255)," +
                           "email VARCHAR(255), campus VARCHAR(255), academic_level VARCHAR(255)," +
                           "section VARCHAR(255), program VARCHAR(255), year_level VARCHAR(255))";
            Connection connection = DriverManager.getConnection(URL,USER,PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    default void createUserTable() {
        try {
            String query = "CREATE TABLE IF NOT EXISTS user(id VARCHAR(255), " +
                            "name VARCHAR(255),password VARCHAR(255),role VARCHAR(255))";
            Connection connection = DriverManager.getConnection(URL,USER,PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
