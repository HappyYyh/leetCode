package random;

import java.util.LinkedList;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * All rights Reserved, Designed By yyh
 * 反转链表
 * @Package simple
 * @author: yyh
 * @date: 2019-12-30 18:56
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_206 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * my result(once pass, time over 7.84%):迭代
     * @param head
     * @return
     */
    private static ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        queue.push(head.val);
        while (head.next != null){
            queue.push(head.next.val);
            head = head.next;
        }
        ListNode node = new ListNode(queue.poll());
        ListNode tmp = node;
        while (!queue.isEmpty()){
            tmp.next = new ListNode(queue.poll());
            tmp = tmp.next;
        }
        return node;
    }

    /**
     * leetcode : 递归
     * @param head
     * @return
     */
    private static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    /**
     * leetcode : 迭代
     * @param head
     * @return
     */
    private static  ListNode reverseList3(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }


    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        reverseList3(root);
    }
}
