package simple;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * All rights Reserved, Designed By yyh
 * 二叉树的层次遍历二
 * @Package simple
 * @author: yyh
 * @date: 2019-09-12 16:26
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_107 {

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }

    /**
     * DFS
     * @param root
     * @return
     */
    private static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        DFS(root, 0, result);
        return result;
    }

    private static void DFS(TreeNode root, int level, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        // 当前层数还没有元素，先 new 一个空的列表
        if (ans.size() <= level) {
            ans.add(0, new ArrayList<>());
        }
        // 当前值加入
        ans.get(ans.size() - 1 - level).add(root.val);

        DFS(root.left, level + 1, ans);
        DFS(root.right, level + 1, ans);
    }

    /**
     * BFS
     * @param root
     * @return
     */
    private static List<List<Integer>> levelOrderBottom2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 当前层元素的个数
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode curNode = queue.poll();
                if (curNode != null) {
                    subList.add(curNode.val);
                    queue.offer(curNode.left);
                    queue.offer(curNode.right);
                }
            }
            if (subList.size() > 0) {
                ans.add(0, subList);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        System.out.println(levelOrderBottom(node));
    }
}
