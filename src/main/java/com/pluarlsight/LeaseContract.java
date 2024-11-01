package com.pluarlsight;

import java.rmi.dgc.Lease;
import java.util.ArrayList;

public class LeaseContract extends Contract {
    private double originalPrice;
    private double leaseFeePercent = 0.07;
    private double interestRate = 0.04;
    private int leaseTerm = 36; //all leases financed at 4% for 36 mo.
    static ArrayList<LeaseContract> leaseList = new ArrayList<>();


    //TODO contractType will likely need to be made String/Date/Time type instead of Contract
    public LeaseContract (String contractType, String date, String customerName, String customerEmail,
                         Vehicle vehicleSold,
                         double totalPrice, double monthlyPayment, double originalPrice, double leaseFeePercent,
                         double interestRate, int leaseTerm) {
        super(contractType, date, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment );
        this.originalPrice = originalPrice;
        this.leaseFeePercent = leaseFeePercent;
        this.interestRate = interestRate;
        this.leaseTerm = leaseTerm;
    }

    @Override
    public double getTotalPrice() {
        return originalPrice * (1 + leaseFeePercent);
    }
    @Override
    public double getMonthlyPayment() {
        double principal = getTotalPrice() * 0.5; //50% of og price for the lease
        double monthlyRate = interestRate / 12;
        return (principal * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -leaseTerm));
    }

    //TODO toString() format, looks like its possible :'D Sidenote, probably gonna make Contract -> String/Date instead
    //This is just a template from the SalesContract toString(), feel free to remove/modify
    @Override
    public String toString () {
        return //contractType + String.format("\nDate Purchased: %,s", date).replace(",","_") +
                //String customerName
                //String customerEmail
                "\n\nVehicle Sold Information" +
                String.format("\nVIN #: %,d", vehicleSold.getVINNumber()).replace(",","_") +
                "\nYear: " + vehicleSold.getYear() +
                "\nMake: " + vehicleSold.getMake() +
                "\nModel: " + vehicleSold.getModel() +
                "\nVehicle Type: " + vehicleSold.getVehicleType() +
                "\nColor: " + vehicleSold.getColor() +
                String.format("\nOdometer: %,d", vehicleSold.getOdometer()) +
                String.format("\nPrice: $%,.2f%n", vehicleSold.getPrice()) +
                "Payment Info\n" +
                //double salesTaxAmount
                //double recordingFee
                //double processingFee,
                //double totalPrice
                //String wantsToFinance + double monthlyPayment
                "----------------------------";
    }

}
