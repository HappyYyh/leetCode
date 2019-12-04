package exercise.binarysearch;

/**
 * 我们正在玩一个猜数字游戏。 游戏规则如下：
 * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 * 每次你猜错了，我会告诉你这个数字是大了还是小了。
 * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 * <p>
 * -1 : 我的数字比较小
 * 1 : 我的数字比较大
 * 0 : 恭喜！你猜对了！
 * 示例 :
 * <p>
 * 输入: n = 10, pick = 6
 * 输出: 6
 * <p>
 * All rights Reserved, Designed By yyh
 * 猜数字大小
 *
 * @Package exercise.binarysearch
 * @author: yyh
 * @date: 2019-12-04 15:56
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_374 {

    /**
     * The guess API is defined in the parent class GuessGame.
     * @param num, your guess
     * @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
     * @param num
     * @return
     */
    private static int guess(int num) {
        return Integer.compare(6, num);
    }

    /**
     * my result : 二分法
     * @param n
     * @return
     */
    private static int guessNumber(int n) {
        int l = 0;
        int r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if(guess(mid) == 1){
                l = mid + 1;
            }else if(guess(mid) == -1){
                r = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * leetcode : 三分查找
     * @param n
     * @return
     */
    private static int guessNumber2(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;
            int res1 = guess(mid1);
            int res2 = guess(mid2);
            if (res1 == 0) {
                return mid1;
            }
            if (res2 == 0) {
                return mid2;
            } else if (res1 < 0) {
                high = mid1 - 1;
            } else if (res2 > 0) {
                low = mid2 + 1;
            } else {
                low = mid1 + 1;
                high = mid2 - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }
}
