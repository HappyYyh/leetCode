package exercise.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * All rights Reserved, Designed By yyh
 * 二叉树的所有路径
 * @Package exercise.tree
 * @author: yyh
 * @date: 2019-12-16 13:25
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_257 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * my result (time over 100%) : 递归
     * @param root
     * @return
     */
    private static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        getPath(root, "", res);
        return res;
    }

    /**
     * 获取路径
     * @param root 当前节点
     * @param path 已经存在的路径
     * @param list 存放结果的list
     */
    private static void getPath(TreeNode root, String path, List<String> list) {
        StringBuilder tmp = new StringBuilder(path);
        tmp.append(root.val).append("->");
        if (root.left != null) {
            getPath(root.left, tmp.toString(), list);
        }
        if (root.right != null) {
            getPath(root.right, tmp.toString(), list);
        }
        if (root.right == null && root.left == null) {
            // 当左右都为空时代表是叶子节点，所以放入结果
            list.add(tmp.delete(tmp.length() - 2, tmp.length()).toString());
        }
    }

    /**
     * leetcode : 递归
     * @param root
     * @param path
     * @param paths
     */
    private static void constructPaths(TreeNode root, String path, LinkedList<String> paths) {
        if (root != null) {
            path += Integer.toString(root.val);
            if ((root.left == null) && (root.right == null)) {
                // 当前节点是叶子节点
                // 把路径加入到答案中
                paths.add(path);
            } else {
                // 当前节点不是叶子节点，继续递归遍历
                path += "->";
                constructPaths(root.left, path, paths);
                constructPaths(root.right, path, paths);
            }
        }
    }




    /**
     * leetcode : 迭代
     * @param root
     * @return
     */
    private static List<String> binaryTreePaths2(TreeNode root) {
        LinkedList<String> paths = new LinkedList<>();
        if (root == null) {
            return paths;
        }
        LinkedList<TreeNode> nodeStack = new LinkedList<>();
        LinkedList<String> pathStack = new LinkedList<>();
        nodeStack.add(root);
        pathStack.add(Integer.toString(root.val));
        TreeNode node;
        String path;
        while (!nodeStack.isEmpty()) {
            node = nodeStack.pollLast();
            path = pathStack.pollLast();
            if ((node.left == null) && (node.right == null)) {
                paths.add(path);
            }
            if (node.left != null) {
                nodeStack.add(node.left);
                pathStack.add(path + "->" + node.left.val);
            }
            if (node.right != null) {
                nodeStack.add(node.right);
                pathStack.add(path + "->" + node.right.val);
            }
        }
        return paths;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        System.out.println(binaryTreePaths(null));
    }


}
