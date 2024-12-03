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

    static void updateVehicleRecord(Connection connection, Scanner scanner) throws SQLException {
        viewVehicleRecords(connection);
        String columnToUpdate = "";
        System.out.print("Enter the VIN of the Vehicle to update: ");
        int VIN = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("""
                What would you like to update?
                1) Year
                2) Make
                3) Model
                4) Vehicle Type
                5) Color
                6) Mileage
                7) Price
                8) Sold (0 for false/ 1 for true)
                """);
        int input = -1;
        input = scanner.nextInt();
        scanner.nextLine();
        switch (input) {
            case 0 -> {
                return;
            }
            case 1 -> columnToUpdate = "Year";
            case 2 -> columnToUpdate = "Make";
            case 3 -> columnToUpdate = "Model";
            case 4 -> columnToUpdate = "VehicleType";
            case 5 -> columnToUpdate = "Color";
            case 6 -> columnToUpdate = "Odometer";
            case 7 -> columnToUpdate = "Price";
            case 8 -> columnToUpdate = "Sold";
            default -> System.out.println("Invalid Input");
        }
        System.out.print("Enter new value: ");
        Object setValue = switch (columnToUpdate) {
            case "Year", "Odometer" -> scanner.nextInt();
            case "Make", "Model", "VehicleType", "Color" -> scanner.nextLine();
            case "Price" -> scanner.nextDouble();
            case "Sold" -> scanner.nextByte();
            default -> throw new IllegalArgumentException("Invalid Input");
        };

        if (setValue instanceof Byte) {
            if ((byte) setValue > 1 || (byte) setValue < 0) {
                throw new IllegalArgumentException("Invalid Input");
            }
        }

        String sql = "UPDATE [BVS_Table2:Vehicles] SET " + columnToUpdate + " = ?" + " WHERE VINNumber = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            switch (setValue) {
                case String s -> stmt.setString(1, s);
                case Integer i -> stmt.setInt(1, i);
                case Double d -> stmt.setDouble(1, d);
                case Byte b -> stmt.setByte(1, b);
                case null, default ->
                        throw new IllegalArgumentException("Unsupported data type for newValue: " + setValue.getClass().getName());
            }

            stmt.setInt(2, VIN);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Vehicle updated successfully!");
            } else {
                System.out.println("No Vehicle found with the given VIN.");
            }
        }
    }
}
