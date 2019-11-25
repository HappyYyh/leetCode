package exercise.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * All rights Reserved, Designed By yyh
 * 有效的字母异位词
 * @Package exercise.hash
 * @author: yyh
 * @date: 2019-11-25 16:32
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_242 {

    /**
     * my result (once pass) :利用两个map存储s和t，然后判断两个map是否相同
     * hashMap可以存unicode
     * @param s
     * @param t
     * @return
     */
    private static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s.length() ; i++) {
            map1.put(s.charAt(i),map1.getOrDefault(s.charAt(i),0) + 1);
            map2.put(t.charAt(i),map2.getOrDefault(t.charAt(i),0) + 1);
        }
        for (Map.Entry<Character,Integer> entry : map1.entrySet()){
            if(!map2.containsKey(entry.getKey())){
                return false;
            }
            if(!entry.getValue().equals(map2.get(entry.getKey()))){
                return false;
            }
        }
        return true;
    }

    /**
     * leetcode：hash表
     * 为了检查 t 是否是 s 的重新排列，我们可以计算两个字符串中每个字母的出现次数并进行比较。
     * 因为 S 和 T 都只包含 A-Z 的字母，所以一个简单的 26 位计数器表就足够了。
     * 我们需要两个计数器数表进行比较吗？
     * 实际上不是，因为我们可以用一个计数器表计算 s 字母的频率，用 t 减少计数器表中的每个字母的计数器，
     * 然后检查计数器是否回到零。
     *
     * @param s
     * @param t
     * @return
     */
    private static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isAnagram2("anagram","nagaram"));
        System.out.println(isAnagram("rat","car"));
    }
}
