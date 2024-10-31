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
        final double SALES_TAX_AMOUNT = super.totalPrice * 0.05;
        final int RECORDING_FEE = 100;

        double processingFee = 0;
        //Processing Fee Calc
        if (super.totalPrice > 10_000) {
            processingFee = 295;
        } else {
            processingFee = 495;
        }

        double totalPrice = SALES_TAX_AMOUNT + RECORDING_FEE + processingFee + super.totalPrice;
        return totalPrice;
    }

    //TODO move the souts into the UserInterface
    @Override
    public double getMonthlyPayment() {
        boolean wantsFinance = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want to finance your vehicle?\n1) Yes\n2) No");
        int financeInput = scan.nextInt();
        if (financeInput == 1) {
            wantsFinance = true;
        } else {
            System.out.println("Great! You chose to opt out of the loan! Yay no debt! :D");
            //Should this return 0?
            return monthlyPayment;
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
        //TODO might not display properly
            System.out.printf("Your loan rate is %.2f%%\nYour Loan Term is %d months%n", loanRate, loanTermInMonths);
        }
       monthlyPayment = (monthlyPayment * loanRate * loanTermInMonths) / loanTermInMonths;

        //double monthlyPayment = (super.totalPrice * loanRate * loanTermInMonths) / 12;
        return monthlyPayment;
    }
}
