package com.pluarlsight;

abstract public class Contract {
    //TODO potential mistake making this static and Type Contract
    //TODO Strongly considering making this String again || Date/Time
    protected static Contract contractType;
    protected String date;
    protected String customerName;
    protected String customerEmail;
    protected Vehicle vehicleSold;
    protected double totalPrice;
    protected double monthlyPayment;

    public Contract (Contract contractType, String date, String customerName, String customerEmail,
                     Vehicle vehicleSold, double totalPrice, double monthlyPayment) {
        this.contractType = contractType;
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
    }

    public static Contract getContractType() {
        return contractType;
    }

    public String getDate() {
        return date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }
    abstract public double getTotalPrice();
    abstract public double getMonthlyPayment();


    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
