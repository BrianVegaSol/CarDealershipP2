package com.pluralsight;

import java.sql.*;
import java.util.Scanner;


public class VehicleDAO {
    private static Scanner scan = new Scanner(System.in);

    static void viewVehicleByPrice(Connection connection, double min, double max) throws SQLException {
        String sql = "SELECT * FROM [BVS_Table2:Vehicles] WHERE Price BETWEEN " +
                min + " AND " + max + "ORDER BY Price ASC";
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

    static void viewVehicleByMakeModel(Connection connection, String make, String model) throws SQLException {
        String sql = "SELECT * FROM [BVS_Table2:Vehicles] WHERE [Make] = ? AND [Model] = ? ORDER BY Make ASC";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, make);
            stmt.setString(2, model);
            try (ResultSet rs = stmt.executeQuery()) {
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

    static void viewVehicleByYear(Connection connection, int oldYear, int newYear) throws SQLException {
        String sql = "SELECT * FROM [BVS_Table2:Vehicles] WHERE Year BETWEEN " +
                oldYear + " AND " + newYear + "ORDER BY Year ASC";
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
    /*while (true) {
        System.out.println("What do you want to search by?\n1) Make\n2) Model");
        input = scan.nextInt();
            switch (input) {
                case 1:
                    search = "Make";
                    break;
                case 2:
                    search = "Model";
                    break;
                default:
                    System.out.println("Invalid input. Please enter 1 or 2.");
                    scan.nextLine();
                    continue;
            }
            break;
        }*/
}
