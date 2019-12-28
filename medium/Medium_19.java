package medium;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 *
 * @ClassName: Medium_19
 * @description: 删除链表的倒数第N个节点
 * @author: yyh
 * @create: 2019-12-28 12:08
 **/
public class Medium_19 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * my result: 两次迭代，第一次找出链表的深度，第二次找出要删除的节点
     * @param head
     * @param n
     * @return
     */
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        int depth = getDepth(head);
        if(depth == 0){
            return null;
        }
        if(depth == n){
            return head.next;
        }
        int index = 1;
        ListNode tmp = head;
        while (tmp.next != null){
            //删除的节点的前一个结点所在的索引
            if(index == depth - n){
                tmp.next = tmp.next.next;
                break;
            }
            tmp = tmp.next;
            index++;
        }
        return head;
    }

    /**
     * 获取链表的深度
     * @param head
     * @return
     */
    private static int getDepth(ListNode head){
        if(head == null){
            return 0;
        }
        int depth = 1;
        ListNode tmp = head;
        while (tmp.next != null){
            depth++;
            tmp = tmp.next;
        }
        return depth;
    }

    /**
     * leetcode：一次遍历
     * 述算法可以优化为只使用一次遍历。
     * 我们可以使用两个指针而不是一个指针。
     * 第一个指针从列表的开头向前移动 n+1n+1 步，而第二个指针将从列表的开头出发。
     * 现在，这两个指针被 nn 个结点分开。
     * 我们通过同时移动两个指针向前来保持这个恒定的间隔，直到第一个指针到达最后一个结点。
     * 此时第二个指针将指向从最后一个结点数起的第 n 个结点。
     * 我们重新链接第二个指针所引用的结点的 next 指针指向该结点的下下个结点。
     *
     * @param head
     * @param n
     * @return
     */
    private static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
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
        removeNthFromEnd2(head,2);
    }
}
