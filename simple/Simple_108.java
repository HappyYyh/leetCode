package simple;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * All rights Reserved, Designed By yyh
 * 将有序数组转换为二叉搜索树
 * @Package simple
 * @author: yyh
 * @date: 2019-09-16 14:20
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_108 {

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }

    /**
     * 二叉搜索树 :题目给出的升序数组就是二叉搜索树的中序遍历。
     *
     * 首先需要知道二叉搜索树是一种用于快速搜索的数据结构，
     * 定义为：左孩子上所有节点均小于右孩子上的（使用中序遍历出来的序列一定有序）。
     * 对于平衡二叉搜索树，是在二叉搜索树的一种改进，是为了防止我们查找次数过多
     * （节点两边不平衡，一边过少，导致树很高，但节点不多，有很多空指针），所有我们要限制树，
     * 使其能更加紧凑，每个节点左右两边节点数目差不多（严格定义是左右相差不能超过1）。
     * 这个时候我们对有序数组采取二分搜索的方式就可以最方便的得到满足题的树。
     *
     * @param nums
     * @return
     */
    private static TreeNode sortedArrayToBST(int[] nums) {
        return toBST(nums, 0, nums.length);
    }

    private static TreeNode toBST(int[] nums, int start, int end) {
        if (start == end) {
            return null;
        }
        int mid = (start + end) >>> 1;
        TreeNode root = new TreeNode(nums[mid]);
        //递归构建
        root.left = toBST(nums, start, mid);
        root.right = toBST(nums, mid + 1, end);
        return root;
    }


    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9,10};
        TreeNode treeNode = sortedArrayToBST(nums);
    }
}
