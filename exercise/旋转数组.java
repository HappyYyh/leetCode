package com.example.demo.arr;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 你可以假设数组中不存在重复元素。
 * <p>
 * 示例 1:
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * <p>
 * 示例 2:
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 * <p>
 * All rights Reserved, Designed By yyh
 *
 * @Package com.example.demo.arr
 * @author: yyh
 * @date: 2020-03-31 16:57
 * @since V1.0.0-SNAPSHOT
 */
public class Test2 {

    private static int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        if (nums[right] > nums[left]) {
            return nums[0];
        }
        // Binary search way
        while (right >= left) {
            // Find the mid element
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{7,2,3,4,5}));
    }
}
