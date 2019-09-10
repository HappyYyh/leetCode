package simple;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 说明:
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 *
 * All rights Reserved, Designed By yyh
 * 对称二叉树
 * @Package simple
 * @author: yyh
 * @date: 2019-09-10 14:45
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_101 {

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }

    /**
     * my result（一次通过）：时间复杂度O(n),空间复杂度O(n)
     * @param root
     * @return
     */
    private static boolean isSymmetric(TreeNode root) {
        if(null == root){
            return true;
        }
        return compare(root.left,root.right);
    }

    /**
     * 递归比较
     * @param left
     * @param right
     * @return
     */
    private static boolean compare(TreeNode left,TreeNode right){
        //两个同时为null，认为是相同的
        if(left == null || right == null){
            return left == null && right == null;
        }
        //左右值不一样则返回false
        if(left.val != right.val){
            return false;
        }
        //递归，让两棵树对称比较
        return compare(left.left,right.right) && compare(left.right,right.left);
    }

    /**
     * leetcode :从根节点开始递归
     * @param root
     * @return
     */
    private static boolean isSymmetric2(TreeNode root) {
        return isMirror(root, root);
    }

    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }

    /**
     * leetcode :迭代
     * 队列中每两个连续的结点应该是相等的，而且它们的子树互为镜像。
     * 最初，队列中包含的是 root 以及 root。该算法的工作原理类似于 BFS，但存在一些关键差异。
     * 每次提取两个结点并比较它们的值。然后，将两个结点的左右子结点按相反的顺序插入队列中。
     * 当队列为空时，或者我们检测到树不对称（即从队列中取出两个不相等的连续结点）时，该算法结束。
     *
     * @param root
     * @return
     */
    private static boolean isSymmetric3(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            //获取队列首个元素
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }



    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(3);
        System.out.println(isSymmetric(node));
    }
}
