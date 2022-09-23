package com.ungpung0.personalblog.board;

import java.sql.*;

public class DBConnection {

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    private String dbUrl = "jdbc:mariadb:localhost:3306/study_db";
    private String dbUser = "study_user";
    private String dbPassword = "root";

    // DB 연결 메소드.
    public void startConnection() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            statement = connection.createStatement();
        }catch (Exception error) {
            error.printStackTrace();
        }
    }

    // DB 종료 메소드.
    public void closeConnection() {
        if(resultSet != null) {
            try {
                resultSet.close();
            }catch (SQLException error) {
                error.printStackTrace();
            }
        }
        if(statement != null) {
            try {
                statement.close();
            }catch (SQLException error) {
                error.printStackTrace();
            }
        }
        if(connection != null) {
            try {
                connection.close();
            }catch (SQLException error) {
                error.printStackTrace();
            }
        }
    }

}
