package medium;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * <p>
 * All rights Reserved, Designed By yyh
 * 最接近的三数之和
 *
 * @Package medium
 * @author: yyh
 * @date: 2019-10-23 14:34
 * @since V1.0.0-SNAPSHOT
 */
public class Medium_16 {

    /**
     * my result:暴力破解，列举出所有可能 时间复杂度O(n^3)，空间复杂度O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    private static int threeSumClosest(int[] nums, int target) {
        int mix = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    System.out.println("sum is" + sum);
                    if (Math.abs(sum - target) < mix) {
                        res = sum;
                        mix = Math.abs(sum - target);
                    }
                }
            }
        }
        return res;
    }

    /**
     * 双指针：差一点点完成，多思考一段时间就好了，哎
     * @param nums
     * @param target
     * @return
     */
    private static int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest2(new int[]{1, 2, 5, 10, 11}, 12));
    }
}
