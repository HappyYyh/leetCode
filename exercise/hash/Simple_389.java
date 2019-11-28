package exercise.hash;

import java.util.HashMap;
import java.util.Map;


/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 *
 * 示例:
 *
 * 输入：
 * s = "abcd"
 * t = "abcde"
 * 输出：
 * e
 *
 * 解释：
 * 'e' 是那个被添加的字母。
 *
 * All rights Reserved, Designed By yyh
 * 找不同
 * @Package exercise.hash
 * @author: yyh
 * @date: 2019-11-28 15:37
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_389 {

    /**
     * my result : 利用hash表存储左侧，然后遍历右侧，相同减一，不存在直接返回；最后遍历hash表，有小于0的直接返回
     * @param s
     * @param t
     * @return
     */
    private static char findTheDifference(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() ; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length() ; i++) {
            if(map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),map.get(t.charAt(i)) - 1);
                if(map.get(t.charAt(i)) < 0) {
                    return t.charAt(i);
                }
            }else {
                return t.charAt(i);
            }
        }
        throw new RuntimeException("未找到");
    }

    /***
     * other :异或运算
     * 一个数和0做XOR运算等于本身：a⊕0 = a
     * 一个数和其本身做XOR运算等于 0：a⊕a = 0
     * XOR 运算满足交换律和结合律：a⊕b⊕a = (a⊕a)⊕b = 0⊕b = b
     * 所以 两个相同的数异或会消除，那么最后剩下的数和0异或就会为我们需要的数
     *
     * @param s
     * @param t
     * @return
     */
    private static char findTheDifference2(String s, String t) {
        char a = 0;
        for(int i = 0 ; i < s.length() ; i++){
            a^=s.charAt(i);
        }
        for(int i = 0 ; i < t.length() ; i++){
            a^=t.charAt(i);
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "adbca"));
    }
}
