package com.yanso.math;

import java.util.BitSet;

public class primeNumberSieve {
    public static void sieve(int n) {
        // 下面的方法称作《埃拉托斯特尼筛法》，用于计算素数
        // 创建一个大小为n+1的位集合，初始情况下默认每一位都是false
        BitSet isComposite = new BitSet(n + 1);
        // 标记0和1为合数，true
        isComposite.set(0);
        isComposite.set(1);
        for (int p = 2; p * p <= n; p++) {
            // 如果一个数n是合数，那么它至少有一个因子 <= √n，比如 2 * 3 = 6，3 <= √6
            // 所以我们只需要筛到 √n 就可以了
            if (!isComposite.get(p)) {
                // 如果p是质数，那么从p的平方开始，筛掉它的所有倍数
                // 这里k从p的平方处开始就行，小于p平方的都被筛过了
                for (int k = p * p; k <= n; k += p) {
                    // 标记k为合数
                    isComposite.set(k);
                }
            }
        }
        // nextClearBit(int fromIndex)：返回从fromIndex开始的第一个为false的位的索引，在这里也就是质数
        for (int i = isComposite.nextClearBit(2); i >= 0 && i <= n; i = isComposite.nextClearBit(i + 1)) {
            System.out.print(i + " ");
        }
    }
     public static void main(String[] agrs) {
        int N = 100;
        sieve(N);
    }
}
