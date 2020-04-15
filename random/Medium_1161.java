package random;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 * 请你找出层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 *
 * 示例：
 *      1
 *     / \
 *    7   0
 *   / \
 *  7  -8
 * 输入：[1,7,0,7,-8,null,null]
 * 输出：2
 * 解释：
 * 第 1 层各元素之和为 1，
 * 第 2 层各元素之和为 7 + 0 = 7，
 * 第 3 层各元素之和为 7 + -8 = -1，
 * 所以我们返回第 2 层的层号，它的层内元素之和最大。
 *
 * 提示：
 * 树中的节点数介于 1 和 10^4 之间
 * -10^5 <= node.val <= 10^5
 *
 * @ClassName: Medium_1161
 * @description: 最大层内元素和
 * @author: yyh
 * @create: 2020-04-15 12:58
 **/
public class Medium_1161 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
     }

    /**
     * my result (time pass 27.89%):先利用DFS把每层的数字放入list中，之后进行比较，找出层数
     * 时间复杂度：DFS复杂度为O(logN),遍历list为O(n^2),这两个n不同
     * @param root
     * @return
     */
    private static int maxLevelSum(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        DFS(lists,0,root);
        if(lists.size() == 0){
            return 0;
        }
        int level = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < lists.size() ; i++) {
            List<Integer> list = lists.get(i);
            int sum = 0;
            for (int val : list){
                sum += val;
            }
            if(sum > max){
                max = sum;
                level = i;
            }
        }
        return level + 1;
    }

    private static void DFS(List<List<Integer>> lists,int level,TreeNode root){
        if(root == null){
            return;
        }
        if(level >= lists.size()){
            lists.add(new ArrayList<>());
        }
        List<Integer> list = lists.get(level);
        list.add(root.val);
        DFS(lists,level + 1,root.left);
        DFS(lists,level + 1,root.right);
    }

    private static int n = 10000;
    private static int[] levelSum = new int[n];

    private static void inorder(TreeNode node, int level) {
        if (node != null) {
            inorder(node.left, level + 1);
            levelSum[level] += node.val;
            inorder(node.right, level + 1);
        }
    }

    /**
     * leetcode: DFS,中序遍历，然后利用数组保存层次之和
     * 时间复杂度：O(N)，中序遍历每个节点只访问一次，然后遍历 level_sum。
     * 空间复杂度：O(10000)
     * @param root
     * @return
     */
    private static int maxLevelSum2(TreeNode root) {
        inorder(root, 1);
        int maxIdx = 0;
        for (int i = 0; i < n; ++i) {
            maxIdx = levelSum[i] > levelSum[maxIdx] ? i : maxIdx;
        }
        return maxIdx;
    }

    /**
     * leetcode:BFS
     * @param root
     * @return
     */
    private static int maxLevelSum3(TreeNode root) {
        int currLevel = 1, maxLevel = 1;
        int maxSum = root.val, currSum = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode marker = null, x = root;
        queue.addLast(root);
        queue.addLast(marker);
        while (queue.size() > 1) {
            x = queue.removeFirst();
            // continue current level
            if (x != marker) {
                currSum += x.val;
                if (x.left != null) {
                    queue.addLast(x.left);
                }
                if (x.right != null) {
                    queue.addLast(x.right);
                }
            }
            // end of current level, go to the next level
            else {
                if (currSum > maxSum) {
                    maxSum = currSum;
                    maxLevel = currLevel;
                }
                currSum = 0;
                currLevel++;
                queue.addLast(marker);
            }
        }
        return maxLevel;
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(-8);
        node1.left = node2;
        node2.left = node4;
        node2.right = node5;
        node1.right = node3;
        System.out.println(maxLevelSum3(node1));
    }
}
