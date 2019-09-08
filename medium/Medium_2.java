package medium;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @ClassName: Medium_2
 * @description: 两数相加
 * @author: yyh
 * @create: 2019-09-08 10:00
 **/
public class Medium_2 {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    /**
     * my result1: 把链表转成long类型，然后相加 ，然后在转链表，结果造成位数不够（溢出），所以方法行不通
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(null == l1 || (l1.next == null && l1.val == 0)){
            return l2;
        }
        if(null == l2 || (l2.next == null && l2.val == 0)){
            return l1;
        }
        //计算两数之和
        long sum = listNodeToInt(l1) + listNodeToInt(l2);
        char[] chars = new StringBuilder(String.valueOf(sum)).reverse().toString().toCharArray();
        //根据结果构造listNode
        ListNode result = new ListNode(chars[0]-'0');
        ListNode tmp = result;
        for (int i = 1; i <chars.length ; i++) {
            tmp.next = new ListNode(chars[i]-'0');
            tmp = tmp.next;
        }
        return result;
    }

    private static long listNodeToInt(ListNode node){
        StringBuilder sb  = new StringBuilder(String.valueOf(node.val));
        while (node.next != null){
            sb.append(node.next.val);
            node = node.next;
        }
        return Long.parseLong(sb.reverse().toString());
    }

    /**
     * my result2:同时遍历了l1和l2，把相同位相加，构建一个result，最后针对result里面大于10的部分，做取余操作，并且后一位++
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if(null == l1 || (l1.next == null && l1.val == 0)){
            return l2;
        }
        if(null == l2 || (l2.next == null && l2.val == 0)){
            return l1;
        }
        ListNode result = new ListNode(l1.val + l2.val);
        ListNode tmp = result;
        while (l1.next != null || l2.next != null){
            //如果有一个到底，另一个没有到底，则只添加另一个
            if(l1.next == null){
                tmp.next = new ListNode(l2.next.val);
                tmp = tmp.next;
                l2 = l2.next;
                continue;
            }
            if(l2.next == null){
                tmp.next = new ListNode(l1.next.val);
                tmp = tmp.next;
                l1 = l1.next;
                continue;
            }
            //同时next不为null，则相加
            tmp.next = new ListNode(l1.next.val + l2.next.val);
            tmp = tmp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode tmp2 = result;
        //处理除了最后一个 ，大于10的情况
        while (tmp2.next != null){
            if(tmp2.val >= 10){
                tmp2.val %= 10;
                tmp2.next.val++;
            }
            tmp2 = tmp2.next;
        }
        //判断最后一位
        if(tmp2.val >= 10){
            tmp2.val %= 10;
            tmp2.next = new ListNode(1);
        }
        return result;
    }

    /**
     * leetCode：思路和我的差不多，都是逐位相加，但是他优化的点在于加了一个carry表示进位，
     *           就是在while循环里判断进位，不用在循环结束后再用循环判断每一位是否需要进位
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        //最后一位
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        System.out.println(addTwoNumbers2(l1,l2));
    }
}
