package com.luck.leetcode5;

/**
 * @author zhuxs2
 * @date 2023/6/24 16:34:17
 */
public class Solution {
    /**
     * 1 长度为1的字符串显然是回文字符串
     * 2 当长度为2时，只要两个字符相同也是回文字符串
     * 3 当长度大于2的时候，使用P[i,j]表示一个字符串是否是回文字符串存在两种情况
     * P[i,j] = true(是回文字符串)
     * P[i,j] = false(不是回文字符串)
     * 如果P[i,j]是回文字符串那么的一定满足P[i+1,j-1]是回文字符串并且S[i] == S[j]
     * 通过上述分析的到如下状态转移表达式
     * <p>
     * P[i,j] = P[i+1,j-1] & s[i] == s[j] 字符串长度大于2
     * P[i,i] = true 一个字符一定是回文字符串
     * P[i,i+1] = true(s[i] == s[i+1]) 只要两个字符相同那么也是回文字符串
     * <p>
     * 在这里使用一个二维数组保存状态，因为使用使用两个位置才能唯一确定一个值
     * <p>
     * 最终最长的回文字符串就是二维数组中值为true并且j-i+1最大对应字符串下标就是最长回文子串
     */
    public String longestPalindrome(String s) {

        int len = s.length();
        // 长度小于2的一定是回文字符串,直接返回
        if (len < 2) {
            return s;
        }

        // 初始化用于记录状态的数组
        boolean[][] dp = new boolean[len][len];

        //初始化长度为1的二维数组
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        int startIndex = 0;
        int maxLen = 1;

        char[] charArray = s.toCharArray();

        // 从长度为2的开始枚举一直到长度等于len的所有字符串
        for (int L = 2; L <= len; L++) {
            // 枚举当长度为L时的每一个子串
            for (int i = 0; i < len; i++) {

                // 计算右边下标
                int j = L + i - 1;

                // 如果右边下标已经大于等于Len说明已经越界,直接跳出循环,如一个字符串长度为2,当L=2，i=1时 j=2此时j已经超出dp二维数组的下标
                if (j >= len) {
                    break;
                }

                // 根据递推公司判断s[i]是否等于s[j]
                if (charArray[i] != charArray[j]) {
                    // 如果s[i] != s[j] 那么p[i,j]就不是回文字符串
                    dp[i][j] = false;
                } else {
                    // 当长度为2的时候s[i] == s[i]是回文字符串
                    if (L == 2) {
                        dp[i][j] = true;
                    } else {
                        // 当长度大于2直接使用递推公司
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 当p[i,j]是回文字符串的时候,判断是不是最长的，递归保存
                if (dp[i][j] && j - i + 1 > maxLen) {
                    startIndex = i;
                    maxLen = j - i + 1;
                }
            }
        }

        return s.substring(startIndex, startIndex + maxLen);
    }
}
