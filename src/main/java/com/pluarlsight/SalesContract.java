package com.pluarlsight;

import java.util.Scanner;

import static com.pluarlsight.Dealership.inventory;

public class SalesContract extends Contract {

    public SalesContract(String date, String customerName, String customerEmail, String vehicleSold, double totalPrice,
                         double monthlyPayment) {
        super(date, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
    }

    @Override
    public double getTotalPrice() {
        //Use this somehow to getPrice?
        //var vehiclePrice = Dealership.getVehiclesByMakeModel("Ford", "Explorer");
        final double SALES_TAX_AMOUNT = super.totalPrice * .95;
        final int RECORDING_FEE = 100;

        double processingFee = 0;
        //Processing Fee Calc
        if (super.totalPrice > 10_000) {
            processingFee = 295;
        } else {
            processingFee = 495;
        }

        double fees = SALES_TAX_AMOUNT + RECORDING_FEE + processingFee;



        return totalPrice;
    }

    @Override
    public double getMonthlyPayment() {
        boolean wantsFinance = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want to finance your vehicle?\n1) Yes\n2) No");
        int financeInput = scan.nextInt();
        if (financeInput == 1) {
            wantsFinance = true;
        }
        double loanRate;
        int loanTermInMonths;
        //Loan Term & Month Calc
        if (wantsFinance) {
        //Loan Calc
        if (super.totalPrice > 10_000) {
            loanRate = .0425;
            loanTermInMonths = 48;
        } else {
            loanRate = .0525;
            loanTermInMonths = 24;
        }
        //TODO might not display properly
            System.out.printf("Your loan rate is %.2f%%\nYour Loan Term is %d months", loanRate, loanTermInMonths);
        } else {
            return 0;
        }
        return 0;
    }
}
