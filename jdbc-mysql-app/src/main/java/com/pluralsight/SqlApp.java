package com.pluralsight;

import java.sql.*;

public class SqlApp {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/cardealership";
        String user = "root";
        String password = "yearup24";

        try {

            Connection connection = DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM vehicles;");

            ResultSet resultSet = statement.getResultSet();
            System.out.println(resultSet);

            while(resultSet.next()){
                String make = resultSet.getNString("make");
                String model = resultSet.getNString("model");
                int year = resultSet.getInt("year");
                System.out.printf("%-20s %-20s %-10d\n", make, model, year);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}