package simple;

import java.util.Arrays;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 *
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 示例 2:
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 *
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * 12345
 * 51234
 * All rights Reserved, Designed By yyh
 * 旋转数组
 * @Package simple
 * @author: yyh
 * @date: 2019-10-21 13:47
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_189 {

    /**
     * my result:循环k次，每一次进行一次数组移动 空间复杂度O(n*k)，空间复杂度O(1)
     * @param nums
     * @param k
     */
    private static void rotate(int[] nums, int k) {
        while (k > 0){
            int tmp = nums[nums.length-1];
            for (int i = nums.length-1; i > 0  ; i--) {
                nums[i] = nums[i-1];
            }
            nums[0] = tmp;
            k--;
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * my result:利用辅助空间计算出每一个元素的位置，时间复杂度O(n),空间复杂度O(n)。不满足题目的空间复杂度要求
     * @param nums
     * @param k
     */
    private static void rotate2(int[] nums, int k) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length ; i++) {
            int position = (i + k)% nums.length;
            res[position] = nums[i];
        }
        System.arraycopy(res, 0, nums, 0, nums.length);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * leetcode : 使用环形替换
     * 时间复杂度：O(n) 。 只遍历了每个元素一次。
     * 空间复杂度：O(1) 。 没有使用额外的空间。
     * @param nums
     * @param k
     */
    private static void rotate3(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * leetcode:使用反转
     * 这个方法基于这个事实：当我们旋转数组 k 次， k\%nk%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。
     * 在这个方法中，我们首先将所有元素反转。然后反转前 k 个元素，再反转后面 n-kn−k 个元素，就能得到想要的结果。
     * 时间复杂度：O(n) 。 n 个元素被反转了总共 3 次。
     * 空间复杂度：O(1) 。 没有使用额外的空间。
     *
     * @param nums
     * @param k
     */
    private static void rotate4(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }



    public static void main(String[] args) {
        rotate4(new int[]{1,2,3,4,5,6,7},3);
    }
}
