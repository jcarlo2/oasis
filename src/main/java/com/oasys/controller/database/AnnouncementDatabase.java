package com.oasys.controller.database;

import com.oasys.dto.Announcement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static com.oasys.shared.util.ConstantString.*;

public class AnnouncementDatabase {

    public String[] getTitle(String adviserId) {
        String[] data = new String[6];
        int num = 0;
            try {
                String query = "SELECT title FROM announcement_history WHERE is_active = ? AND id = ? ORDER BY no DESC";
                Connection connection = DriverManager.getConnection(URL,USER,PASS);
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setBoolean(1,true);
                preparedStatement.setString(2,adviserId);
                ResultSet resultSet = preparedStatement.executeQuery();
                    while(resultSet.next()) data[num++] = resultSet.getString(1);
            }catch (Exception e) {
                e.printStackTrace();
            }
            return data;
    }

    public String[] getDetail(String id) {
        String[] data = new String[6];
        int num = 0;
            try {
                String query ="SELECT detail FROM announcement_history WHERE is_active = ? AND id = ? ORDER BY no DESC";
                Connection connection = DriverManager.getConnection(URL,USER,PASS);
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setBoolean(1,true);
                preparedStatement.setString(2,id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next()) data[num++] = resultSet.getString(1);
            }catch (Exception e) {
                e.printStackTrace();
            }
        return data;
    }

    public void addAnnouncement(Announcement announcement) {
        try {
            String query = "INSERT INTO announcement_history(name,id,title,detail,is_active) VALUES(?,?,?,?,?)";
            Connection connection = DriverManager.getConnection(URL,USER,PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,announcement.getName());
            preparedStatement.setString(2,announcement.getId());
            preparedStatement.setString(3,announcement.getTitle());
            preparedStatement.setString(4,announcement.getDetail());
            preparedStatement.setBoolean(5,true);
            preparedStatement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deactivateAnnouncement(String title, String detail) {
        try {
            String query ="UPDATE announcement_history SET is_active = ? WHERE is_active = ? AND title = ? AND detail = ?";
            Connection connection = DriverManager.getConnection(URL,USER,PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBoolean(1,false);
            preparedStatement.setBoolean(2,true);
            preparedStatement.setString(3,title);
            preparedStatement.setString(4,detail);
            preparedStatement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isMaximumActive(String adviserId) {
        ArrayList<String> list = new ArrayList<>();
        try {
            String query ="SELECT * FROM announcement_history WHERE is_active = ? AND id = ?";
            Connection connection = DriverManager.getConnection(URL,USER,PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBoolean(1,true);
            preparedStatement.setString(2,adviserId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                list.add(resultSet.getString("id"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list.size() >= 6;
    }
}
