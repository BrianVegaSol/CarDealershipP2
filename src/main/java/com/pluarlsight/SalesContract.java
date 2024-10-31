package com.pluarlsight;

public class SalesContract extends Contract{

    public SalesContract(String date, String customerName, String customerEmail, String vehicleSold, double totalPrice,
                         double monthlyPayment) {
        super(date, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }
}
