package com.toasternetwork.exercise.numbersplicer;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static void calculate(Integer integer) {
        Integer[] numbers = NumberSpliceHelper.split(integer);
        Integer result = 0;
        StringBuilder msg = new StringBuilder();
        for (int i = 0, numbersLength = numbers.length; i < numbersLength; i++) {
            Integer number = numbers[i];
            msg.append(String.format("%d %s ", number, (i == numbers.length - 1 ? "=" : "+")));
            result += number;
        }
        System.out.printf("%s %d%n", msg.toString().strip(), result);
    }

    private static void printHeader() {
        Arrays.stream (new String[] {
                "CST-105 Exercise #2 - Number Splicer Calculator",
                "By Adonis S. Deliannis",
                ""
        }).forEach(System.out::println);
    }

    public static void main(String[] args) {
        printHeader();
        Scanner br = new Scanner(System.in);
        try {
            System.out.print("Please enter a 5-digit number: ");
            calculate(Integer.parseInt(br.nextLine()));
        } catch (NumberFormatException nfe) {
            System.err.printf("%s is not a number. Try again.%n", nfe.getMessage());
        }catch (IllegalArgumentException iae) {
            System.err.println(iae.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
