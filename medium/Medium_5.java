package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * All rights Reserved, Designed By yyh
 * 最长回文子串
 * @Package medium
 * @author: yyh
 * @date: 2019-09-20 14:25
 * @since V1.0.0-SNAPSHOT
 */
public class Medium_5 {

    /**
     * my result:暴力法，直接列举出全部的字符串，然后超时了GG
     * @param s
     * @return
     */
    private static String longestPalindrome(String s) {
        if(null == s || s.length() == 1 || s.trim().length() == 0){
            return s;
        }
        int len = 0;
        String result = null;
        for (int i = 0; i < s.length() ; i++) {
            for (int j = i + 1; j <= s.length() ; j++) {
                 String str = s.substring(i,j);
                 if(isPalindrome(str) && str.length() > len){
                     len = str.length();
                     result = str;
                 }
            }
        }
        return result;
    }

    private static boolean isPalindrome(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString().equals(s);
    }

    /**
     * leetcode：中心扩展算法
     * 事实上，只需使用恒定的空间，我们就可以在 O(n^2)的时间内解决这个问题。
     * 我们观察到回文中心的两侧互为镜像。因此，回文可以从它的中心展开，并且只有 2n - 1个这样的中心。
     * 你可能会问，为什么会是 2n - 1个，而不是 n个中心？
     * 原因在于所含字母数为偶数的回文的中心可以处于两字母之间（例如 “abba”的中心在两个 ‘b’之间）。
     *
     * 时间复杂度：O(n^2)由于围绕中心来扩展回文会耗去 O(n)的时间，所以总的复杂度为 O(n^2)
     * 空间复杂度：O(1)。
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));
    }
}
