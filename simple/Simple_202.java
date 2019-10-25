package simple;

/**
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。
 * 如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例: 
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * All rights Reserved, Designed By yyh
 * 快乐数
 * @Package simple
 * @author: yyh
 * @date: 2019-10-25 14:00
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_202 {

    /**
     * 求平方和不难，难点在于如何结束循环？
     */

    /**
     * 根据别人思路（自己写代码），如果为1说明是，如果不是快乐数 最终会出现4 16 37 58 89 145 42 20循环
     * @param n
     * @return
     */
    private static boolean isHappy(int n) {
        while (true){
            n = getSquare(n);
            if(n == 1){
                return true;
            }
            if(n == 4){
                return false;
            }
        }
    }

    /**
     * other：快慢指针.
     * “快指针”每次走两步，“慢指针”每次走一步，当二者相等时，即为一个循环周期。
     * 此时，判断是不是因为1引起的循环，是的话就是快乐数，否则不是快乐数。
     * @param n
     * @return
     */
    private static boolean isHappy2(int n) {
        int slow = n, fast = n;
        do{
            slow = getSquare(slow);
            fast = getSquare(fast);
            fast = getSquare(fast);
        }while(slow != fast);

        return slow == 1;

    }

    private static int  getSquare(int n){
        int sum = 0;
        while (n != 0 ){
            int now = n%10;
            sum+= now*now;
            n/=10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy2(5));
    }
}
