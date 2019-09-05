package simple;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * All rights Reserved, Designed By yyh
 * 爬楼梯
 * @Package simple
 * @author: yyh
 * @date: 2019-09-05 15:01
 * @since V1.1.0-SNAPSHOT
 */
public class Simple_70 {

    /**
     * my result:利用斐波那契 for循环迭代(用递归会超时)
     * 时间复杂度：O(n)，单循环到 n，需要计算第 n 个斐波那契数。
     *
     * 空间复杂度：O(1)，使用常量级空间。
     * @param n
     * @return
     */
    private static int climbStairs(int n) {
        long result =0;
        long a = 1;
        long b = 2;
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        for (int i = 2; i <n ; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return (int)result;
    }

    /**
     * 动态规划
     * 不难发现，这个问题可以被分解为一些包含最优子结构的子问题，即它的最优解可以从其子问题的最优解来有效地构建，我们可以使用动态规划来解决这一问题。
     * 第 i 阶可以由以下两种方法得到：
     * 在第 (i-1) 阶后向上爬一阶。
     * 在第 (i-2) 阶后向上爬 2 阶。
     *
     * 所以到达第 i 阶的方法总数就是到第 (i-1) 阶和第 (i-2) 阶的方法数之和。
     * 令 dp[i]表示能到达第 i 阶的方法总数：
     * dp[i]=dp[i-1]+dp[i-2]
     *
     * 时间复杂度：O(n)，单循环到 n 。
     * 空间复杂度：O(n)，dp 数组用了 n 的空间。
     * @param n
     * @return
     */
    private static int climbStairs2(int n) {
        if(n == 1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(38));
    }
}
