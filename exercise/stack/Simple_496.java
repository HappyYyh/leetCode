package exercise.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 * 找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * <p>
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。
 * 如果不存在，对应位置输出-1。
 * <p>
 * 示例 1:
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 * 对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 * 对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 * 对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 * <p>
 * 示例 2:
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 *     对于num1中的数字2，第二个数组中的下一个较大数字是3。
 * 对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
 * 注意:
 * <p>
 * nums1和nums2中所有元素是唯一的。
 * nums1和nums2 的数组大小都不超过1000。
 * <p>
 * All rights Reserved, Designed By yyh
 * 下一个更大元素 I
 *
 * @Package exercise.stack
 * @author: yyh
 * @date: 2019-11-18 14:13
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_496 {

    /**
     * my result : 对数组进行遍历，但是并没有用到stack，不符合联系要求
     * 时间复杂度 ： O(2n^2 -> n^2)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int index = 0;
            int val = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    index = j;
                }
            }
            for (int j = index + 1; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    val = nums2[j];
                    break;
                }
            }
            res[i] = val;
        }
        return res;
    }

    /**
     * leet code : 单调栈，先不管nums1，遍历nums2，如果有大的，存入hash表，如果没有则压入栈
     * 时间复杂度：O(M+N)，其中 M 和 N 分别是数组 nums1 和 nums2 的长度。
     * 空间复杂度：O(N)。我们在遍历 nums2 时，需要使用栈，以及哈希映射用来临时存储答案。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    private static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        for (int value : nums2) {
            while (!stack.empty() && value > stack.peek()) {
                map.put(stack.pop(), value);
            }
            stack.push(value);
        }
        while (!stack.empty()){
            map.put(stack.pop(), -1);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement2(nums1, nums2)));
    }
}
