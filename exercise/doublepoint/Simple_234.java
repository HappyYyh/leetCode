package exercise.doublepoint;

import java.util.ArrayList;
import java.util.List;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 *
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 *
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * @ClassName: Simple_234
 * @description: 回文链表
 * @author: yyh
 * @create: 2019-11-09 10:53
 **/
public class Simple_234 {

    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    /**
     * my result : 把listNode链表的值放入List集合中，然后用双指针判断是否是回文
     * 时间复杂度：O(n)
     * @param head
     * @return
     */
    private static boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode tmp = head;
        List<Integer> list = new ArrayList<>();
        while (tmp.next != null){
            list.add(tmp.val);
            tmp = tmp.next;
        }
        list.add(tmp.val);
        //双指针
        int left = 0,right = list.size() -1 ;
        while (left < right){
            if(!list.get(left++).equals(list.get(right--))){
                return false;
            }
        }
        return true;
    }

    /**
     * other : 快慢指针
     * 用2个指针，一个low，一个fast，fast是low的2倍，所以可以达到2分链表的效果,
     * 在移动指针时同时对前半部分链表进行反转。最后直接比较被分开的2个链表
     * 因为不能改变当前slow的next，不然就无法跳到下一个元素，所以这里用pre和prepre实现指针的反转
     * 时间复杂度：第一个循环O(n/2)，第2个循环O(n/2)
     *
     * @param head
     * @return
     */
    private static boolean isPalindrome2(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head.next, pre = null, prepre = null;
        while(fast != null && fast.next != null) {
            //反转前半段链表
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            //先移动指针再来反转
            pre.next = prepre;
            prepre = pre;
        }
        ListNode p2 = slow.next;
        slow.next = pre;
        ListNode p1 = fast == null? slow.next : slow;
        while(p1 != null) {
            if(p1.val != p2.val){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(-2);
        head.next.next = new ListNode(-2);
        head.next.next.next = new ListNode(-1);
        System.out.println(isPalindrome2(head));
    }
}
