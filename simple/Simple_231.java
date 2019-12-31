package simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 * 输入: 1
 * 输出: true
 * 解释: 2^0 = 1
 *
 * 示例 2:
 * 输入: 16
 * 输出: true
 * 解释: 2^4 = 16
 *
 * 示例 3:
 * 输入: 218
 * 输出: false
 *
 * All rights Reserved, Designed By yyh
 * 2的幂
 * @Package simple
 * @author: yyh
 * @date: 2019-12-31 15:06
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_231 {

    /**
     * my result :穷举2的幂，然后判断n是否在其中
     * 时间复杂度：O(31) ->O(1)
     * @param n
     * @return
     */
    private static boolean isPowerOfTwo(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 31 ; i++) {
            list.add((int)Math.pow(2,i));
        }
        return list.contains(n);
    }

    /**
     * other:位运算
     * 若 n = 2^x且 x 为自然数（即 nn为 22的幂），则一定满足以下条件：
     * 1、恒有 n & (n - 1) == 0，这是因为：
     *    n 二进制最高位为 1，其余所有位为 0；
     *    n - 1二进制最高位为 0，其余所有位为 1；
     * 2、一定满足 n > 0。
     *
     * @param n
     * @return
     */
    private static boolean isPowerOfTwo2(int n) {
        //Integer.bitCount(n)
        return n > 0 && (n & (n - 1)) == 0;
    }


    public static void main(String[] args) {
        System.out.println(isPowerOfTwo2(2147483647));
    }
}
