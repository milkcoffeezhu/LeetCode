package com.luck.leetcode11;

/**
 * @author zhuxs2
 * @date 2023/8/9 21:11:44
 * 暴力解法
 * 1 枚举每两个柱子之间可以存储水的容量
 * 2 在迭代获取最大值
 * 时间复杂度o(n*n) 空间复杂度的o(1)
 *
 * 优化解法：
 * 1 在暴力解法中计算公式 S = min(h[i],h[j]) * (j - i) (i<=j)
 * 2 根据上面的公式得到如下结论：S的大小和i,j之间距离有关 S大小和h[i] h[j]中最小值有关
 * 3 假如h[i] > h[j] 移动i 因为水的多少只会由最短长度决定同时在移动的过程中 i,j 距离不断减小 所以S =< h[j] * (j-i)一定成立
 *   
 */
public class Solution {
    public int maxArea(int[] height) {
        return 0;
    }

    /**
     * 暴力解法
     */
    public int maxArea01(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return maxArea;
    }
}
