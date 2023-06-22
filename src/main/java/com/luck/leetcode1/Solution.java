package com.luck.leetcode1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuxs2
 * @date 2023/6/22 18:58:09
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[]{0,0};
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }else {
                map.put(nums[i], i);
            }
        }

        return result;
    }
}
