package exercise.doublepoint;

import java.util.Arrays;
import java.util.Map;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * All rights Reserved, Designed By yyh
 * 移动零
 * @Package exercise.str
 * @author: yyh
 * @date: 2019-11-11 12:16
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_283 {

    /**
     * my result (once pass):直接冒泡
     * 时间复杂度 ： O(n^2)
     * 空间复杂度 ： O(1)
     * @param nums
     */
    private static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i + 1; j < nums.length ; j++) {
                if(nums[i] == 0){
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
            }
        }
    }

    /**
     * other: 维护一个变量，用来判断非0数需要移动几位
     * @param nums
     */
    private static void moveZeroes2(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                count++;
            }else {
                nums[i - count] = nums[i];
            }
        }
        for(int i = nums.length - count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        System.out.println("原始的数组： "+ Arrays.toString(arr));
        moveZeroes(arr);
        System.out.println("移动后的的数组： "+ Arrays.toString(arr));
    }
}
