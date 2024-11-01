package com.pluarlsight;

public class LeaseContract extends Contract {
    private double originalPrice;
    private double leaseFeePercent = 0.07;
    private double interestRate = 0.04;
    private int leaseTerm = 36; //all leases financed at 4% for 36 mo.


    public LeaseContract(String date, String customerName, String customerEmail, String vehicleSold,
                          double totalPrice, double monthlyPayment, double originalPrice, double leaseFeePercent,
                         double interestRate, int leaseTerm) {
        super(date, customerName, customerEmail, vehicleSold, totalPrice,monthlyPayment );
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

}
