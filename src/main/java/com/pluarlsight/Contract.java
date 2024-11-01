package com.pluarlsight;

import java.util.ArrayList;
import java.util.List;

abstract public class Contract {
    //protected static Contract contract;
    protected static String contractType;
    protected String date;
    protected String customerName;
    protected String customerEmail;
    protected Vehicle vehicleSold;
    protected double totalPrice;
    protected double monthlyPayment;

    public Contract (String contractType, String date, String customerName, String customerEmail,
                     Vehicle vehicleSold, double totalPrice, double monthlyPayment) {
        this.contractType = contractType;
        //this.contract = contract;
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
    }

    /*public static Contract getContract() {
        return contract;
    }*/

    public static String getContractType() {
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
