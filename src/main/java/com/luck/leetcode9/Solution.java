package com.luck.leetcode9;

/**
 * @author zhuxs2
 * @date 2023/8/9 20:57:26
 */
public class Solution {
    /**
     * 1 负数一定不是回文数字
     * 2 非负数可能是回文数
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int source = x;
        int result = 0;
        while (source != 0) {
            int mod = source % 10;
            if (result > (Integer.MAX_VALUE - mod)/10){
                return false;
            }
            result = result * 10 + mod % 10;
            source = source / 10;
        }

        return result == x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(123));
    }
}
