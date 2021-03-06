package simple;

/**
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 *
 * 示例 1:
 * 输入: "A"
 * 输出: 1
 *
 * 示例 2:
 * 输入: "AB"
 * 输出: 28
 *
 * 示例 3:
 * 输入: "ZY"
 * 输出: 701
 *
 * All rights Reserved, Designed By yyh
 * Excel表列序号
 * @Package simple
 * @author: yyh
 * @date: 2019-10-17 14:55
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_171 {

    /**
     * other:
     * 标签：字符串遍历，进制转换
     * 初始化结果ans = 0，遍历时将每个字母与A做减法，因为A表示1，所以减法后需要每个数加1，计算其代表的数值num = 字母 - ‘A’ + 1
     * 因为有26个字母，所以相当于26进制，每26个数则向前进一位
     * 所以每遍历一位则ans = ans * 26 + num
     * 以ZY为例，Z的值为26，Y的值为25，则结果为26 * 26 + 25=701
     * 时间复杂度：O(n)
     *
     * @param s
     * @return
     */
    private static int titleToNumber(String s) {
        int ans = 0;
        for(int i=0;i<s.length();i++) {
            int num = s.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("AAA"));
    }
}
