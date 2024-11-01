package com.pluarlsight;

public class Vehicle {
        private int VINNumber;
        private int year;
        private String make;
        private String model;
        private String vehicleType;
        private String color;
        private int odometer;
        private double price;

        public Vehicle(int VINNumber, int year, String make, String model, String vehicleType,
                       String color, int odometer, double price) {
            this.VINNumber = VINNumber;
            this.year = year;
            this.make = make;
            this.model = model;
            this.vehicleType = vehicleType;
            this.color = color;
            this.odometer = odometer;
            this.price = price;
        }

        public void setVINNumber(int VINNumber) {
            this.VINNumber = VINNumber;
        }

        public int getVINNumber() {
            return VINNumber;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getYear() {
            return year;
        }

        public void setMake(String make) {
            this.make = make;
        }

        public String getMake() {
            return make;
        }

        public String getModel() {
            return model;
        }

        public void setVehicleType(String vehicleType) {
            this.vehicleType = vehicleType;
        }

        public String getVehicleType() {
            return vehicleType;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }

        public void setOdometer(int odometer) {
            this.odometer = odometer;
        }

        public int getOdometer() {
            return odometer;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getPrice() {
            return price;
        }

        public String toString() {
            return "\nVIN #: " + VINNumber +
                    "\nYear: " + year +
                    "\nMake: " + make +
                    "\nModel: " + model +
                    "\nVehicle Type: " + vehicleType +
                    "\nColor: " + color +
                    "\nOdometer: " + odometer +
                    String.format("\nPrice: $%,.2f%n", price) +
                    "----------------------------";
        }
    }