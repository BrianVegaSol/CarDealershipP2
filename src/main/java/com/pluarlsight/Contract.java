package com.pluarlsight;

abstract public class Contract {
    protected String date;
    protected String customerName;
    protected String customerEmail;
    protected String vehicleSold;
    protected double totalPrice;
    protected double monthlyPayment;
  //aw
    public Contract (String date, String customerName, String customerEmail, String vehicleSold,
                     double totalPrice, double monthlyPayment) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
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

    public String getVehicleSold() {
        return vehicleSold;
    }
    abstract public double getTotalPrice();
    abstract public double getMonthlyPayment();


    public void setVehicleSold(String vehicleSold) {
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
