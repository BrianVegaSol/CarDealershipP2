package com.pluarlsight;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
//Shows Current Time
public class Helper {
    public static void showCurrentTime() {
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = currentTime.format(formatter);
        System.out.println("Current Time: " + formattedTime);
    }
}