package exercise.str;

import java.util.HashMap;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 *
 * All rights Reserved, Designed By yyh
 * 字符串中的第一个唯一字符
 * @Package exercise.str
 * @author: yyh
 * @date: 2019-11-04 14:05
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_387 {

    /**
     * my result:暴力破解，超时了。。
     * @param s
     * @return
     */
    private static int firstUniqChar(String s) {
        if(s == null){
            return -1;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length ; i++) {
            char now = chars[i];
            boolean flag = true;
            for (int j = 0; j < chars.length ; j++) {
                if(chars[j] == now && j != i){
                    flag = false;
                }
            }
            if(flag){
                return i;
            }
        }
        return -1;
    }

    /**
     * leetcode:线性时间复杂度解法
     * 这道题最优的解法就是线性复杂度了，为了保证每个元素是唯一的，至少得把每个字符都遍历一遍。
     * 算法的思路就是遍历一遍字符串，然后把字符串中每个字符出现的次数保存在一个散列表中。
     * 这个过程的时间复杂度为 O(N)，其中 N 为字符串的长度。
     * 接下来需要再遍历一次字符串，这一次利用散列表来检查遍历的每个字符是不是唯一的。
     * 如果当前字符唯一，直接返回当前下标就可以了。第二次遍历的时间复杂度也是 O(N)。
     *
     * @param s
     * @return
     */
    private static int firstUniqChar2(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar2("leetcode"));
    }
}
