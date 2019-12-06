package exercise.binarysearch;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 示例 1:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 *
 * 示例 2:
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 *
 * 说明:
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。
 * 本题中，如果除法结果溢出，则返回 2^31 − 1。
 *
 * All rights Reserved, Designed By yyh
 * 两数相除
 * @Package exercise.binarysearch
 * @author: yyh
 * @date: 2019-12-06 14:51
 * @since V1.0.0-SNAPSHOT
 */
public class Medium_29 {

    /**
     * 不会，太难了
     * @param dividend
     * @param divisor
     * @return
     */
    private static int divide(int dividend, int divisor) {
        int ans = -1;
        int sign = 1;
        if (dividend > 0) {
            sign = opposite(sign);
            dividend = opposite(dividend);
        }
        if (divisor > 0) {
            sign = opposite(sign);
            divisor = opposite(divisor);
        }

        int originDividend = dividend;
        int originDivisor = divisor;
        if (dividend > divisor) {
            return 0;
        }

        dividend -= divisor;
        while (divisor >= dividend) {
            ans = ans + ans;
            divisor += divisor;
            dividend -= divisor;
        }
        //此时我们传进的是两个负数，正常情况下，它就返回正数，但我们是在用负数累加，所以要取相反数
        int a = ans + opposite(divide(originDividend - divisor, originDivisor));
        if (a == Integer.MIN_VALUE) {
            if (sign > 0) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        } else {
            if (sign > 0) {
                return opposite(a);
            } else {
                return a;
            }
        }
    }

    private static int opposite(int x) {
        return ~x + 1;
    }

    public static void main(String[] args) {
        System.out.println(divide(Integer.MAX_VALUE,1));
    }
}
