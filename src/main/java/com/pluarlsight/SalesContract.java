package com.pluarlsight;

import java.util.Scanner;

public class SalesContract extends Contract {
    private double salesTaxAmount;
    private double recordingFee;
    private double processingFee;
    private String wantsToFinance;

    //either add all Vehicle vars to constructor or (probably the )
    //make them = vehicleSold
    public SalesContract (String contractType, String date, String customerName, String customerEmail,
                         Vehicle vehicleSold,
                         double salesTaxAmount, double recordingFee, double processingFee,
                         double totalPrice, String wantsToFinance, double monthlyPayment) {
        super("SALE", date, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.wantsToFinance = wantsToFinance;
        /* vehicleSold.add(vehicleSold.get(i).getVINNumber(), int year, String make, String model,
        String vehicleType, String color, int odometer, double price)*/
    }

    public String getWantsToFinance() {
        return wantsToFinance;
    }

    public void setWantsToFinance(String wantsToFinance) {
        this.wantsToFinance = wantsToFinance;
    }

    @Override
    public double getTotalPrice() {
        salesTaxAmount = super.totalPrice * 0.05;
        recordingFee = 100;

        //Processing Fee Calc
        if (super.totalPrice > 10_000) {
            processingFee = 295;
        } else {
            processingFee = 495;
        }

        double totalPrice = salesTaxAmount + recordingFee + processingFee + super.totalPrice;
        return totalPrice;
    }

    //TODO move the souts into the UserInterface
    //TODO might be using monthlyPayment car from Contract wrong
    @Override
    public double getMonthlyPayment() {
        boolean wantsFinance = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want to finance your vehicle?\n1) Yes\n2) No");
        int financeInput = scan.nextInt();
        if (financeInput == 1) {
            wantsFinance = true;
            wantsToFinance = "YES";
        } else {
            System.out.println("Great! You chose to opt out of the loan! Yay no debt! :D");
            wantsToFinance = "NO";
            //Should this return 0?
            return 0;
        }
        //Loan Term & Month Calc
        double loanRate = 0;
        int loanTermInMonths = 0;
        if (wantsFinance) {
            //Loan Calc
            if (super.totalPrice > 10_000) {
                loanRate = 1.0425;
                loanTermInMonths = 48;
            } else {
                loanRate = 1.0525;
                loanTermInMonths = 24;
            }
            System.out.printf("Your loan rate is %.2f%%\nYour Loan Term is %d months%n", loanRate, loanTermInMonths);
        }
        monthlyPayment = (monthlyPayment * loanRate * loanTermInMonths) / loanTermInMonths;

        //double monthlyPayment = (super.totalPrice * loanRate * loanTermInMonths) / 12;
        return monthlyPayment;
    }

    //TODO toString() format, looks like its possible :'D Sidenote, probably gonna make Contract -> String/Date instead
    @Override
    public String toString() {
        return //contractType + String.format("\nDate Purchased: %,s", date).replace(",","_") +
                //String customerName
                //String customerEmail
                "\n\nVehicle Sold Information" +
                        String.format("\nVIN #: %,d", vehicleSold.getVINNumber()).replace(",", "_") +
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
