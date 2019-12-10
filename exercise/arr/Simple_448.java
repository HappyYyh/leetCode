package exercise.arr;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * 输出:
 * [5,6]
 *
 * All rights Reserved, Designed By yyh
 * 找到所有数组中消失的数字
 * @Package exercise.arr
 * @author: yyh
 * @date: 2019-12-10 13:45
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_448 {

    /**
     * my result :遍历
     * @param nums
     * @return
     */
    private static List<Integer> findDisappearedNumbers(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int val : nums){
            set.add(val);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length ; i++) {
            if(!set.contains(i + 1)){
                res.add(i+1);
            }
        }
        return res;
    }

    /**
     * other
     * @param nums
     * @return
     */
    private static List<Integer> findDisappearedNumbers2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }

    /**
     * 位运算交换两个值，不用额外空间
     * @param nums
     * @param index1
     * @param index2
     */
    private static void swap(int[] nums, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        nums[index1] = nums[index1] ^ nums[index2];
        nums[index2] = nums[index1] ^ nums[index2];
        nums[index1] = nums[index1] ^ nums[index2];
    }


    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        int[] nums2 = {13,8,5,3,20,12,3,20,5,16,9,19,12,11,13,19,11,1,10,2};
        System.out.println(findDisappearedNumbers(nums));
        System.out.println(findDisappearedNumbers2(nums2));
    }
}
