package exercise.sort;

import java.util.Arrays;

/**
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 *
 * 示例：
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *  
 * 提示：
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 *
 * @ClassName: Simple_922
 * @description: 按奇偶排序数组 II
 * @author: yyh
 * @create: 2019-12-21 11:26
 **/
public class Simple_922 {

    /**
     * my result (once pass ,time over 89.47%)：把数据按奇偶放入新的数组
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param A
     * @return
     */
    private static int[] sortArrayByParityII(int[] A) {
        int[] res = new int[A.length];
        // 偶数索引
        int even = 0;
        // 奇数索引
        int odd = 1;
        for (int value : A) {
            if (value % 2 == 0) {
                res[even] = value;
                even += 2;
            } else {
                res[odd] = value;
                odd += 2;
            }
        }
        return res;
    }

    /**
     * leetcode :双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param A
     * @return
     */
    private static int[] sortArrayByParityII2(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) {
                    j += 2;
                }
                // Swap A[i] and A[j]
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        return A;
    }


    public static void main(String[] args) {
        int[] A = {4,2,5,7,2,3};
        System.out.println(Arrays.toString(sortArrayByParityII2(A)));
    }
}
