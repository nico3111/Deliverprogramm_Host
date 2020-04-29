package com.company.model;

import java.sql.*;

public class DatabaseConnector {
    private static final String DBURL = "jdbc:mysql://localhost:3306/lieferservice?user=root";
    private Connection connection = null;
    private Statement statement = null;

    private static DatabaseConnector instance;

    public static DatabaseConnector getInstance() {
        if(instance == null) {
            instance = new DatabaseConnector();
        }
        return instance;
    }

    private DatabaseConnector() {
    }

    private void buildConnection() {
        try {
            String databaseUrl = DBURL;
            connection = DriverManager.getConnection(databaseUrl);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("could not build connection");
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            System.out.println("could not close connection");
            e.printStackTrace();
        }
    }

    /**
     * Make sure to call closeConnection() after handling the result set
     * @param sql
     * @return
     */
    public ResultSet fetchData(String sql) {
        buildConnection();
        try {
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("could not fetch data");
            e.printStackTrace();
            closeConnection();
        }
        return null;
    }

    public boolean delete(String sql) {
        buildConnection();
        try {
            int result = statement.executeUpdate(sql);
            if (result == 0) {
                System.out.println("no matching entry found");
                return false;
            } else {
                System.out.println("delete successful, update your data");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("could not delete data");
            e.printStackTrace();
            return false;
        } finally {
            closeConnection();
        }
    }

    // public boolean update(String sql) {...}
    public void insert(String sql) {

        buildConnection();
        try {
            Statement st = connection.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}