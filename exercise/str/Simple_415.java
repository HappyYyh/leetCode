package exercise.str;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 注意：
 *
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 *
 * All rights Reserved, Designed By yyh
 * 字符串相加
 * @Package exercise.str
 * @author: yyh
 * @date: 2019-11-05 15:36
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_415 {

    /**
     * my result(once pass ；time than 94%):逐位相加，超出进位
     * 时间复杂度：O(n)
     * @param num1
     * @param num2
     * @return
     */
    private static String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        //如果num1长度大于num2则进行交换
        if(len1 > len2){
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        int jin = 0;
        StringBuilder sb = new StringBuilder();
        int mix = num2.length() - num1.length();
        for (int i = num1.length() -1 ; i >= 0  ; i--) {
           int val =  num1.charAt(i) - '0' + num2.charAt(mix + i  ) -'0' + jin;
           sb.append(val % 10);
           jin = val / 10;
        }
        for (int i = mix -1; i >=0 ; i--) {
            int val = jin + num2.charAt(i) - '0';
            sb.append(val % 10);
            jin = val / 10;
        }
        //如果最后一位满足进位则添上
        if(jin != 0){
            sb.append(jin);
        }
        return sb.reverse().toString();
    }

    /**
     * other : 双指针
     * @param num1
     * @param num2
     * @return
     */
    private static String addStrings2(String num1, String num2) {
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while(i >= 0 || j >= 0){
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--; j--;
        }
        if(carry == 1) res.append(1);
        return res.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println('1'- '0' + '2'- '0');
        System.out.println(addStrings("500","1500"));
    }
}
