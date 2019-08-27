package simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * All rights Reserved, Designed By yyh
 * 合并两个有序链表
 * @Package simple
 * @author: yyh
 * @date: 2019-08-27 10:11
 * @since V1.1.0-SNAPSHOT
 */
public class Simple_21 {
    /**
     * 存放节点的值
     */
    private List<Integer> nodeValue = new ArrayList<>();

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    /**
     * my Result :先把节点的值存放起来，之后排序，最后创建节点
     * @param l1
     * @param l2
     * @return
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNodeToArr(l1);
        ListNodeToArr(l2);
        Collections.sort(this.nodeValue);
        return createListNodeByList(nodeValue);
    }

    /**
     * 我们直接将以上递归过程建模，首先考虑边界情况。
     * 特殊的，如果 l1 或者 l2 一开始就是 null ，那么没有任何操作需要合并，
     * 所以我们只需要返回非空链表。否则，我们要判断 l1 和 l2 哪一个的头元素更小，
     * 然后递归地决定下一个添加到结果里的值。如果两个链表都是空的，那么过程终止，所以递归过程最终一定会终止。
     *
     * leetCode：递归调用
     * @param l1
     * @param l2
     * @return
     */
    private ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }


    /**
     * 把listNode的值放入list中
     * @param listNode
     */
    private void ListNodeToArr(ListNode listNode){
        if(listNode != null) {
            int first = listNode.val;
            this.nodeValue.add(first);
            if (listNode.next != null) {
                ListNodeToArr(listNode.next);
            }
        }
    }

    /**
     * 根据list创建节点
     * @param list
     * @return
     */
    private ListNode createListNodeByList(List<Integer> list){
        if(list.size() == 0){
            return null;
        }
        //创建nodeList
        List<ListNode> nodeList = new ArrayList<>();
        for (Integer integer : list) {
            ListNode now = new ListNode(integer);
            nodeList.add(now);
        }
        //将当前节点指向下一个节点
        for (int i = 0 ;i <nodeList.size() ; i++ ){
            if(i < nodeList.size() -1) {
                nodeList.get(i).next = nodeList.get(i + 1);
            }
        }
        return nodeList.get(0);
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(4);
        ListNode second = new ListNode(1);
        second.next = new ListNode(3);
        second.next.next = new ListNode(4);
        System.out.println(new Simple_21().mergeTwoLists2(first,second));

    }
}
