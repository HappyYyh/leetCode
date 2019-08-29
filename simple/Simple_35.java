package simple;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，
 * 返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 *
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * All rights Reserved, Designed By yyh
 * 搜索插入位置
 * @Package simple
 * @author: yyh
 * @date: 2019-08-29 14:54
 * @since V1.1.0-SNAPSHOT
 */
public class Simple_35 {

    /**
     * my result: 直接查找，虽然执行都是1ms，但是意义不大，时间复杂度O(n)。
     * @param nums
     * @param target
     * @return
     */
    private int searchInsert(int[] nums, int target) {
        int len  = nums.length;
        if(len == 0 ){
            return 0;
        }
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] >= target){
                return i;
            }
        }
        return len;
    }

    /**
     * 二分查找,时间复杂度O(logN)
     * 整体思路和普通的二分查找几乎没有区别，先设定左侧下标 left 和右侧下标 right，再计算中间下标 mid
     * 每次根据 nums[mid] 和 target 之间的大小进行判断，相等则直接返回下标，nums[mid] < target 则 left 右移，nums[mid] > target 则 right 左移
     * 查找结束如果没有相等值则返回 left，该值为插入位置
     *
     * @param nums
     * @param target
     * @return
     */
    private int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1 ;
        while (left <= right){
            int mid = (left + right) /2 ;
            if(target == nums[mid]){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid -1 ;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        Simple_35 test = new Simple_35();
        System.out.println(test.searchInsert2(nums,5));
        System.out.println(test.searchInsert2(nums,2));
        System.out.println(test.searchInsert2(nums,7));
        System.out.println(test.searchInsert2(nums,0));
    }
}
