package com.toasternetwork.exercise.numbersplicer;

import java.util.ArrayList;
import java.util.Collections;

public class NumberSpliceHelper {

    // Constant Length = 5
    private static final int Length = 5;

    /**
     * Splits a whole number into an array of individual digits if the number meets certain criteria
     * @param number A whole number to split
     * @return Array of individual digits
     * @throws IllegalArgumentException Number does not meet criteria
     */
    private static Integer[] checkIntLenAndSplit(Integer number) throws IllegalArgumentException {
        Integer[] ia = splitToArray(number);
        if(ia.length != Length)
            throw new IllegalArgumentException(String.format("Number is not %d digits in length", Length));
        return ia;
    }

    /**
     * Removes all leading zeroes from array
     * @param ia Array to truncate
     * @return Leading zero truncated array.
     * @throws ArrayStoreException Array is all zeroes
     */
    private static Integer[] truncateZeros(Integer[] ia) throws ArrayStoreException {
        int index = -1;

        // run through array, find the first non-zero number
        for(int i = 0; i < ia.length; i++) {
            if(ia[i] != 0){
                index = i;
                break;
            }
        }

        if(index == -1) throw new ArithmeticException("Array has all zeroes.");

        Integer[] na = new Integer[ia.length - index];

        // Move numbers into new array
        System.arraycopy(ia, index, na, 0, na.length);

        return na;
    }

    /**
     * Splits a whole number into an array of individual digits
     * @param number A whole number to split
     * @return Array of individual digits
     */
    private static Integer [] splitToArray(Integer number) {
        return splitToArray(number, 0);
    }

    /**
     * Splits a whole number into an array of individual digits
     * @param number A whole number to split
     * @param length The length of the array
     * @return Array of individual digits
     * @throws ArithmeticException Array is all zeroes
     * @implNote If the length is specified as 0, then the string length of the number is used.
     */
    private static Integer[] splitToArray(Integer number, Integer length) throws ArithmeticException {
        ArrayList<Integer> ia = new ArrayList<>();
        for(int i = 0;i < (length == 0 ? number.toString().length() : length); i++) {
                ia.add((int) (number / (Math.pow(10, i))) % 10);
        }

        Integer[] r = new Integer[ia.size()];
        Collections.reverse(ia);
        return truncateZeros(ia.toArray(r));
    }

    /**
     * Splits a whole number into an array of individual digits
     * @param number A whole number to split
     * @return Array of individual digits
     */
    public static Integer[] split(Integer number)  {
        return checkIntLenAndSplit(number);
    }
}
