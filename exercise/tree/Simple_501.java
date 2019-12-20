package exercise.tree;

import java.util.*;

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 *
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 *
 * All rights Reserved, Designed By yyh
 * 二叉搜索树中的众数
 * @Package exercise.tree
 * @author: yyh
 * @date: 2019-12-20 13:41
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_501 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * my result (once pass ,time over 30.68%) ；中序遍历，把值放入map中，然后遍历map，得到众数
     * （完全没有用到BST中序遍历得到的是排序过的数组的优势，应该可以优化）
     * @param root
     * @return
     */
    private static int[] findMode(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        Map<Integer,Integer> map = new HashMap<>();
        infixOrder(root,map);
        List<Integer> modeList = new ArrayList<>();
        int count = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            // 如果比count大说明是新的众数
            if(entry.getValue() > count ){
                //list清空
                modeList.clear();
                modeList.add(entry.getKey());
                count = entry.getValue();
            }else if(entry.getValue() == count){
                modeList.add(entry.getKey());
            }
        }
        int[] res = new int[modeList.size()];
        for (int i = 0; i < modeList.size() ; i++) {
            res[i] = modeList.get(i);
        }
        return res;
    }

    private static void infixOrder(TreeNode root , Map<Integer,Integer> map){
        if(root.left != null){
            infixOrder(root.left,map);
        }
        map.put(root.val,map.getOrDefault(root.val,0) + 1);
        if(root.right != null){
            infixOrder(root.right,map);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        root.right = node1;
        node1.left = node2;
        System.out.println(Arrays.toString(findMode(root)));

    }
}
