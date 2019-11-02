package exercise.str;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
 * 判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。
 * 如果可以构成，返回 true ；否则返回 false。
 *
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
 *
 * 注意：
 *
 * 你可以假设两个字符串均只含有小写字母。
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 *
 * @ClassName: Simple_383
 * @description: 赎金信
 * @author: yyh
 * @create: 2019-11-02 12:08
 **/
public class Simple_383 {

    /**
     * my result(once pass) :利用hash表存储两个字符串，key为字符，value为字符串中出现的个数
     *                       当map2不存在map1的key或者map2.value<map1.value时返回false
     * @param ransomNote
     * @param magazine
     * @return
     */
    private static boolean canConstruct(String ransomNote, String magazine) {
        if(magazine.length() < ransomNote.length()){
            return false;
        }
        char[] chars1 = ransomNote.toCharArray();
        char[] chars2 = magazine.toCharArray();
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        for (char c : chars1) {
            map1.merge(c, 1, Integer::sum);
        }
        for (char c : chars2) {
            map2.merge(c, 1, Integer::sum);
        }
        for (Map.Entry<Character,Integer> entry : map1.entrySet()){
            Character key = entry.getKey();
            if(map2.get(key) == null || map2.get(key) <entry.getValue()){
                return false;
            }
        }
        return true;
    }
	
	/**
     * other : 利用桶来辅助解决
     *          我是使用了桶来进行计数，首先遍历字符串b，将b中的字母及其频次存入桶中，
     *          例如a就会存在桶的0这个索引位置。然后再遍历字符串a，每次遍历将a的的这个字符对应的桶中的数-1，
     *          如果这个桶为负数，则会返回false，说明这个桶中的元素不够用了。
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    private static boolean canConstruct2(String ransomNote, String magazine) {
        int[] buckets = new int[26];
        for(int i = 0; i < magazine.length(); i++) {
            buckets[magazine.charAt(i) - 'a']++;
        }
        for(int i = 0; i < ransomNote.length(); i++) {
            if(--buckets[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("aa","aab"));
    }
}
