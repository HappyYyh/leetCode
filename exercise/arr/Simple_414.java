package exercise.arr;

import java.util.TreeSet;

/**
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 *
 * 示例 1:
 * 输入: [3, 2, 1]
 * 输出: 1
 * 解释: 第三大的数是 1.
 *
 * 示例 2:
 * 输入: [1, 2]
 * 输出: 2
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 *
 * 示例 3:
 * 输入: [2, 2, 3, 1]
 * 输出: 1
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 *
 * All rights Reserved, Designed By yyh
 * 第三大的数
 * @Package exercise.arr
 * @author: yyh
 * @date: 2019-12-09 13:30
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_414 {

    /**
     * other: 借用TreeSet（红黑树） O(n)
     * 维护一个只有3个元素的TreeSet，如果大于三个元素就就把Set中的最小最小值remove掉。
     * 后如果Set中元素小于3就返回Set最大值，否则返回最小值。
     * @param nums
     * @return
     */
    private static int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("error");
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (Integer elem : nums) {
            set.add(elem);
            if (set.size() > 3) {
                set.remove(set.first());
            }
        }
        // set.last() 里面最大的元素
        return set.size() < 3 ? set.last() : set.first();
    }

    public static void main(String[] args) {
        int[] arr1 = {3,2,1};
        int[] arr2 = {1,2};
        int[] arr3 = {2,2,3,1};
        System.out.println(thirdMax(arr1));
        System.out.println(thirdMax(arr2));
        System.out.println(thirdMax(arr3));
    }
}
