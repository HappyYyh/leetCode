package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * All rights Reserved, Designed By yyh
 * 无重复字符的最长子串
 * @Package medium
 * @author: yyh
 * @date: 2019-09-17 15:10
 * @since V1.0.0-SNAPSHOT
 */
public class Medium_3 {

    /**
     * my result ：利用StringBuilder进行判断是否有重复的
     * @param s
     * @return
     */
    private static int lengthOfLongestSubstring(String s) {
        if(null == s || s.length() == 0) {
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        char[] chars = s.toCharArray();
        int max = 1;
        //获取第一个字符
        StringBuilder sb = new StringBuilder(String.valueOf(chars[0]));
        for (int i = 1; i < chars.length ; i++) {
            //如果遇见相同的字符
            if(sb.toString().contains(String.valueOf(chars[i]))){
                //计算当前最大长度
                max = Math.max(sb.length(),max);
                //从sb移除掉相同的部分
                sb.replace(0,sb.indexOf(String.valueOf(chars[i]))+1,"");
            }
            //追加当前字符
            sb.append(chars[i]);
        }
        return Math.max(sb.length(),max);
    }

    /**
     * leetcode : 滑动窗口，利用set存放元素
     * @param s
     * @return
     */
    private static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * leetcode ： 优化的滑动窗口HashMap
     * @param s
     * @return
     */
    private static int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }



    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbbb"));
    }
}
