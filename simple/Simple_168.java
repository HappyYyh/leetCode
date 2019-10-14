package simple;

/**
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 例如，
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 *
 * 示例 1:
 * 输入: 1
 * 输出: "A"
 *
 * 示例 2:
 * 输入: 28
 * 输出: "AB"
 *
 * 示例 3:
 * 输入: 701
 * 输出: "ZY"
 *
 * All rights Reserved, Designed By yyh
 * Excel表列名称
 * @Package simple
 * @author: yyh
 * @date: 2019-10-14 14:29
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_168 {

    /**
     * 利用取余，最后逆序
     * @param n
     * @return
     */
    private static String convertToTitle(int n) {
        String AZ = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] CZ = AZ.toCharArray();

        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            if (n % 26 == 0) {
                sb.append('Z');
                n = n / 26 - 1;
            } else {
                //这里减一是因为数组下标比返回的值小一
                sb.append(CZ[n % 26 -1 ]);
                n = n / 26;
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(26));
    }
}
