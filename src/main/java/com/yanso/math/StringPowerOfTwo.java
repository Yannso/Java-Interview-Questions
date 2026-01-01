package com.yanso.math;

import java.math.BigInteger;

public class StringPowerOfTwo {
    public static void main(String[] args) {
        int num1 = 2;
        int nums2 = 1000;
        String res = powFast(num1,nums2);
        System.out.println(res);
    }

    private static String powFast(int base, int power) {
        // 快速幂版本
        if (power == 0) return "1";
        
        String result = "1";
        String currentBase = Integer.toString(base);
        int exp = power;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = multiplyStrings(result, currentBase); // 乘以一次底数
            }
            currentBase = multiplyStrings(currentBase, currentBase); // 底数平方
            exp >>= 1; // 指数右移一位，相当于除以2
        }
        return result;
    }

    private static String pow(int base, int power) {
        // 普通写法
        // base ** power
        if (power == 0) return "1";

        String result = "1";
        String baseStr = Integer.toString(base);

        for (int i = 0; i < power; i++) { // power times
            result = multiplyStrings(result, baseStr);
        }

        return result;
    }

    private static String multiplyStrings(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int m = num1.length();
        int n = num2.length();

        int[] product = new int[m + n]; // max length of product is m + n

        for (int i = m - 1; i  >= 0; i--) {
            int digit1 = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int digit2 = num2.charAt(j) - '0';
                int mul = digit1 * digit2;

                int pos = i + j + 1; // 当前位
                int carryPos = i + j; // 进位

                int sum = mul + product[pos]; // product[pos] 可能存储了上一轮的进位，所以要加上

                product[pos] = sum % 10; // 当前位
                product[carryPos] += sum / 10; // 这一轮可能产生新的进位，所以用+=
            }
        }

         // 将结果数组转换为字符串
        StringBuilder sb = new StringBuilder();
        for (int num : product) {
            // 跳过前导零
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
        
    // 使用 BigInteger 类实现 pow 操作
    private static String powBitInteger(int num1, int num2) {
        BigInteger base = BigInteger.valueOf(num1);

        BigInteger powBigInteger = base.pow(num2);
        return powBigInteger.toString();
    }
}
