package com.luck.leetcode4;

/**
 * @author zhuxs2
 * @date 2023/6/24 12:09:23
 */
public class Solution {

    /**
     * 1 将两个数组合并之后在进行排序
     * 2 时间时间复杂度O(m+n)
     * 3 空间复杂度S(m+n)
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] merge = new int[len1 + len2];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i<len1 || j< len2){
            if (nums1[i] < nums2[j]){
                merge[index++] = nums1[i++];
            }else {
                merge[index++] = nums2[j++];
            }
        }

        int sum = len1 + len2;
        if (sum%2 == 0){
            return (double) (merge[sum/2] + merge[sum/2-1])/2;
        }else {
            return (double) merge[sum/2];
        }
    }
}
