package simple;

/**
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 *
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 *
 * 说明:
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * All rights Reserved, Designed By yyh
 * 实现strStr()
 * @Package simple
 * @author: yyh
 * @date: 2019-08-29 13:56
 * @since V1.1.0-SNAPSHOT
 */
public class Simple_28 {

    /**
     * my result:偷懒做法，直接用string.indexOf,这样失去了题目的意义
     * @param haystack
     * @param needle
     * @return
     */
    private int strStr(String haystack, String needle) {
        if(null == haystack || null == needle){
            return 0;
        }
        return haystack.indexOf(needle);
    }

    /**
     * my result : 遍历左侧字符串，当左侧字符匹配右侧第一个字符时 ，截取长度，判断是否相等
     * @param haystack
     * @param needle
     * @return
     */
    private int strStr2(String haystack, String needle) {
        if(null == haystack || null == needle || needle.trim().length() == 0){
            return 0;
        }
        char[] left = haystack.toCharArray();
        int i = 0;
        int len = left.length;
        while (len - i >= needle.length()){
            //当左侧字符匹配右侧第一个字符时
            if(left[i] == needle.charAt(0)){
                //截取长度，判断是否相等
                String tmp = haystack.substring(i,i+needle.length());
                if(needle.equals(tmp)){
                    return i;
                }
            }
            i++;

        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Simple_28().strStr("hello","ll"));
    }
}
