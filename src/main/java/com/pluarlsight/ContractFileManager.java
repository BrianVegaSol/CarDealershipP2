package com.pluarlsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {

    public void writeContract(Contract contract){
        try{
            FileWriter filewriter = new FileWriter("src/contracts.csv", true);
            BufferedWriter buffWriter = new BufferedWriter(filewriter);
            Dealership dealership = DealershipFileManager.getDealership();
            Vehicle vehicle = null;
            for (Vehicle vehicleLoop : Dealership.inventory){
                if (contract.vehicleSold.equalsIgnoreCase(Integer.toString(vehicleLoop.getVINNumber()))) {
                    vehicle = vehicleLoop;
                }
            }

            if (contract instanceof LeaseContract){
                buffWriter.write("LEASE|" + contract.getDate() + "|" + contract.getCustomerName()
                        + "|" + contract.getCustomerEmail() + "|" + contract.getVehicleSold() + "|" + vehicle.getYear()
                        + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" +
                        vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice() + "|" + ((LeaseContract) contract).getEndPrice()
                        + "|" + ((LeaseContract) contract).ge


                );



            }




        } catch (IOException e) {
            System.out.println("Error writing file has occurred");
        }
    }



}
