package com.luck.leetcode7;

/**
 * @author zhuxs2
 * @date 2023/8/2 22:11:28
 */
public class Solution {
    /**
     * 1 首先初始化返回变量 result = 0;
     * 2 x每次对10取余数 mod = x%10，然后 x = x/10;
     * 3 if x > 0 判断 result * 10 + mod > Max => result > (Max - mod)/10 return 0 else continue
     * if x < 0 判断 result * 10 + mod < Min => result < (Min - mod)/10 return 0 else continue
     * 4 重复上述操作
     */
    public static int reverse(int x) {

        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        int result = 0;

        boolean positive = x >= 0;
        int mod = 0;

        while (x != 0) {
            mod = x % 10;
            x = x / 10;
            if (positive && result > (max - mod)/10) {
                return 0;
            } else if (!positive && result < (min - mod)/10) {
                return 0;
            }

            result = result * 10 + mod;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
