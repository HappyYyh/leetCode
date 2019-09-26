package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 *
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 *
 * 示例 2:
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * All rights Reserved, Designed By yyh
 * Z 字形变换
 * @Package medium
 * @author: yyh
 * @date: 2019-09-26 15:43
 * @since V1.0.0-SNAPSHOT
 */
public class Medium_6 {

    /**
     * leetcode:按行排序
     * 时间复杂度：O(n)，其中 n == len(s)
     * 空间复杂度：O(n)
     * 我们可以使用 min( numRows, len(s)) 个列表来表示 Z 字形图案中的非空行。
     * 从左到右迭代 s，将每个字符添加到合适的行。可以使用当前行和当前方向这两个变量对合适的行进行跟踪。
     * 只有当我们向上移动到最上面的行或向下移动到最下面的行时，当前方向才会发生改变。
     *
     * @param s
     * @param numRows
     * @return
     */
    private static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        //根据s.length是否大于numRows来创建多少个StringBuilder
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goingDown = false;
        //当goingDown为true则正序添加，当为0或者为numRows - 1时倒序添加
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }

    /**
     * leetcode:按行访问
     * 时间复杂度：O(n)，其中 n == len(s)
     * 空间复杂度：O(1)
     * @param s
     * @param numRows
     * @return
     */
    private static String convert2(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    ret.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return ret.toString();
    }


    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING",4));
    }
}
