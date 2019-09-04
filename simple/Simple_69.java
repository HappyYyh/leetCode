package simple;

/**
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 * 输入: 4
 * 输出: 2
 *
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 *
 * All rights Reserved, Designed By yyh
 * x的平方根
 * @Package simple
 * @author: yyh
 * @date: 2019-09-04 14:55
 * @since V1.1.0-SNAPSHOT
 */
public class Simple_69 {

    /**
     * 二分法
     * 我们这里取right的上限为2^16，在整个二分过程中，m通常也是2的幂次或者是几个2的幂次组合。
     * 反映到2进制上，m只有几位上是1。这样在m*m的计算中，要计算的位数就比较少，会很快。从底层优化了运算。
     *
     * @param x
     * @return
     */
    private static int mySqrt(int x) {
        int left = 0;
        // int的极值
        int right = 1 << 16;
        while (left < right-1) {
            int mid = (left+right)/2;
            //防止溢出,使用long
            long square = (long)mid*mid;
            if (square <= x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * 二分法
     * 注意0的特殊情况，所以此处将左边界设置为0,注意1的特殊情况，所以此处将右边界设置为x/2+1
     * @param x
     * @return
     */
    private static int mySqrt2(int x) {
        //注意：针对特殊测试用例，例如 2147395599，要把搜索的范围设置成长整型
        long left = 0;
        long right = x/2+1;
        while (left<right){
            //注意，这里应该取右中位数，如果取左中位数，代码会进入死循环
            //long mid = left + (right - left + 1) / 2;(无符号右移一位等于/2)
            long mid = (left + right + 1) >>> 1;
            long square = mid*mid;
            if(square>x){
                right = mid - 1;
            }else {
                left = mid;
            }
        }
        //当左边界大于右边界时，返回强制转换为int类型的左边界值
        return (int)left;

    }

    /**
     * 牛顿法(数学两行泪)
     * 使用牛顿法可以得到一个正实数的算术平方根，因为题目中说“结果只保留整数部分”，
     * 因此，我们把使用牛顿法得到的浮点数转换为整数即可。
     *
     * 这里给出牛顿法的思想：
     * 在迭代过程中，以直线代替曲线，用一阶泰勒展式（即在当前点的切线）代替原曲线，求直线与 xx 轴的交点，
     * 重复这个过程直到收敛。
     * @param x
     * @return
     */
    private static int mySqrt3(int x) {
        long result = x;
        while (result * result > x) {
            result = (result + x / result) / 2;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt3(Integer.MAX_VALUE));
    }
}
