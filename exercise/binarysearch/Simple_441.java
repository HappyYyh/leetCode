package exercise.binarysearch;

/**
 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 *
 * 示例 1:
 * n = 5
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * 因为第三行不完整，所以返回2.
 *
 * 示例 2:
 * n = 8
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * 因为第四行不完整，所以返回3.
 *
 * All rights Reserved, Designed By yyh
 * 排列硬币
 * @Package exercise.binarysearch
 * @author: yyh
 * @date: 2019-12-06 15:20
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_441 {

    private static int arrangeCoins(int n) {
        int i=1;
        while (n>=i){
            //n小于该行应有的个数则停止
            n-=i;
            i++;
        }
        return i-1;
    }

    /**
     * 根据数学公式，k(k+1) /2 = n，可以得到其正数解为：k = sqrt(2n+1/4) - 1/2。然后求整即可。
     * 唯一的问题是，这里2n+1/4有可能会超出sqrt函数的参数范围。
     * 于是，我们可以变换一下， k = sqrt(2) * sqrt(n+1/8) - 1/2，这样求平方根就不会超限了。
     * 于是，我们就有了这么一行代码
     *
     * @param n
     * @return
     */
    private static int arrangeCoins2(int n) {
        return (int)(Math.sqrt(2) * Math.sqrt(n + 0.125) - 0.5);
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins2(Integer.MAX_VALUE));
    }
}
