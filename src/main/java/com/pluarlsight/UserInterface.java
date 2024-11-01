package com.pluarlsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserInterface {
    static boolean displayMenu = true;
    static boolean exitApp = false;
    static Scanner scan = new Scanner(System.in);
    private static Dealership dealership;

    private static Dealership init() {
        DealershipFileManager dealer;
        dealership = DealershipFileManager.getDealership();
        return dealership;
    }

    public static void display() {
        init();
        while (displayMenu) {
            System.out.println("Welcome to the Display Menu!\n" +
                    "1) Find vehicles within a price range\n" +
                    "2) Find vehicles by make/model\n" +
                    "3) Find vehicles by year\n" +
                    "4) Find vehicles by color\n" +
                    "5) Find vehicles by mileage\n" +
                    "6) Find vehicles by type\n" +
                    "7) List All vehicles\n" +
                    "8) Add a vehicle\n" +
                    "9) Remove a vehicle\n" +
                    "10) Buy a vehicle by VIN\n" +
                    "11) Lease a vehicle by VIN\n" +
                    "99) Quit");
            byte input = scan.nextByte();
            switch (input) {
                case 99:
                    System.out.println("Goodbye");
                    exitApp = true;
                    displayMenu = false;
                    break;
                case 1:
                    System.out.println("What is the minimum price?");
                    double min = scan.nextDouble();
                    System.out.println("What is the maximum price?");
                    double max = scan.nextDouble();
                    processVehiclesByPriceRequest(min, max);
                    break;
                case 2:
                    scan.nextLine();
                    System.out.println("What is the make of the car?");
                    String make = scan.nextLine();
                    System.out.println("What is the model of the car?");
                    String model = scan.nextLine();
                    processVehiclesByMakeModelRequest(make, model);
                    break;
                case 3:
                    System.out.println("What is the oldest year of the car?");
                    int oldYear = scan.nextInt();
                    System.out.println("What is the newest year of the car?");
                    int newYear = scan.nextInt();
                    processGetVehiclesByYearRequest(oldYear, newYear);
                    break;
                case 4:
                    scan.nextLine();
                    System.out.println("What is the color of the car?");
                    String color = scan.nextLine();
                    processGetVehiclesByColorRequest(color);
                    break;
                case 5:
                    System.out.println("What is the minimum mileage?");
                    int minMiles = scan.nextInt();
                    System.out.println("What is the maximum mileage?");
                    int maxMiles = scan.nextInt();
                    processGetVehiclesByMileageRequest(minMiles, maxMiles);
                    break;
                case 6:
                    scan.nextLine();
                    System.out.println("What is the type of the car?");
                    String type = scan.nextLine();
                    processGetVehiclesByTypeRequest(type);
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    Dealership.addVehicle();
                    System.out.println("Vehicle Added Successfully");
                    break;
                case 9:
                    System.out.println("What is the VIN of the vehicle do you want to remove");
                    int vin = scan.nextInt();
                    Dealership.writerRemove(Integer.toString(vin));
                    break;
                case 10:
                    processVehiclePurchaseByVIN();
                    break;
                case 11:
                    processVehicleLeaseByVIN();
                    break;

            }
        }
    }

    public static void processVehiclesByPriceRequest(double min, double max) {
        for (int i = 0; i < Dealership.getVehiclesByPrice(min, max).size(); i++) {
            System.out.println(Dealership.getVehiclesByPrice(min, max).get(i).toString());
        }
    }

    public static void processVehiclesByMakeModelRequest(String make, String model) {
        for (int i = 0; i < Dealership.getVehiclesByMakeModel(make, model).size(); i++) {
            System.out.println(Dealership.getVehiclesByMakeModel(make, model).get(i).toString());
            //Dealership.inventory.clear();
        }
    }

    public static void processGetVehiclesByYearRequest(int oldYear, int newYear) {
        for (int i = 0; i < Dealership.getVehiclesByYear(oldYear, newYear).size(); i++) {
            System.out.println(Dealership.getVehiclesByYear(oldYear, newYear).get(i).toString());
        }
    }

    public static void processGetVehiclesByColorRequest(String color) {
        //maybe do try catch OR if () for car not on dealership
        for (int i = 0; i < Dealership.getVehiclesByColor(color).size(); i++) {
            System.out.println(Dealership.getVehiclesByColor(color).get(i).toString());
        }
    }

    public static void processGetVehiclesByMileageRequest(double min, double max) {
        for (int i = 0; i < Dealership.getVehiclesByMileage(min, max).size(); i++) {
            System.out.println(Dealership.getVehiclesByMileage(min, max).get(i).toString());
        }
    }

    public static void processGetVehiclesByTypeRequest(String vehicleType) {
        for (int i = 0; i < Dealership.getVehiclesByType(vehicleType).size(); i++) {
            System.out.println(Dealership.getVehiclesByType(vehicleType).get(i).toString());
        }
    }

    public static void processGetAllVehiclesRequest() {
        System.out.println(DealershipFileManager.getDealership().toString());
        for (Vehicle vehicle : Dealership.inventory) {
            System.out.println(vehicle.toString());
        }
    }
    public static void processAddVehicleRequest(Vehicle vehicle) {
        Dealership.inventory.add(vehicle);
    }

    public static void processRemoveVehicleRequest(Vehicle vehicle) {
        Dealership.inventory.remove(vehicle);
    }
    //TODO: still need to implement new writer, i made one yesterday just to test.
    private static void processVehiclePurchaseByVIN() {
        System.out.println("Enter vehicle VIN for purchase: ");
        int vin = scan.nextInt();
        Vehicle vehicle = Dealership.findVehicleByVIN(vin);

        if (vehicle != null) {
            System.out.println("Vehicle found: " + vehicle);

            scan.nextLine();
            System.out.println("Enter your first and last name: ");
            String customerName = scan.nextLine();

            System.out.println("Enter your email address: ");
            String customerEmail = scan.nextLine();

            System.out.println("Do you want to finance this vehicle? (yes/no): ");
            String userChoice = scan.nextLine().toLowerCase();

            System.out.println("Do you confirm this purchase? (yes/no): ");
            String confirmation = scan.nextLine();

            //TODO i think this should come together once file writer is updated.
            if (confirmation.equalsIgnoreCase("yes")){
                String contractType = "SALE";
                String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
                double totalPrice = vehicle.getPrice();
                //double monthlyPayment = totalPrice/36;

                SalesContract salesContract = new SalesContract(contractType, date, customerName, customerEmail, vehicle, vehicle.getVINNumber(), vehicle.getOdometer();
                System.out.println("Congratulations on your purchase!");

            } else {
                System.out.println("Purchase cancelled.");
            }
        } else {
            System.out.println("No vehicle found with VIN: " +  vin);
        }

    }
    //TODO: i need to complete this.
    private static void processVehicleLeaseByVIN() {
        System.out.println("Enter vehicle VIN for lease: ");
        int vin = scan.nextInt();
        Vehicle vehicle = Dealership.findVehicleByVIN(vin);

        if (vehicle != null) {
            System.out.println("Vehicle found: " + vehicle);

            scan.nextLine();
            System.out.println("Enter your first and last name: ");
            String customerName = scan.nextLine();

            System.out.println("Enter your email address: ");
            String customerEmail = scan.nextLine();

            System.out.println("Do you confirm this lease? (yes/no): ");
            String confirmation = scan.nextLine().toLowerCase();

            //TODO i tried to do something with  the writer, but it is not functional.
            if (confirmation.equalsIgnoreCase("yes")){
                ContractFileManager.saveContract();
                System.out.println("Congratulations on your purchase!");

            } else {
                System.out.println("Lease cancelled.");
            }
        } else {
            System.out.println("no vehicle found with VIN: " + vin);
        }

    }
}


