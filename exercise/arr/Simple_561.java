package exercise.arr;

import java.util.Arrays;

/**
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，
 * 使得从1 到 n 的 min(ai, bi) 总和最大。
 *
 * 示例 1:
 * 输入: [1,4,3,2]
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 *
 * 提示:
 *
 * n 是正整数,范围在 [1, 10000].
 * 数组中的元素范围在 [-10000, 10000].
 *
 * All rights Reserved, Designed By yyh
 * 数组拆分 I
 * @Package exercise.arr
 * @author: yyh
 * @date: 2019-12-13 14:17
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_561 {

    /**
     * my result (once pass ,time over 91.2%):排序后取出奇数位之和
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    private static int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i <nums.length ; i += 2) {
            sum+=nums[i];
        }
        return sum;
    }

    /**
     * leetcode:使用额外的空间
     * 由于给定数组中的元素范围有限 [-10000, 10000]，我们可以使用 arr 的哈希表，这样 arr [i] 存储 （i-10000）^ {th}
     * 元素的出现频率。 这个减法操作可以保证这个哈希表可以能够存下范围内的所有数字。
     *
     * 时间复杂度：O(n)。需要遍历一次哈希表 arr。
     * 空间复杂度：O(n)。存储一个大小为n哈希表 arr 所需要的空间。
     * @param nums
     * @return
     */
    private static int arrayPairSum2(int[] nums) {
        int[] arr = new int[20001];
        int lim = 10000;
        for (int num: nums) {
            arr[num + lim]++;
        }
        int d = 0, sum = 0;
        for (int i = -10000; i <= 10000; i++) {
            sum += (arr[i + lim] + 1 - d) / 2 * i;
            d = (2 + arr[i + lim] - d) % 2;
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] nums = {1,4,3,2,5,6,-7,8};
        System.out.println(arrayPairSum(nums));
    }
}
