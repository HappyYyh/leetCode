package exercise.tree;

import java.util.*;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * All rights Reserved, Designed By yyh
 * 二叉树的中序遍历
 * @Package exercise.tree
 * @author: yyh
 * @date: 2019-12-18 13:29
 * @since V1.0.0-SNAPSHOT
 */
public class Medium_94 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * my result(once pass,time over 100%):递归，中序遍历
     * @param root
     * @return
     */
    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        inorder(root,result);
        return result;
    }

    /**
     * 中序遍历
     * @param root
     * @param list
     */
    private static void inorder(TreeNode root,List<Integer> list){
        if(root.left != null){
            inorder(root.left,list);
        }
        list.add(root.val);
        if(root.right != null){
            inorder(root.right,list);
        }
    }

    /**
     * leetcode ： 迭代
     * @param root
     * @return
     */
    private static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.left = node2;
        System.out.println(inorderTraversal2(root));
    }
}
