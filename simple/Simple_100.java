package simple;



/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 * 输出: true
 *
 * 示例 2:
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 * 输出: false
 *
 * 示例 3:
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 * 输出: false
 *
 * All rights Reserved, Designed By yyh
 * 相同的树
 * @Package simple
 * @author: yyh
 * @date: 2019-09-09 15:37
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_100 {

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }

    /**
     * my result:把treeNode转为string再比较
     * @param p
     * @param q
     * @return
     */
    private static boolean isSameTree(TreeNode p, TreeNode q) {
        //同时为null返回true，其他返回false
        if(null == p || null == q){
            return null == p && null == q;
        }
        return treeNodeToString(p).equals(treeNodeToString(q));
    }

    private static String treeNodeToString(TreeNode node){
        StringBuilder sb = new StringBuilder(String.valueOf(node.val));
        append(sb,node);
        return sb.toString();
    }

    /**
     * 递归添加
     * @param sb
     * @param node
     */
    private static void append(StringBuilder sb , TreeNode node){
        TreeNode left = node.left;
        TreeNode right = node.right;
        if(left != null){
            sb.append(left.val);
            append(sb,left);
        }else {
            sb.append("l");
        }
        if(right != null){
            sb.append(right.val);
            append(sb,right);
        }else {
            sb.append("r");
        }
    }

    /**
     * leetCode 递归
     * 复杂度分析
     * 时间复杂度 : O(N)，其中 N 是树的结点数，因为每个结点都访问一次。
     * 空间复杂度 : 最优情况（完全平衡二叉树）时为O(log(N))，
     *             最坏情况下（完全不平衡二叉树）时为O(N)，用于维护递归栈。
     *
     * @param p
     * @param q
     * @return
     */
    private static boolean isSameTree1(TreeNode p, TreeNode q) {
        // p and q are both null
        if (p == null && q == null) {
            return true;
        }
        // one of p and q is null
        if (q == null || p == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree1(p.right, q.right) &&
                isSameTree1(p.left, q.left);
    }


    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
//        p.left.left = new TreeNode(4);
//        p.left.right = new TreeNode(5);
//        p.right.left = new TreeNode(6);
//        p.right.right = new TreeNode(7);

        System.out.println("left:"+treeNodeToString(p));

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        System.out.println("right:"+treeNodeToString(q));

        System.out.println(isSameTree(p,q));
    }
}
