package com.pluralsight;

import java.sql.SQLException;

//aaaa
public class Main {
    public static void main(String[] args) throws SQLException {
        /*SalesContract s = new SalesContract("1","Bob","@me","Ford Explorer",
                1_000,50);*/
        //System.out.println(s.getMonthlyPayment());
        DealershipFileManager.getDealership();
        if (!UserInterface.exitApp) {
            UserInterface.display();
        }
        UserInterface.scan.close();
        //close bufferreader

        //code written by Brian for example
        //New text
    }
}