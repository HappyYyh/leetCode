package simple;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 *
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * All rights Reserved, Designed By yyh
 * 删除排序链表中的重复元素
 * @Package simple
 * @author: yyh
 * @date: 2019-09-06 14:39
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_83 {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    /**
     * my result : 新创建一个node，指向第一个，循环head.next如果之后有重复的则不添加，让head指向后一个节点
     * @param head
     * @return
     */
    private static ListNode deleteDuplicates(ListNode head) {
        if(null == head){
            return null;
        }
        ListNode newNode = new ListNode(head.val);
        while (head.next != null){
            if(head.next.val != head.val) {
                //让一个tmp指向当前节点
                ListNode tmp = newNode;
                while (tmp.next != null){
                    tmp = tmp.next;
                }
                //tmp最后一个几点追加一个节点（注意，这里由于链表的作用，tmp追加了导致newNode也追加了）
                tmp.next = new ListNode(head.next.val);
            }
            head = head.next;
        }
        return newNode;
    }

    /**
     * 这是一个简单的问题，仅测试你操作列表的结点指针的能力。
     * 由于输入的列表已排序，因此我们可以通过将结点的值与它之后的结点进行比较来确定它是否为重复结点。
     * 如果它是重复的，我们更改当前结点的 next 指针，以便它跳过下一个结点并直接指向下一个结点之后的结点。
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates2(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
                //超长链表情况下，官方题解会产生大量野指针，这里要清除置空一下
                //ListNode node = current.next;
                //current.next = node.next;
                //node.next = null;
            } else {
                current = current.next;
            }
        }
        return head;
    }


    /**
     * 往最后面新增一个节点
     * @param head
     * @param val
     */
    private static void addListNode(ListNode head ,int val){
        ListNode node = new ListNode(val);
        ListNode tmp = head;
        while (tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = node;
        System.out.println(head);
    }

    public static void main(String[] args) {

        ListNode first = new ListNode(1);
        first.next = new ListNode(1);
        first.next.next = new ListNode(2);

        ListNode second = new ListNode(1);
        second.next = new ListNode(1);
        second.next.next = new ListNode(2);
        second.next.next.next = new ListNode(3);
        second.next.next.next.next = new ListNode(3);

        //addListNode(first,3);
        System.out.println(deleteDuplicates(null));
    }
}
