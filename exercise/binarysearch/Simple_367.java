package exercise.binarysearch;

/**
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * <p>
 * 示例 1：
 * 输入：16
 * 输出：True
 * <p>
 * 示例 2：
 * 输入：14
 * 输出：False
 * <p>
 * All rights Reserved, Designed By yyh
 * 有效的完全平方数
 *
 * @Package exercise.binarysearch
 * @author: yyh
 * @date: 2019-12-03 14:44
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_367 {

    /**
     * my result :二分法
     *
     * @param num
     * @return
     */
    private static boolean isPerfectSquare(int num) {
        int l = 1;
        int r = num;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            // 注意这里会越界
            long res = (long) mid * mid;
            if (res < num) {
                l = mid + 1;
            } else if (res > num) {
                r = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * other :数学法
     * 数学定理(1 + 3 + 5 + ... + (2n - 1) = n ^ 2)
     *
     * @param num
     * @return
     */
    private static boolean isPerfectSquare2(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }

    /**
     * other :牛顿迭代法
     * @param num
     * @return
     */
    private static boolean isPerfectSquare3(int num) {
        if(1 == num) {
            return true;
        }
        int i = num / 2;
        while((double)i * i > num){
            i = (i + num / i) / 2;
        }
        return i * i == num;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare3(4096));
        System.out.println(isPerfectSquare2(808201));
    }
}
