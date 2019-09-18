package simple;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 * <p>
 * All rights Reserved, Designed By yyh
 * 平衡二叉树
 *
 * @Package simple
 * @author: yyh
 * @date: 2019-09-18 16:02
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_110 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    /**
     * 对二叉树做深度优先遍历DFS，递归过程中：
     * 终止条件：当DFS越过叶子节点时，返回高度0；
     * 返回值：
     * 从底至顶，返回以每个节点root为根节点的子树最大高度(左右子树中最大的高度值加1max(left,right) + 1)；
     * 当我们发现有一例 左/右子树高度差 ＞ 1 的情况时，代表此树不是平衡树，返回-1；
     * 当发现不是平衡树时，后面的高度计算都没有意义了，因此一路返回-1，避免后续多余计算。
     * 最差情况是对树做一遍完整DFS，时间复杂度为 O(N)。
     *
     * @param root
     * @return
     */
    private static boolean isBalanced(TreeNode root) {
        //-1 即为存在层数相差大于1
        return depth(root) != -1;
    }

    /**
     * 以当前节点为根节点的树的层数
     * 返回-1的话说明 不满足要求不用求了直接 -1 退出
     *
     * @param root
     * @return
     */
    private static int depth(TreeNode root) {
        //当前节点不存在其层数为0
        if (root == null) return 0;
        //获取左节点的层数
        int left = depth(root.left);
        //如果层数为-1直接截断
        if (left == -1) return -1;
        //获取右节点的层数
        int right = depth(root.right);
        //如果层数为-1直接退出
        if (right == -1) return -1;
        //如果左右节点层数相差大于1 直接返回-1 否则返回真实层数
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        System.out.println(isBalanced(node));
    }
}
