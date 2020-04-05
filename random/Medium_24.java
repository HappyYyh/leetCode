package random;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.

 *
 * All rights Reserved, Designed By yyh
 * 两两交换链表中的节点
 * @Package medium
 * @author: yyh
 * @date: 2020-01-02 14:03
 * @since V1.0.0-SNAPSHOT
 */
public class Medium_24 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * my result(once pass,time over 100%): 先把值放入list中，然后两两交换，然后构建链表
     * 时间复杂度：O(n)
     * @param head
     * @return
     */
    private static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        // 把节点放入到list中
        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        int tmp;
        // 两两交换
        int len = list.size() % 2 == 0 ? list.size() : list.size() - 1;
        for (int i = 0; i < len ; i += 2) {
            tmp = list.get(i);
            list.set(i,list.get(i+1));
            list.set(i+1,tmp);
        }
        // 构建listNode
        ListNode result = new ListNode(0);
        ListNode tmpNode = result;
        for (int val : list){
            tmpNode.next = new ListNode(val);
            tmpNode = tmpNode.next;
        }
        return result.next;
    }

    /**
     * other:递归
     * @param head
     * @return
     */
    private static ListNode swapPairs2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs2(next.next);
        next.next = head;
        return next;
    }

    /**
     * other:非递归
     * @param head
     * @return
     */
    private static ListNode swapPairs3(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while(temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        swapPairs2(head);
    }
}
