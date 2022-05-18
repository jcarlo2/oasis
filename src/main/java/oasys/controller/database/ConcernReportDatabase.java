package oasys.controller.database;

import oasys.model.dto.ConcernReport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static oasys.util.ConstantString.*;

public class ConcernReportDatabase {
    public boolean isIdExist(String id) {
        boolean isExist = false;
        try {
            String query = "SELECT EXISTS (SELECT report_id FROM concern_report WHERE report_id = ?)";
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

    public void addConcernReport(ConcernReport report) {
        try {
            String query = "INSERT INTO concern_report(student_name,student_id,adviser,subject,detail,report_id) VALUES(?,?,?,?,?,?)";
            Connection connection = DriverManager.getConnection(URL,USER,PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,report.getStudentName());
            preparedStatement.setString(2,report.getStudentId());
            preparedStatement.setString(3,report.getAdviser());
            preparedStatement.setString(4,report.getSubject());
            preparedStatement.setString(5,report.getDetail());
            preparedStatement.setString(6,report.getReportId());
            preparedStatement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<ConcernReport> getConcernReport(String studentName) {
        ArrayList<ConcernReport> reportList = new ArrayList<>();
        String[] data = new String[8];
        try {
            String query = "SELECT * FROM concern_report WHERE student_name = ? ORDER BY date DESC";
            Connection connection = DriverManager.getConnection(URL,USER,PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,studentName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                data[0] = resultSet.getString("student_name");
                data[1] = resultSet.getString("student_id");
                data[2] = resultSet.getString("adviser");
                data[3] = resultSet.getString("subject");
                data[4] = resultSet.getString("detail");
                data[5] = resultSet.getString("report_id");
                data[6] = resultSet.getString("status");
                data[7] = resultSet.getString("type");
                reportList.add(new ConcernReport(data[0],data[1],data[2],
                        data[3],data[4],data[5],data[6],data[7]));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return reportList;
    }
}
