package com.toasternetwork.exercise.tempconverter;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static void printHeader() {
        Arrays.stream(new String[] {
                "CST-105 Exercise #2 - Temperature Converter",
                "By Adonis S. Deliannis",
                ""
        }).forEach(System.out::println);
    }

    public static void main(String[] args) {
        printHeader();
        Scanner br = new Scanner(System.in);
        try {
            System.out.print("Please enter temperature °C: ");
            double tempC = Double.parseDouble(br.nextLine());
            System.out.printf("%f°C = %f°F%n", tempC, Temperature.ToFarenheight(tempC));

            System.out.print("Please enter temperature °F: ");
            double tempF = Double.parseDouble(br.nextLine());
            System.out.printf("%f°F = %f°C%n", tempF, Temperature.ToCelcius(tempF));

        } catch (NumberFormatException nfe) {
            System.err.printf("%s is not a number. Try again.%n", nfe.getMessage());
        }catch (IllegalArgumentException iae) {
            System.err.println(iae.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
