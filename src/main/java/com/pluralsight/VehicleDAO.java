package com.pluralsight;

import java.sql.*;
import java.util.Scanner;


public class VehicleDAO {
    //private static Scanner scan = new Scanner(System.in);

    static void viewVehicleByPrice(Connection connection, double min, double max) throws SQLException {
        String sql = "SELECT * FROM [BVS_Table2:Vehicles] WHERE Price BETWEEN ? AND ? ORDER BY Price ASC";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, min);
            stmt.setDouble(2, max);
            try (ResultSet rs = stmt.executeQuery()) {
                System.out.println("\nVehicle Records:");
                boolean found = false;
                while (rs.next()) {
                    found = true;
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
                if (!found) {
                    System.out.println("No Vehicle of that Price range found");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    static void viewVehicleByMakeModel(Connection connection, String make, String model) throws SQLException {
        String sql = "SELECT * FROM [BVS_Table2:Vehicles] WHERE [Make] = ? AND [Model] = ? ORDER BY Make ASC";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, make);
            stmt.setString(2, model);
            try (ResultSet rs = stmt.executeQuery()) {
                System.out.println("\nVehicle Records:");
                boolean found = false;
                while (rs.next()) {
                    found = true;
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
            if (!found) {
                System.out.println("No "+ make + " " + model + "s found");
            }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    static void viewVehicleByYear(Connection connection, int oldYear, int newYear) throws SQLException {
        String sql = "SELECT * FROM [BVS_Table2:Vehicles] WHERE Year BETWEEN ? AND ? ORDER BY Year ASC";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, oldYear);
            stmt.setInt(2, newYear);
            try (ResultSet rs = stmt.executeQuery()) {
                System.out.println("\nVehicle Records:");
                boolean found = false;
                while (rs.next()) {
                    found = true;
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
                if (!found) {
                    System.out.println("No Vehicle in that range found");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static void viewVehicleByColor(Connection connection, String color) throws SQLException {
        String sql = "SELECT * FROM [BVS_Table2:Vehicles] WHERE Color = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, color);
            try (ResultSet rs = stmt.executeQuery()) {
                System.out.println("\nVehicle Records:");
                boolean found = false;
                while (rs.next()) {
                    found = true;
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
                if (!found) {
                    System.out.println("No " + color + " Vehicles found");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static void viewVehicleByMileage(Connection connection, int minMiles, int maxMiles) throws SQLException {
        String sql = "SELECT * FROM [BVS_Table2:Vehicles] WHERE Odometer BETWEEN  ? AND ? ORDER BY Odometer ASC";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, minMiles);
            stmt.setInt(2, maxMiles);
            try (ResultSet rs = stmt.executeQuery()) {
                System.out.println("\nVehicle Records:");
                boolean found = false;
                while (rs.next()) {
                    found = true;
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
                if (!found) {
                    System.out.println("No Vehicle of that Mileage range found");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static void viewVehicleByVehicleType (Connection connection, String type) throws SQLException {
        String sql = "SELECT * FROM [BVS_Table2:Vehicles] WHERE VehicleType = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, type);
            try (ResultSet rs = stmt.executeQuery()) {
                System.out.println("\nVehicle Records:");
                boolean found = false;
                while (rs.next()) {
                    found = true;
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
                if (!found) {
                    System.out.println("No Vehicle of Type " + type + " found");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
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
