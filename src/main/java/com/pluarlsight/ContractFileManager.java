package com.pluarlsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ContractFileManager {
    //TODO should this return a Contract since its abstract? Maybe make void???
    public static void saveContract() {
        //read to .csv
        Dealership dealership = null;
        String file = "contracts.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            //TODO Since Contract is an abstract class, do if contractType instance of Lease/Sales, then proceed
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split("\\|");
                String contractType = split[0];
                //TODO May change to LocalDate/Time later
                String date = split[1];
                String customerName = split[2];
                String customerEmail = split[3];
                int VINNumber = Integer.parseInt(split[4]);
                int year = Integer.parseInt(split[5]);
                String make = split[6];
                String model = split[7];
                String vehicleType = split[8];
                String color = split[9];
                int odometer = Integer.parseInt(split[10]);
                double price = Double.parseDouble(split[11]);
                Vehicle vehicle = new Vehicle(VINNumber, year, make, model, vehicleType, color, odometer, price);
                //TODO Not sure what vars need to be here @Daniela
                if (contractType.equalsIgnoreCase("LEASE")) {
                    double salesTaxAmount = Double.parseDouble(split[12]);
                    double recordingFee = Double.parseDouble(split[13]);
                    double processingFee = Double.parseDouble(split[14]);
                    double totalPrice = Double.parseDouble(split[15]);

                }
                if (contractType.equalsIgnoreCase("SALES")) {
                double salesTaxAmount = Double.parseDouble(split[12]);
                double recordingFee = Double.parseDouble(split[13]);
                double processingFee = Double.parseDouble(split[14]);
                double totalPrice = Double.parseDouble(split[15]);
                String wantsToFinance = split[16];
                double monthlyPayment = Double.parseDouble(split[17]);
                SalesContract sales = new SalesContract()
                }
                /*if (Contract.contract instanceof SalesContract) {
                    System.out.println();
                }*/
            }
            //TODO Add SalesContract/LeaseContract Constructor
            // Make Sales/LeaseContract Objects and fill constructor with splits
            // Have an Arraylist here, (potentially 2?) from the Sales/LeaseContract Classes that take the Objects
            //Ex
            // SalesContract sales = new SalesContract( fill, this , sucker
            // up, all, the, way);
            // SalesContract.inventory.add(vehicle);

        //TODO cant remember what the Exception is but might wanna add anotha one
    } catch(IOException |
    IndexOutOfBoundsException e)

    {
        System.err.println("Error reading file: " + e.getMessage());
    }
    //TODO Compiling but probably doesn't work
}


public static void saveContract(Dealership dealership) {

}
    }


