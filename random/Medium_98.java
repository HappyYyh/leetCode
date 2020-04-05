package random;


import exercise.tree.Medium_94;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 *
 * 示例 2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * @ClassName: Medium_98
 * @description: 验证二叉搜索树
 * @author: yyh
 * @create: 2020-01-05 12:00
 **/
public class Medium_98 {

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }

    /**
     * leetcode : 递归
     * @param root
     * @return
     */
    private static boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private static boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }
        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper){
            return false;
        }
        if (! helper(node.right, val, upper)) {
            return false;
        }
        return helper(node.left, lower, val);
    }


    private static LinkedList<TreeNode> stack = new LinkedList<>();
    private static LinkedList<Integer> uppers = new LinkedList<>();
    private static LinkedList<Integer> lowers = new LinkedList<>();

    private static void update(TreeNode root, Integer lower, Integer upper) {
        stack.add(root);
        lowers.add(lower);
        uppers.add(upper);
    }

    /**
     * leetcode : 迭代，DFS
     * @param root
     * @return
     */
    private static boolean isValidBST2(TreeNode root) {
        Integer lower = null, upper = null, val;
        update(root, lower, upper);
        while (!stack.isEmpty()) {
            root = stack.poll();
            lower = lowers.poll();
            upper = uppers.poll();
            if (root == null) continue;
            val = root.val;
            if (lower != null && val <= lower) return false;
            if (upper != null && val >= upper) return false;
            update(root.right, val, upper);
            update(root.left, lower, val);
        }
        return true;
    }

    /**
     * my result : 利用BST中序遍历是有序的特点，进行中序遍历，然后判断List是否升序
     * @param root
     * @return
     */
    private static boolean isValidBST3(TreeNode root) {
        if(root == null){
            return true;
        }
        List<Integer> result = new ArrayList<>();
        inorder(root,result);
        for (int i = 0; i < result.size() - 1 ; i++) {
            if(result.get(i) >= result.get(i+1) ){
                return false;
            }
        }
        return true;
    }

    private static void inorder(TreeNode root, List<Integer> list){
        if(root.left != null){
            inorder(root.left,list);
        }
        list.add(root.val);
        if(root.right != null){
            inorder(root.right,list);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        System.out.println(isValidBST2(root));
    }
}
