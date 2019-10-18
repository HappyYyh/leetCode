package simple;

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 *
 * 示例 2:
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 *
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 *
 * All rights Reserved, Designed By yyh
 * 阶乘后的零
 * @Package simple
 * @author: yyh
 * @date: 2019-10-18 15:49
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_172 {

    /**
     * other:很显然，如果需要产生零，阶乘中的数需要包含 2 和 5 这两个因子
     * 又因为 5 的个数一定比 2 少，问题简化为计算 5 的个数就可以了。
     * @param n
     * @return
     */
    private static int trailingZeroes(int n) {
        int sum = 0;
        while(n != 0) {
            //下一次的数
            n = n/5;
            //这一次包含多少个5
            sum += n;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(100));
    }
}
