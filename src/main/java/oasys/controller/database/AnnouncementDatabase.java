package oasys.controller.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static oasys.util.Constant.*;

public class AnnouncementDatabase {

    public String[] getTitle(String name) {
        String[] data = new String[6];
        int num = 0;
            try {
                String query = "SELECT title FROM announcement_history WHERE is_active = ? AND name = ?";
                Connection connection = DriverManager.getConnection(URL,USER,PASS);
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setBoolean(1,true);
                preparedStatement.setString(2,name);
                ResultSet resultSet = preparedStatement.executeQuery();
                    while(resultSet.next()) data[num++] = resultSet.getString(1);
            }catch (Exception e) {
                e.printStackTrace();
            }
            return data;
    }

    public String[] getDetail(String name) {
        String[] data = new String[6];
        int num = 0;
            try {
                String query ="SELECT detail FROM announcement_history WHERE is_active = ? AND name = ?";
                Connection connection = DriverManager.getConnection(URL,USER,PASS);
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setBoolean(1,true);
                preparedStatement.setString(2,name);
                ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next()) data[num++] = resultSet.getString(1);
            }catch (Exception e) {
                e.printStackTrace();
            }
        return data;
    }
}
