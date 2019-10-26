package simple;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * @ClassName: Simple_203
 * @description: 移除链表元素
 * @author: yyh
 * @create: 2019-10-26 11:37
 **/
public class Simple_203 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * other：除头结点时另做考虑（由于头结点没有前一个结点）
     * @param head
     * @param val
     * @return
     */
    private static ListNode removeElements(ListNode head, int val) {
        //删除值相同的头结点后，可能新的头结点也值相等，用循环解决
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return head;
        }
        ListNode prev = head;
        //确保当前结点后还有结点
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    /**
     * other：添加一个虚拟头结点，删除头结点就不用另做考虑
     * @param head
     * @param val
     * @return
     */
    private static ListNode removeElements2(ListNode head, int val) {
        //创建一个虚拟头结点
        ListNode dummyNode = new ListNode(val - 1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        //确保当前结点后还有结点
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyNode.next;
    }

    /**
     * other：递归
     * @param head
     * @param val
     * @return
     */
    private static ListNode removeElements3(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements3(head.next, val);
        if (head.val == val) {
            return head.next;
        } else {
            return head;
        }
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        removeElements3(head, 6);
    }
}
