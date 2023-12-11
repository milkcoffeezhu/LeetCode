package com.luck.leetcode20;

import java.util.Stack;

/**
 * @author zhuxs2
 * @date 2023/12/9 22:00:27
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 1 左括号必须用相同类型的右括号闭合。
 * 2 左括号必须以正确的顺序闭合。
 * 3每个右括号都有一个对应的相同类型的左括号。
 * 使用栈处理这个题
 * 1 当一个元素过来的时候判断当前栈顶是否与当前元素匹配
 * 2 如果匹配栈顶元素出栈
 * 3 如果不匹配当前元素进栈
 *
 */
public class Solution {

    public static boolean isValid(String s) {
        if (s.length() == 1){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (stack.isEmpty()){
                stack.push(c);
            }else {
                char peek = stack.peek();

                if (c == ')' && peek == '(') {
                    stack.pop();
                } else if (c == '}' && peek == '{') {
                    stack.pop();
                } else if (c == ']' && peek == '[') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
    }
}
