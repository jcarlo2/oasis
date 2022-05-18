package oasys.controller.database;

import oasys.model.Teacher;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static oasys.util.ConstantString.*;

public class TeacherDatabase {
    public Teacher getTeacherInformation(String id) {
        String[] data = new String[7];
        try {
            String query = "SELECT * FROM teacher WHERE id = ?";
            Connection connection = DriverManager.getConnection(URL,USER,PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                    data[0] = resultSet.getString("id");
                    data[1] = resultSet.getString("name");
                    data[2] = resultSet.getString("email");
                    data[3] = resultSet.getString("campus");
                    data[4] = resultSet.getString("department");
                    data[5] = resultSet.getString("consultation_hours");
                    data[6] = resultSet.getString("year");
                }

        }catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<String> sections = getSections(data[0],data[6]);
        return new Teacher(data[0],data[1],data[2],data[3],
                    data[4],data[5],data[6],sections);
    }

    private @NotNull ArrayList<String> getSections(String id, String year) {
        ArrayList<String> sections = new ArrayList<>();
        try {
            String query = "SELECT section FROM teacher_class WHERE id = ? AND year = ?";
            Connection connection = DriverManager.getConnection(URL,USER,PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,id);
            preparedStatement.setString(2,year);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                sections.add(resultSet.getString("section"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return sections;
    }
}
