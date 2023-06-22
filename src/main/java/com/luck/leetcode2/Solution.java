package com.luck.leetcode2;

import com.luck.common.ListNode;

/**
 * @author zhuxs2
 * @date 2023/6/22 19:14:03
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while (l1 != null || l2 != null) {
            int first = 0;
            if (l1 != null) {
                first = l1.val;
                l1 = l1.next;
            }

            int second = 0;
            if (l2 != null) {
                second = l2.val;
                l2 = l2.next;
            }

            temp.next = new ListNode((first + second + carry) % 10);
            carry = (first + second + carry) / 10;
            temp = temp.next;
        }

        if (carry != 0){
            temp.next = new ListNode(carry);
        }

        return result.next;
    }
}
