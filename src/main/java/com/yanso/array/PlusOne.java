package com.yanso.array;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        if (carry > 0) {
            int[] newDigits = new int[digits.length + 1];
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            newDigits[0] = carry;
            return newDigits;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] testDigits = {9, 9, 9};
        int[] result = new PlusOne().plusOne(testDigits);
        System.out.println(Arrays.toString(result));
    }
}
