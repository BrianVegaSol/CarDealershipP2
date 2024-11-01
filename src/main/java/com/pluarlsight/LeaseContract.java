package com.pluarlsight;

public class LeaseContract extends Contract {
    private double originalPrice;
    private double leaseFeePercent = 0.07;
    private double interestRate = 0.04;
    private int leaseTerm = 36; //all leases financed at 4% for 36 mo.


    public LeaseContract(String date, String customerName, String customerEmail, String vehicleSold, double originalPrice, double totalPrice, double monthlyPayment) {
       // i still need to fix this -dm
        super(date, customerName, customerEmail, vehicleSold, totalPrice,monthlyPayment );

        this.originalPrice = originalPrice;

    }
    public double getEndPrice(){
        return originalPrice/2;
    }
    public double getLeaseFee(){
        return originalPrice * leaseFeePercent;
    }
    //@Override
    public double getTotalPrice() {
        return originalPrice * (1 + leaseFeePercent);
    }
   // @Override
    public double getMonthlyPayment() {
        double principal = getTotalPrice() * 0.5; //50% of og price for the lease
        double monthlyRate = interestRate / 12;
        return (principal * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -leaseTerm));
    }

}
