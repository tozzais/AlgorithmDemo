package com.example.algorithmdemo.test;


import org.junit.Test;

import java.util.Arrays;

/**
 * 321. 拼接最大数
 */
public class LeetCode20201203Test {

    @Test
    public void test() {

        System.out.println(countPrimes(0));
        System.out.println(countPrimes(1));
        System.out.println(countPrimes(10));


    }

    public int countPrimes(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                ans += 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;

    }
    /**
     * 判断一个数是否为质数
     * @param n
     * @return
     */
    private boolean isPrime(int n) {
        for (int i = 2; i*i <= n ; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


}