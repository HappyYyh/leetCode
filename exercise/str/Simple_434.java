package exercise.str;

/**
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 示例:
 * 输入: "Hello, my name is John"
 * 输出: 5
 *
 * All rights Reserved, Designed By yyh
 * 字符串中的单词数
 * @Package exercise.str
 * @author: yyh
 * @date: 2019-11-07 15:22
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_434 {

    /**
     * my result (one pass : time over 100%) 利用split，不知道算不算违规
     * @param s
     * @return
     */
    private static int countSegments(String s) {
        if(s == null || "".equals(s)){
            return 0;
        }
        String[] arr = s.split(" ");
        int len = arr.length;
        for (String item : arr){
            if("".equals(item)){
                len--;
            }
        }
        return len;
    }

    /**
     * leetcode : 内置函数
     * @param s
     * @return
     */
    private static int countSegments2(String s) {
        String trimmed = s.trim();
        if ("".equals(trimmed)) {
            return 0;
        }
        return trimmed.split("\\s+").length;
    }

    /**
     * leetcode : 原地法
     * 时间复杂度 : O(n)。对每个下标进行常数时间的检测。
     * 空间复杂度 : O(1)。只使用了额外的几个整数，因此使用的空间为常数。
     * @param s
     * @return
     */
    private static int countSegments3(String s) {
        int segmentCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }

        return segmentCount;
    }


    public static void main(String[] args) {
        System.out.println(countSegments3("Hello, my name is John"));
    }
}
