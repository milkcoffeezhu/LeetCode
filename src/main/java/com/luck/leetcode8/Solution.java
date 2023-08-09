package com.luck.leetcode8;

/**
 * @author zhuxs2
 * @date 2023/8/8 21:07:45
 */
public class Solution {
    public static int myAtoi(String s) {

        String trimmed = s.trim();
        if (trimmed.isEmpty()) {
            return 0;
        }

        int maxValue = Integer.MAX_VALUE;
        int minValue = Integer.MIN_VALUE;

        int result = 0;
        int positive = 1;
        boolean hasUsed = false;

        for (int i = 0; i < trimmed.length(); i++) {
            char c1 = trimmed.charAt(0);
            if (i == 0 && c1 == '-') {
                positive = -1;
            }else if (i == 0 && c1 == '+'){
              positive = 1;
            } else if (i == 0 && !Character.isDigit(c1)) {
                return result;
            }else {
                char c = trimmed.charAt(i);
                if (Character.isDigit(c)) {
                    int num = c - '0';
                    if (hasUsed && result != 0) {
                        result = result * positive;
                        hasUsed = true;
                    } else {
                        if (result > 0 && result > (maxValue - num) / 10) {
                            return maxValue;
                        } else if (result < 0 && result < (minValue - (positive * num)) / 10) {
                            return minValue;
                        } else {
                            result = result * 10 + num * positive;
                        }
                    }
                } else if ( i != 0){
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("+1"));
    }
}
