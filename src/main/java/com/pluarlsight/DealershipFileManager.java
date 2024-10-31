package com.pluarlsight;

import java.io.*;

public class DealershipFileManager {
    public static Dealership getDealership() {
        //read to .csv
        Dealership dealership = null;
        String file = "inventory.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String dealershipLine = br.readLine();
            String[] dealershipSplit = dealershipLine.split("\\|");
            String name = dealershipSplit[0];
            String address = dealershipSplit[1];
            String phone = dealershipSplit[2];
            dealership = new Dealership(name, address, phone);

            String vehicleLine;
            while ((vehicleLine = br.readLine()) != null) {
                String[] vehicleSplit = vehicleLine.split("\\|");
                int VINNumber = Integer.parseInt(vehicleSplit[0]);
                int year = Integer.parseInt(vehicleSplit[1]);
                String make = vehicleSplit[2];
                String model = vehicleSplit[3];
                String vehicleType = vehicleSplit[4];
                String color = vehicleSplit[5];
                int odometer = Integer.parseInt(vehicleSplit[6]);
                double price = Double.parseDouble(vehicleSplit[7]);
                Vehicle vehicle = new Vehicle(VINNumber, year, make, model, vehicleType, color, odometer, price);
                Dealership.inventory.add(vehicle);
            }
        } catch (IOException | IndexOutOfBoundsException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return dealership;
    }

    public static void saveDealership(Dealership dealership) {

    }

}
