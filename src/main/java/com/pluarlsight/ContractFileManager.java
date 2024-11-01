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
                String[] vehicleSplit = line.split("\\|");
                //TODO Change indices
                String contractType = vehicleSplit[0];
                int VINNumber = Integer.parseInt(vehicleSplit[0]);
                int year = Integer.parseInt(vehicleSplit[1]);
                String make = vehicleSplit[2];
                String model = vehicleSplit[3];
                String vehicleType = vehicleSplit[4];
                String color = vehicleSplit[5];
                int odometer = Integer.parseInt(vehicleSplit[6]);
                double price = Double.parseDouble(vehicleSplit[7]);
                Vehicle vehicle = new Vehicle(VINNumber, year, make, model, vehicleType, color, odometer, price);
                //TODO Add if (contractType = SALE/LEASE), this is the latest we can wait since there are differnt
                // variables for the last 4 entries and will cause conversion errors >:(
                // if (lease/sale)
                //other
                //4
                //splits
                if (contractType.equalsIgnoreCase("SALES")) {
                    System.out.println();
                }
                if (Contract.contract instanceof SalesContract) {
                    System.out.println();
                }
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


