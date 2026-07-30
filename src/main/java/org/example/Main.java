package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    // 1) Palindrome
    public static boolean checkForPalindrome(String input) {
        if (input == null) return false;

        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            char cL = input.charAt(left);
            char cR = input.charAt(right);

            if (!Character.isLetterOrDigit(cL)) { left++; continue; }
            if (!Character.isLetterOrDigit(cR)) { right--; continue; }

            if (Character.toLowerCase(cL) != Character.toLowerCase(cR)) return false;

            left++;
            right--;
        }
        return true;
    }

    // 3) Decimal -> Binary (Stack/Deque ile)
    public static String convertDecimalToBinary(int number) {
        if (number == 0) return "0";

        boolean negative = number < 0;
        int n = Math.abs(number);

        Deque<Integer> stack = new ArrayDeque<>();

        while (n > 0) {
            stack.push(n % 2);
            n /= 2;
        }

        StringBuilder sb = new StringBuilder();
        if (negative) sb.append('-');

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(checkForPalindrome("I did, did I?")); // true
        System.out.println(convertDecimalToBinary(13));          // 1101
    }
}
