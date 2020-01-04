package medium;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 *
 * 示例 2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * @ClassName: Medium_33
 * @description: 搜索旋转排序数组
 * @author: yyh
 * @create: 2020-01-04 11:43
 **/
public class Medium_33 {

    /**
     * 线性查找：时间复杂度为O(n),不符合题意
     * @param nums
     * @param target
     * @return
     */
    private static int search(int[] nums, int target) {
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }

    int [] nums;
    int target;

    /**
     * 寻找旋转点
     * @param left
     * @param right
     * @return
     */
    public int find_rotate_index(int left, int right) {
        if (nums[left] < nums[right])
            return 0;
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] > nums[pivot + 1])
                return pivot + 1;
            else {
                if (nums[pivot] < nums[left])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return 0;
    }

    public int search(int left, int right) {
        /*
        Binary search
        */
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] == target)
                return pivot;
            else {
                if (target < nums[pivot])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return -1;
    }

    /**
     * leetcode : 二分查找
     * 先找到旋转点
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        int n = nums.length;

        if (n == 0)
            return -1;
        if (n == 1)
            return this.nums[0] == target ? 0 : -1;

        int rotate_index = find_rotate_index(0, n - 1);

        // if target is the smallest element
        if (nums[rotate_index] == target)
            return rotate_index;
        // if array is not rotated, search in the entire array
        if (rotate_index == 0)
            return search(0, n - 1);
        if (target < nums[0])
            // search in the right side
            return search(rotate_index, n - 1);
        // search in the left side
        return search(0, rotate_index);
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums,3));
        Medium_33 medium_33 = new Medium_33();
        System.out.println(medium_33.search2(nums,3));
    }
}
