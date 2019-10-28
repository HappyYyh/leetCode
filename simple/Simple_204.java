package simple;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 * 示例:
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 * All rights Reserved, Designed By yyh
 * 计数质数
 *
 * @Package simple
 * @author: yyh
 * @date: 2019-10-28 13:55
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_204 {

    /**
     * my result: 从1开始遍历到n，判断每个数是否为质数，如果是count++（时间复杂度O(n^2),超时了。。）
     * @param n
     * @return
     */
    private static int countPrimes(int n) {
        long start = System.currentTimeMillis();
        System.out.println("count start......");
        int count = 0;
        for (int i = 1; i < n ; i++) {
            if(isPrimes(i)){
                count++;
                System.out.print(i + "\t");
            }
        }
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println("count is end.......");
        System.out.println("spend time :" +(end - start) + "ms");
        return count;
    }

    /**
     * 判断一个数是否为质数
     * @param n
     * @return
     */
    private static boolean isPrimes(int n) {
        boolean flag = true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                flag = false;
            }
        }
        return n > 1 && flag;
    }

    /**
     * 厄拉多塞筛法:从比较小的开始起，其倍数肯定不是质数，用布尔数组把其排除，然后重复
     * @param n
     * @return
     */
    private static int countPrimes2(int n) {
        int count = 0;
        boolean[] signs = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!signs[i]) {
                count++;
                //这里倍数 都排除
                for (int j = i + i; j < n; j += i) {
                    signs[j] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes2(64));
    }
}
