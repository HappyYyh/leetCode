package simple;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 *
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * All rights Reserved, Designed By yyh
 * 加一
 * @Package simple
 * @author: yyh
 * @date: 2019-09-02 15:23
 * @since V1.1.0-SNAPSHOT
 */
public class Simple_66 {

    /**
     * my result : 先判断是否为9/99/999这种数字，符合就返回10/100/1000这样的数组，不符合就不用考虑数组扩容
     * @param digits
     * @return
     */
    private static int[] plusOne(int[] digits) {
        int time = 0;
        for (int val : digits){
            if(val == 9){
                time++;
            }
        }
        //如果所有位数都是9
        if(time == digits.length){
            int[] newArr = new int[digits.length+1];
            newArr[0] = 1;
            return newArr;
        }
        //个位+1
        digits[digits.length-1] ++;
        for (int i = digits.length - 1 ; i >= 0 ; i--) {
            //如果为10，则把当前位置为0，前一位+1
            if(digits[i] == 10){
                digits[i] = 0;
                digits[i-1] ++;
            }
        }
        return digits;
    }

    /**
     * 如果当前不为999这种需要进位的直接返回数组
     * @param digits
     * @return
     */
    private static int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0){
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {9,8,7,6,5,4,3,2,1,0};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
}
