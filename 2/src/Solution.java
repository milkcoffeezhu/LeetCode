/**
 * @Author: zxs
 * @Date: 2019/10/10 13:11
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     * 解题思路
     * 1 需要重新创建四个临时的链表对象，分别是对l1 l2 返回结果的引用
     * 2 l1 l2同时还有下一个节点就需要一直相加，知道其中一个不存在下一个节点
     * 3 在上面相加完成之后可能还是存在进位需要一起算上
     * 4 单独处理剩下还没有相加完的链表
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode tempRes = new ListNode(0);
        ListNode res = tempRes;

        int num = 0;
        while (n1 != null && n2 != null){
            tempRes.next = new ListNode((n1.val + n2.val + num)%10);
            tempRes = tempRes.next;
            num = (n1.val + n2.val + num)/10;
            n1 = n1.next;
            n2 = n2.next;
        }

        while (n1 != null){
            tempRes.next = new ListNode((n1.val + num)%10);
            tempRes = tempRes.next;
            num = (n1.val + num)/10;
            n1 = n1.next;
        }

        while (n2 != null){
            tempRes.next = new ListNode((n2.val + num)%10);
            tempRes = tempRes.next;
            num = (n2.val + num)/10;
            n2 = n2.next;
        }

        if (num != 0){
            tempRes.next = new ListNode(num);
        }

        return res.next;
    }

    public static void main(String[] args) {

        //243 564
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode listNode = addTwoNumbers(l1, l2);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
