package exercise.recursion;

/**
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 * 示例 1:
 * 输入:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * 输出:
 * 2
 *
 * 示例 2:
 * 输入:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * 输出:
 * 2
 *
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 *
 * @ClassName: Simple_687
 * @description: 最长同值路径
 * @author: yyh
 * @create: 2019-11-30 18:21
 **/
public class Simple_687 {

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }

    private static int ans;

    /**
     * leetcode
     * @param root
     * @return
     */
    private static int longestUnivaluePath(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }

    private static int arrowLength(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = arrowLength(node.left);
        int right = arrowLength(node.right);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(4);
        node.right = new TreeNode(5);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(4);
        node.right.right = new TreeNode(5);
        System.out.println(longestUnivaluePath(node));
    }
}
