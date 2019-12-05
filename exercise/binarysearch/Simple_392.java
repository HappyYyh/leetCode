package exercise.binarysearch;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 * 返回 true.
 *
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 * 返回 false.
 *
 * 后续挑战 :
 * 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。
 * 在这种情况下，你会怎样改变代码？
 *
 * All rights Reserved, Designed By yyh
 * 判断子序列
 * @Package exercise.binarysearch
 * @author: yyh
 * @date: 2019-12-05 16:54
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_392 {

    /**
     * 参照下面的元素，在s的元素，从判断t是否存在，然后并且从后面一个找
     * @param s
     * @param t
     * @return
     */
    private static boolean isSubsequence2(String s, String t) {
        int index = 0;
        int tIndex = 0;
        for (int i = 0; i < s.length() ; i++) {
            // 当前元素
            char c = s.charAt(i);
            // 当前元素的位置
            int now = t.indexOf(c,tIndex);
            if( now >= tIndex){
                tIndex = now + 1;
                index++;
            }
        }
        return index == s.length();
    }

    /**
     * 定义一个index变量表示找到s字符串变量中第index个字符，i变量是表示从t中的哪一个索引开始找
     * @param s
     * @param t
     * @return
     */
    private static boolean isSubsequence(String s, String t) {
        int index = 0, i = 0;
        while (index < s.length() && t.indexOf(s.charAt(index), i) >= i) {
            i = t.indexOf(s.charAt(index), i) + 1;
            index++;
        }
        return index == s.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence2("ace","abcde"));
    }
}
