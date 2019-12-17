package exercise.tree;

/**
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * All rights Reserved, Designed By yyh
 * 左叶子之和
 * @Package exercise.tree
 * @author: yyh
 * @date: 2019-12-17 13:50
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_404 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * my result(time over 100%) : 递归
     * @param root
     * @return
     */
    private static int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        // 注意只有根节点也返回0
        return sum(root,false);
    }

    private static int sum(TreeNode root , boolean left){
        int sum = 0;
        //当只有左叶子节点才累加
        if(root.left == null && root.right == null && left){
            sum += root.val;
        }else {
            if(root.left != null) {
                sum += sum(root.left, true);
            }
            if(root.right != null) {
                sum += sum(root.right, false);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        System.out.println(sumOfLeftLeaves(root));
    }
}
