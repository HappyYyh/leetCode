package simple;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @ClassName: Simple_7
 * @description:
 * @author: 昊天
 * @create: 2019-08-24 09:51
 **/
public class Simple_7 {

    /**
     * 我的解法
     * @param x
     * @return
     */
    private static int reverse(int x) {
        if(x > 0){
            int y = x;
            String result = "";
            while(y>0){
                result += y%10;
                y /= 10;
            }
            int z;
            try {
                z =  Integer.parseInt(result);
            }catch (NumberFormatException e){
                //遇到异常则说明数据溢出
                return 0;
            }
            return z;
        }
        if(x <0 ){
            x = x * (-1);
            int y = x;
            String result = "";
            while(y>0){
                result += y%10;
                y /= 10;
            }
            int z;
            try {
                z =  Integer.parseInt(result)*(-1);
            }catch (NumberFormatException e){
                return 0;
            }
            return z;
        }
        return 0;

    }

    /**
     * 思路
     *
     * 我们可以一次构建反转整数的一位数字。在这样做的时候，我们可以预先检查向原整数附加另一位数字是否会导致溢出。
     *
     * 算法
     *
     * 反转整数的方法可以与反转字符串进行类比。
     *
     * 我们想重复“弹出” xx 的最后一位数字，并将它“推入”到 rev 的后面。最后，rev 将与 xx 相反。
     *
     * 要在没有辅助堆栈 / 数组的帮助下 “弹出” 和 “推入” 数字，我们可以使用数学方法。
     *
     * //pop operation:
     * pop = x % 10;
     * x /= 10;
     *
     * //push operation:
     * temp = rev * 10 + pop;
     * rev = temp;
     * 但是，这种方法很危险，因为当 temp = rev* 10 +pop 时会导致溢出。
     * 幸运的是，事先检查这个语句是否会导致溢出很容易。
     * 为了便于解释，我们假设 \text{rev}rev 是正数。
     * 如果 temp = rev* 10 +pop  导致溢出，那么一定有 \text{rev} \geq \frac{INTMAX}{10}rev≥
     * 10
     * INTMAX
     *  。
     * 如果 \text{rev} > \frac{INTMAX}{10}rev>
     * 10
     * INTMAX
     * ​
     *  ，那么 temp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop 一定会溢出。
     * 如果 \text{rev} == \frac{INTMAX}{10}rev==
     * 10
     * INTMAX
     * ​
     *  ，那么只要 \text{pop} > 7pop>7，temp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop 就会溢出。
     * 当 \text{rev}rev 为负时可以应用类似的逻辑。
     *
     * @param x
     * @return
     */
    private static int reverse2(int x){
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }


    public static void main(String[] args) {
        System.out.println(reverse(-1534236469));
    }
}
