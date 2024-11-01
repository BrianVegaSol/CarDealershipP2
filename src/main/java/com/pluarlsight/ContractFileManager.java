package com.pluarlsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ContractFileManager {
    public static void saveContract() {
        //read to .csv
        Dealership dealership = null;
        String file = "contracts.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split("\\|");
                String contractType = split[0];
                //TODO May change to LocalDate/Time later
                String date = split[1];
                String customerName = split[2];
                String customerEmail = split[3];
                //TODO IntelliJ Suggests using a method for Vehicle Split 0.0
                int VINNumber = Integer.parseInt(split[4]);
                int year = Integer.parseInt(split[5]);
                String make = split[6];
                String model = split[7];
                String vehicleType = split[8];
                String color = split[9];
                int odometer = Integer.parseInt(split[10]);
                double price = Double.parseDouble(split[11]);
                Vehicle vehicle = new Vehicle(VINNumber, year, make, model, vehicleType, color, odometer, price);
                if (contractType.equalsIgnoreCase("LEASE")) {
                    //TODO Not sure what vars need to be here @Daniela but need to update LeaseContract Constructor
                    // to match what is in .csv
                    // LEASE|20210928|Zachary Westly|zach@texas.com|37846|2021| Chevrolet|Silverado|truck|Black|2750|31995.00|
                    // what are these 4 vars???
                    // 15997.50|2239.65|18337.15|541.39    
                    double totalPrice = Double.parseDouble(split[12]);
                    double monthlyPayment = Double.parseDouble(split[13]);
                    double originalPrice = Double.parseDouble(split[14]);
                    double var4 = Double.parseDouble(split[15]);
                    /*LeaseContract lease = new SalesContract(contractType, date, customerName, customerEmail, vehicle,
                            totalPrice, monthlyPayment, originalPrice, var4);*/
                    //LeaseContract.leaseList.add(lease);

                }
                if (contractType.equalsIgnoreCase("SALES")) {
                    double salesTaxAmount = Double.parseDouble(split[12]);
                    double recordingFee = Double.parseDouble(split[13]);
                    double processingFee = Double.parseDouble(split[14]);
                    double totalPrice = Double.parseDouble(split[15]);
                    String wantsToFinance = split[16];
                    double monthlyPayment = Double.parseDouble(split[17]);
                    SalesContract sales = new SalesContract(contractType, date, customerName, customerEmail, vehicle,
                            salesTaxAmount, recordingFee, processingFee, totalPrice, wantsToFinance, monthlyPayment);
                    SalesContract.salesList.add(sales);
                }
                /*if (Contract.contract instanceof SalesContract) {
                    System.out.println();
                }*/
            }
            //TODO cant remember what the Exception is but might wanna add anotha one
        } catch (IOException |
                 IndexOutOfBoundsException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void saveContract(Dealership dealership) {

    }
}


