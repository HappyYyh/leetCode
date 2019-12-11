package exercise.arr;

/**
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 示例 1:
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 *
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 *
 * All rights Reserved, Designed By yyh
 * 最大连续1的个数
 * @Package exercise.arr
 * @author: yyh
 * @date: 2019-12-11 13:37
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_485 {

    /**
     * my result ：遍历
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    private static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0 ;
        int max = 0;
        for (int val : nums){
            if(val == 1){
                count++;
            }else {
                //注意这里 如果max>count 没有必要赋值
                if(max < count){
                    max = count;
                }
                count = 0;
            }
        }
        return Math.max(count,max);
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,0};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
