package exercise.arr;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。
 * 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 *
 * 示例 1：
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 *
 * 示例 2：
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 *
 * 示例 3：
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 * 提示：
 *
 * 0 ≤ N ≤ 30
 *
 * All rights Reserved, Designed By yyh
 * 斐波那契数
 * @Package exercise.arr
 * @author: yyh
 * @date: 2019-12-12 13:40
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_509 {

    /**
     * my result(once pass):递归
     * 时间复杂度：O(2^n)
     * @param N
     * @return
     */
    private static int fib(int N) {
        int f0 = 0;
        int f1 = 1;
        if(N == 0){
            return f0;
        }
        if(N == 1){
            return f1;
        }
        return fib(N-1) + fib(N-2);
    }

    /**
     * other :动态规划
     * 时间复杂度：O(n)
     * @param N
     * @return
     */
    private static int fib2(int N) {
        int curr = 0, next = 1;
        while(N-- > 0) {
            next = next + curr;
            curr = next - curr;
        }
        return curr;
    }

    public static void main(String[] args) {
        System.out.println(fib2(30));
    }
}
