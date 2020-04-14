package random;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。
 * 你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 *
 * 示例 1:
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "xtfn"。
 *
 * 示例 2:
 * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 *
 * 示例 3:
 * 输入: ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 *
 * @ClassName: Medium_318
 * @description: 最大单词长度乘积
 * @author: yyh
 * @create: 2020-04-14 16:04
 **/
public class Medium_318 {

    /**
     * my result(once pass time pass : 5.01%):暴力法
     * 时间复杂度:O(n^2 * noDuplicate的时间复杂度)
     *
     * @param words
     * @return
     */
    private static int maxProduct(String[] words) {
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (noDuplicate(words[i], words[j])) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    /**
     * 判断两个单词之间是否有重复字母
     *
     * @param a
     * @param b
     * @return
     */
    private static boolean noDuplicate(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
//            if(b.contains(String.valueOf(a.charAt(i)))){
//                return false;
//            }
            if (b.indexOf(a.charAt(i)) != -1) {
                return false;
            }
        }
        return true;
    }

    private static int bitNumber(char ch) {
        return (int) ch - (int) 'a';
    }

    /**
     * leetcode: 位操作+预计算+HashMap
     * 时间复杂度：O(N^2 + L)，其中 N是单词数量，L是所有单词的所有字母的数量。当 N > 2^26时，时间复杂度为 O(L)。
     * 空间复杂度：O(N)，使用一个长度为 N 的 HashMap。
     *
     * @param words
     * @return
     */
    private static int maxProduct2(String[] words) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int bitmask = 0, bitNum = 0;
        for (String word : words) {
            bitmask = 0;
            for (char ch : word.toCharArray()) {
                // add bit number bitNumber in bitmask
                bitmask |= 1 << bitNumber(ch);
            }
            // there could be different words with the same bitmask
            // ex. ab and aabb
            hashMap.put(bitmask, Math.max(hashMap.getOrDefault(bitmask, 0), word.length()));
        }
        int maxProd = 0;
        for (int x : hashMap.keySet()) {
            for (int y : hashMap.keySet()) {
                if ((x & y) == 0) {
                    maxProd = Math.max(maxProd, hashMap.get(x) * hashMap.get(y));
                }
            }
        }
        return maxProd;
    }

    /**
     * other:位运算
     * 用二进制的一位表示某一个字母是否出现过，0表示没出现，1表示出现。
     * "abcd"二进制表示00000000 00000000 00000000 00001111、
     * "bc"二进制表示00000000 00000000 00000000 00000110。
     * 当两个字符串没有相同的字母时，二进制数与的结果为0。
     *
     * @param words
     * @return
     */
    private static int maxProduct3(String[] words) {
        int length = words.length;
        int[] arr = new int[length];
        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < words[i].length(); j++) {
                arr[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        int ans = 0;
        for (int i = 0; i < length; ++i) {
            for (int j = i + 1; j < length; ++j) {
                if ((arr[i] & arr[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words1 = {"abcw","baz","foo","bar","xtfn","abcdef"};
        String[] words2 = {"a","ab","abc","d","cd","bcd","abcd"};
        String[] words3 = {"a","aa","aaa","aaaa"};
        System.out.println(maxProduct3(words1));
        System.out.println(maxProduct2(words2));
        System.out.println(maxProduct(words3));
    }
}
