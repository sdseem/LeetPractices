package org.example;


public class Main {
    public static void main(String[] args) {

    }

    private static int myAtoi(String s) {
        boolean isNegative = false;
        boolean isNumberStarted = false;
        int i = 0;
        if (s.isEmpty()) {
            return 0;
        }
        while (s.charAt(i) == ' ') {
            i++;
        }
        while (!Character.isDigit(s.charAt(i))) {
            if (s.charAt(i) != '-' && s.charAt(i) != '+') {
                return 0;
            }
            if (s.charAt(i) == '-') {
                isNegative = !isNegative;
            }
            i++;
        }
        int maxIntDiv = Integer.MAX_VALUE / 10 + 1;
        int out = 1;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            if (!isNumberStarted && s.charAt(i) != '0') {
                out = Character.getNumericValue(s.charAt(i));
                isNumberStarted = true;
            } else if (isNumberStarted) {
                if (out > maxIntDiv) {
                    return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                out = out*10 + Character.getNumericValue(s.charAt(i));
                if (out < 0) {
                    return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            }
            i++;
        }
        if (!isNumberStarted) {
            return 0;
        }
        if (isNegative) {
            return -out;
        } else {
            return out;
        }
    }
}