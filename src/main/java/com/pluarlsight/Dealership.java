package com.pluarlsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    static ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        inventory = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    /*public static ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
        return null;
    }*/

    /*public static void getVehiclesByPrice(double min, double max) {
        for (Vehicle vehicle : inventory) {
            System.out.println(vehicle);
        }
    }*/

    public static ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        inventory.sort(Comparator.comparing(Vehicle::getPrice));
        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public static ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                filteredVehicles.add(vehicle);
            }

        }
        return filteredVehicles;
    }

    public static ArrayList<Vehicle> getVehiclesByYear(int oldYear, int newYear) {
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        inventory.sort(Comparator.comparing(Vehicle::getYear));
        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= oldYear && vehicle.getYear() <= newYear) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public static ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        inventory.sort(Comparator.comparing(Vehicle::getColor));
        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public static ArrayList<Vehicle> getVehiclesByMileage(double min, double max) {
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        inventory.sort(Comparator.comparing(Vehicle::getOdometer));
        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public static ArrayList<Vehicle> getVehiclesByType(String vehicleType) {
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    /*public static ArrayList<Vehicle> getAllVehicles(double min, double max) {
        //Is this necessary or will the return inventory suffice???
        for (Vehicle vehicle : inventory) {
            //inventory.get(vehicle); no
            System.out.println(vehicle);
        }
        return inventory.toString();
    }*/

    public static void getAllVehicles(double min, double max) {
        //Is this necessary or will the return inventory suffice???
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println(inventory.get(i).toString());
        }
    }

    public static void addVehicle() {
        //Vehicle vehicle;
        System.out.println("Please enter you vehicle in the following format\n" +
                "VIN|Year|Make|Model|Car Type|Color|Mileage|Price");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try (FileWriter writer = new FileWriter("inventory.csv", true)) {
            writer.write(input.trim() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //inventory.add(vehicle);
    }

    public static void writerRemove(String input) {
        String file = "inventory.csv";
        String tempFile = "tempInv.csv";
        boolean validVIN = false;
        boolean alreadyRemoved = false;

        //Write to temp
        try (BufferedReader br = new BufferedReader(new FileReader(file));
             FileWriter writer = new FileWriter(tempFile)) {

            String line;
            while ((line = br.readLine())!= null) {
                if (line.contains(input) &&! alreadyRemoved) {
                    alreadyRemoved = true;
                } else {
                    writer.write(line + "\n");
                }
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage() + "\nPlease contact Admin");
        }

        //Replace original w/ temp
        try {
            java.nio.file.Files.move(java.nio.file.Paths.get(tempFile), java.nio.file.Paths.get(file),
                    java.nio.file.StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println("Error replacing file: " + e.getMessage());
        }
    }

    public static void removeVehicle(int vin) {
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVINNumber() == (vin)) {
                filteredVehicles.add(vehicle);
            }
        }
        inventory.remove(filteredVehicles);

        if (filteredVehicles.isEmpty()) {
            System.err.println("No cars with that VIN are on the lot\n");
        } else {
            System.out.println("Vehicle Removed Succesfully");
        }
    }

    //TODO I still need to make sure this works
    public static Vehicle findVehicleByVIN(int vin) {
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVINNumber() == vin) {
                return vehicle;
            }
        }
        return null;
    }

    public String toString() {
        return "Dealership Name: " + name +
                "\nAddress: " + address +
                "\nPhone Number: " + phone;
    }
}
