package exercise.sort;

import java.util.Arrays;

/**
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * 如果不能形成任何面积不为零的三角形，返回 0。
 *
 * 示例 1：
 * 输入：[2,1,2]
 * 输出：5
 *
 * 示例 2：
 * 输入：[1,2,1]
 * 输出：0
 *
 * 示例 3：
 * 输入：[3,2,3,4]
 * 输出：10
 *
 * 示例 4：
 * 输入：[3,6,2,3]
 * 输出：8
 *
 * 提示：
 *
 * 3 <= A.length <= 10000
 * 1 <= A[i] <= 10^6
 *

 * All rights Reserved, Designed By yyh
 * 三角形的最大周长
 * @Package exercise.sort
 * @author: yyh
 * @date: 2019-12-23 13:51
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_976 {

    /**
     * my result (once pass time over 23.23%): 排序后遍历
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     * @param A
     * @return
     */
    private static int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 3; i >= 0; i--) {
            if (A[i] + A[i + 1] > A[i + 2]) {
                return A[i] + A[i + 1] + A[i + 2];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums1 = {2,1,2};
        int[] nums2 = {1,2,1};
        int[] nums3 = {3,2,3,4};
        int[] nums4 = {3,6,2,3};
        System.out.println(largestPerimeter(nums1));
        System.out.println(largestPerimeter(nums2));
        System.out.println(largestPerimeter(nums3));
        System.out.println(largestPerimeter(nums4));
    }
}
