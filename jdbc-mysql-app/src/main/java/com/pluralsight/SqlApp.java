package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Scanner;

public class SqlApp {
    public static void main(String[] args) throws SQLException {

        BasicDataSource dataSource = new BasicDataSource();

        String url = "jdbc:mysql://localhost:3306/cardealership";
        String user = "root";
        String password = "yearup24";

        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setUrl(url);


        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {

            System.out.print("Enter the make you are looking for: ");
            String makeToSearch = scanner.nextLine();

            try (Connection connection = DriverManager.getConnection(url, user, password)) {


                PreparedStatement statement = connection.prepareStatement("select * from vehicles where make = '" + makeToSearch + "' ;");
                statement.execute();

                ResultSet resultSet = statement.getResultSet();
                System.out.println(resultSet);

                while (resultSet.next()) {
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
}
