package simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 * <p>
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * <p>
 * All rights Reserved, Designed By yyh
 * 求众数
 *
 * @Package simple
 * @author: yyh
 * @date: 2019-10-16 15:40
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_169 {

    /**
     * my Result(once pass):利用map存储每个数字出现的次数
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @return
     */
    private static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("no result");
    }

    /**
     * leetcode : 暴力法，判断每一个元素是否为众数，
     * 时间复杂度:O(n^2)
     * 空间复杂度:O(1)
     * @param nums
     * @return
     */
    private static int majorityElement2(int[] nums) {
        int majorityCount = nums.length / 2;
        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (elem == num) {
                    count += 1;
                }
            }
            if (count > majorityCount) {
                return num;
            }
        }
        return -1;
    }


    /**
     * leetcode ： 排序
     * @param nums
     * @return
     */
    private static int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     * leetcode：投票法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    private static int majorityElement4(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }




    public static void main(String[] args) {
        System.out.println(majorityElement4(new int[]{7, 3, 3}));
    }
}
