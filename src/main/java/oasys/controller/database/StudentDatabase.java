package oasys.controller.database;

import oasys.model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static oasys.util.ConstantString.*;

public class StudentDatabase {
    public String getAdviser(String id) {
        try {
            String query = "SELECT adviser FROM student WHERE id = ?";
            Connection connection = DriverManager.getConnection(URL,USER,PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) id = resultSet.getString(1);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public Student getStudentInformation(String id) {
        String[] data = new String[9];
            try {
                String query = "SELECT * FROM student WHERE id = ?";
                Connection connection = DriverManager.getConnection(URL,USER,PASS);
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1,id);
                ResultSet resultSet = preparedStatement.executeQuery();
                   if(resultSet.next()) {
                       for(int i=0;i<data.length;i++)  data[i] = resultSet.getString(i + 1);
                   }
            }catch (Exception e) {
                e.printStackTrace();
            }
        return new Student(data[0],data[1],data[2],data[3],data[4],
            data[5],data[6],data[7],data[8]);
    }

    public ArrayList<String> getStudentBySection(String adviser, String section) {
        ArrayList<String> studentList = new ArrayList<>();
        try {
            String query = "SELECT name FROM student WHERE adviser = ? AND section = ?";
            Connection connection = DriverManager.getConnection(URL,USER,PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,adviser);
            preparedStatement.setString(2,section);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) studentList.add(resultSet.getString(1));
        }catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }
}
