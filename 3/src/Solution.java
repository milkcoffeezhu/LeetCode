import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zxs
 * @Date: 2019/10/10 19:17
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     *解题思路：滑动窗口
     * 1 由于字串中是不含有重复的字符，所以可以从最开始开始遍历字符串
     * 2 使用一个set存放以及遍历过的字符，使用一个变量index用来存放刚开始字符所在位置的下标
     * 3 假如遍历的字符没有在set里，那么目前的最长长度为max(len,curIndex - index + 1)
     * 4 假如当前的字符已经存在，那么修改index的值为当前字符所在位置的下标
     * 5 重复上述步骤直到遍历完成
     */
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        int len = s.length();
        int i = 0,j = 0;

        while (i < len && j < len){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                res = Math.max(res,j - i);
            }else {
                set.remove(s.charAt(i++));
            }
        }

        return res;
    }

    public static int lengthOfLongestSubstringMap(String s){

        return 0;
    }

    public static void main(String[] args) {
        String str1 = "bbbbbbbbbbb";
        String str2 = "pwwkew";
        String str3 = "dvdf";

        System.out.println(lengthOfLongestSubstring(str1));
        System.out.println(lengthOfLongestSubstring(str2));
        System.out.println(lengthOfLongestSubstring(str3));
    }
}
