package simple;

import javafx.util.Pair;

import java.util.LinkedList;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 * All rights Reserved, Designed By yyh
 * 二叉树最小深度
 * @Package simple
 * @author: yyh
 * @date: 2019-09-19 15:36
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_111 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    /**
     * leetcode：递归
     * 最直接的思路就是递归。
     * 我们用深度优先搜索来解决这个问题
     * 时间复杂度：我们访问每个节点一次，时间复杂度为 O(N) ，其中 N 是节点个数。
     * 空间复杂度：最坏情况下，整棵树是非平衡的，例如每个节点都只有一个孩子，递归会调用 N （树的高度）次，因此栈的空间开销是 O(N) 。
     * 但在最好情况下，树是完全平衡的，高度只有 log(N)，因此在这种情况下空间复杂度只有 O(log(N)) 。
     *
     * @param root
     * @return
     */
    private static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if ((root.left == null) && (root.right == null)) {
            return 1;
        }
        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }
        return min_depth + 1;
    }

    /**
     * leetcode：深度优先搜索迭代
     * 我们可以利用栈将上述解法中的递归变成迭代。
     * 想法是对于每个节点，按照深度优先搜索的策略访问，同时在访问到叶子节点时更新最小深度。
     * 我们从一个包含根节点的栈开始，当前深度为 1 。
     * 然后开始迭代：弹出当前栈顶元素，将它的孩子节点压入栈中。当遇到叶子节点时更新最小深度。
     * 时间复杂度：每个节点恰好被访问一遍，复杂度为 O(N)。
     * 空间复杂度：最坏情况下我们会在栈中保存整棵树，此时空间复杂度为 O(N)。
     * @param root
     * @return
     */
    private static int minDepth2(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        else {
            stack.add(new Pair(root, 1));
        }
        int min_depth = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.pollLast();
            root = current.getKey();
            int current_depth = current.getValue();
            if ((root.left == null) && (root.right == null)) {
                min_depth = Math.min(min_depth, current_depth);
            }
            if (root.left != null) {
                stack.add(new Pair(root.left, current_depth + 1));
            }
            if (root.right != null) {
                stack.add(new Pair(root.right, current_depth + 1));
            }
        }
        return min_depth;
    }

    /**
     * leetcode:宽度优先搜索迭代
     * 深度优先搜索方法的缺陷是所有节点都必须访问到，以保证能够找到最小深度。因此复杂度是 O(N)。
     * 一个优化的方法是利用宽度优先搜索，我们按照树的层次去迭代，第一个访问到的叶子就是最小深度的节点，
     * 这样就不要遍历所有的节点了。
     * 时间复杂度：最坏情况下，这是一棵平衡树，我们需要按照树的层次一层一层的访问完所有节点，除去最后一层的节点。
     * 这样访问了N/2 个节点，因此复杂度是O(N)。
     * 空间复杂度：和时间复杂度相同，也是O(N)
     *
     * @param root
     * @return
     */
    private static int minDepth3(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        else {
            stack.add(new Pair(root, 1));
        }

        int current_depth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.poll();
            root = current.getKey();
            current_depth = current.getValue();
            if ((root.left == null) && (root.right == null)) {
                break;
            }
            if (root.left != null) {
                stack.add(new Pair(root.left, current_depth + 1));
            }
            if (root.right != null) {
                stack.add(new Pair(root.right, current_depth + 1));
            }
        }
        return current_depth;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        System.out.println(minDepth(node));
    }
}
