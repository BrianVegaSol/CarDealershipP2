package com.pluarlsight;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
//aaaa
public class Main {
    public static void main(String[] args) {
        DealershipFileManager.getDealership();
        if (!UserInterface.exitApp) {
            UserInterface.display();
        }
        UserInterface.scan.close();
        //close bufferreader demo
        //test

    }
}