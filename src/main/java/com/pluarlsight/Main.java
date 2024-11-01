package com.pluarlsight;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
//aaaa test
public class Main {
    public static void main(String[] args) {

        if (!UserInterface.exitApp) {
            UserInterface.display();
        }
        UserInterface.scan.close();
        //close bufferreader
    }
}