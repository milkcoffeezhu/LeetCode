import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zxs
 * @Date: 2019/10/10 12:49
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     *解题思路如下
     * 1 从头开始遍历数组，使用一个Map存储数据 key为元素的值 value为元素的在数组中的index
     * 2 对于数组中的每一个元素,计算target减去当前数组中的值，检查是否存在的Map
     * 3 假如存在在Map中根据value 获取对应的下边与当前的下标返回数据，不存在继续遍历下一个元素
     * 4 遍历但最后不存在对应的两个数字返回-1 -1 表示不存在
     * 5 需要检查边界条件，输入的数组包含的元素个数是否大于等于2,数字是否为null
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2){
            return new int[]{-1,-1};
        }

        Map<Integer,Integer> numAndIndexMap = new HashMap<>();

        for (int i = 0; i <nums.length; i++) {
            if (numAndIndexMap.containsKey(target - nums[i])){
                return new int[]{numAndIndexMap.get(target - nums[i]),i};
            }else {
                numAndIndexMap.put(nums[i],i);
            }
        }

        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 7, 11, 15};
        int target = 9;

        for (int i : twoSum(array, target)) {
            System.out.println(i);
        }
    }
}
