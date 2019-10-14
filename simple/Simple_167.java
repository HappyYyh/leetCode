package simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * All rights Reserved, Designed By yyh
 * 两数之和 II - 输入有序数组
 * @Package simple
 * @author: yyh
 * @date: 2019-10-14 13:59
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_167 {

    /**
     * 双指针
     * @param numbers
     * @param target
     * @return
     */
    private static int[] twoSum2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        throw new RuntimeException("No two sum solution");
    }
	
	/**
     * 双指针 for循环写法
     * @param numbers
     * @param target
     * @return
     */
    private static int[] twoSum3(int[] numbers, int target) {
        int right = numbers.length - 1;
        for (int i = 0; i < numbers.length;) {
            int sum = numbers[i] + numbers[right];
            if(sum == target){
                return new int[]{i+1,right+1};
            }else if(sum > target){
                right --;
            }else {
                i++;
            }
        }
        throw new RuntimeException("No two sum solution");
    }

    /**
     * 这题和Simple1一模一样，除了返回的下标＋1
     * @param numbers
     * @param target
     * @return
     */
    private static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i+1 };
            }
            map.put(numbers[i], i+1);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum2(new int[]{2, 7, 11, 15}, 9)));
    }
}
