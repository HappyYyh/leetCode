package exercise.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 *
 * 示例 2:
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 *
 * 示例 3:
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 *
 * 示例 4:
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 *
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
 *
 * All rights Reserved, Designed By yyh
 * 单词规律
 * @Package exercise.hash
 * @author: yyh
 * @date: 2019-11-27 14:33
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_290 {

    /**
     * other : 同时往hashMap里放pattern和str的内容，如果map返回的v不同，(map存放如果存在会返回原先的value，不存在返回null)则false
     * @param pattern
     * @param str
     * @return
     */
    private static boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if(words.length != pattern.length()){
            return false;
        }
        Map<Object, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!Objects.equals(map.put(words[i], i), map.put(pattern.charAt(i), i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * other:
     * 针对Pattern字符串，我们可以用indexOf来判断每个字符的位置。
     * 针对Str字符串，可以用split函数分割为字符串数组，然后再自定义一个字符串数组的indexOf函数（Apache.Common.Lang里面倒是有，但是用不了）。
     * 依次循环判断每个Pattern中每个字符的indexOf，以及Str数组中每个字符串的indexOf，如果值都相等，则为true，否则为false。
     * @param pattern
     * @param str
     * @return
     */
    private static boolean wordPattern2(String pattern, String str) {
        String[] arr = str.split(" ");
        if (pattern.length() != arr.length) {
            return false;
        }
        int len = pattern.length();
        for (int i = 0; i < len; i++) {
            if(pattern.indexOf(pattern.charAt(i)) != indexOf(arr, arr[i])){
                return false;
            }
        }
        return true;
    };

    private static int indexOf(String[] arrays, String searchString) {
        int ans = -1;
        for(int i = 0; i < arrays.length; i++) {
            if (arrays[i].equals(searchString)) {
                ans = i;
                break;
            };
        };
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog cat cat dog"));
        System.out.println(wordPattern("abba","dog cat cat fish"));
        System.out.println(wordPattern("aaaa","dog cat cat dog"));
        System.out.println(wordPattern("abba","dog dog dog dog"));
    }
}
