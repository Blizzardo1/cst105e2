package com.toasternetwork.exercise.tempconverter;

public class Temperature {
    public static double ToCelcius(double farenheight){
        return (farenheight - 32) * ((double) 5/9);
    }

    public static double ToFarenheight(double celcius) {
        return ((double)9/5) * celcius + 32;
    }
}
