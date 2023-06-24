package com.luck.leetcode3;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhuxs2
 * @date 2023/6/24 11:24:06
 */
public class Solution {
    /**
     * 使用滑动窗口
     * 1 假设从位置i到j是不存在重复的子串
     * 2 那么当我开始移动i的时候，从[i+1,j]也是一个不重复字母的子串，这时可以尝试向右移动j直到[i+1,j+x]中存在重复的字母，所以当前的长度就是j+x-i-1
     * 3 那我没只需要使用一个容器来存放字符即可，set都可用来存储中途遍历的子串，当i向后移动的时候，需要将第i个从里面删除
     * 4 遍历完成之后的到就是最长的长度
     */
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }

        int maxLen = 1;
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = i + 1;
        set.add(s.charAt(0));
        while (i < len && j < len) {
            char curChar = s.charAt(j);
            //当没有包含的时候，j向后移动并且计算当前字符串的最长长度
            if (!set.contains(curChar)) {
                set.add(curChar);
                maxLen = Math.max(j - i + 1, maxLen);
                j++;
            } else {
                // 当已经包含了就需要记录当前的最大长度然后移动左边指针
                set.remove(s.charAt(i));
                i++;
            }
        }

        return maxLen;
    }
}
