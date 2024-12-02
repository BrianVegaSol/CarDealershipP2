package com.pluralsight;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Scanner;

public class DataManager {

    public DataSource getDatabaseConnection () {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:sqlserver://skills4it.database.windows.net:1433;database=courses;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;");
        config.setUsername("user25");
        config.setPassword("goldenphoenix2024!");
        config.setMaximumPoolSize(10);
        //config.setLogWriter(new FileWriter("hikari.log"));
        //config.setDataSourceProperties(new FileWriter("hikari.log"));
        DataSource dataSource = new HikariDataSource(config);
        return dataSource;
    }

    // CREATE operation
    static void addVehicle(Connection connect, Scanner scanner) throws SQLException {
        //Connection connect = ds.getConnection();
        //System.out.print("Enter Vehicle ID (VIN): ");
        //int vin = scanner.nextInt();
        System.out.print("Enter Year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Make: ");
        String make = scanner.nextLine();
        System.out.print("Enter Model: ");
        String model = scanner.nextLine();
        System.out.print("Enter Vehicle Type: ");
        String vehicleType = scanner.nextLine();
        System.out.print("Enter Color: ");
        String color = scanner.nextLine();
        System.out.print("Enter Odometer Reading: ");
        int odometer = scanner.nextInt();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();

        String sql = "INSERT INTO [BVS_Table2:Vehicles] ([Year], [Make], " +
                "[Model], [VehicleType], [Color], [Odometer], [Price], [Sold]) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connect.prepareStatement(sql)) {
            stmt.setInt(1, year);
            stmt.setString(2, make);
            stmt.setString(3, model);
            stmt.setString(4, vehicleType);
            stmt.setString(5, color);
            stmt.setInt(6, odometer);
            stmt.setDouble(7, price);
            stmt.setByte(8, (byte) 0);
            stmt.executeUpdate();
            System.out.println("Vehicle Added Successfully!");
        }
    }

    // READ operation
    static void viewVehicleRecords(Connection connection) throws SQLException {
        String sql = "SELECT * FROM [BVS_Table2:Vehicles]";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\nVehicle Records:");
            while (rs.next()) {
                System.out.println("VIN: " + rs.getInt("VINNumber") +
                        "\nYear: " + rs.getInt("Year") +
                        "\nMake: " + rs.getString("Make") +
                        "\nModel: " + rs.getString("Model") +
                        "\nVehicle Type: " + rs.getString("VehicleType") +
                        "\nColor: " + rs.getString("Color") +
                        "\nMileage: " + rs.getInt("Odometer") +
                        "\nPrice: $" + rs.getDouble("Price") +
                        "\nisSold: " + rs.getByte("Sold") + "\n\n"
                );
            }
        }
    }


}
