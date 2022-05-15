package oasys.controller.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static oasys.util.Constant.*;

public class UserDatabase {
    private boolean isIdExist(String id) {
        boolean isExist = false;
            try {
                String query = "SELECT EXISTS (SELECT id FROM user WHERE id = ?)";
                Connection connection = DriverManager.getConnection(URL,USER,PASS);
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1,id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) isExist = resultSet.getInt(1) == 1;
            }catch (Exception e) {
                e.printStackTrace();
            }
        return isExist;
    }

    public boolean isIdAndPasswordExist(String id, String password) {
        if(!isIdExist(id)) return false;
        boolean flag = false;
        try {
            String query = "SELECT EXISTS (SELECT id FROM user WHERE id = ? and password = ?)";
            Connection connection = DriverManager.getConnection(URL,USER,PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,id);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) flag = resultSet.getInt(1) == 1;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public String getRole(String id) {
        if(!isIdExist(id)) return null;
        String role = "";
            try {
                String query = "SELECT role FROM user WHERE id =?";
                Connection connection = DriverManager.getConnection(URL,USER,PASS);
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1,id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) role = resultSet.getString("role");
            }catch (Exception e) {
                e.printStackTrace();
            }
        return role;
    }
}
