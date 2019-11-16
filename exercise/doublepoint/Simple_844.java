package exercise.doublepoint;

import java.util.Stack;

/**
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 *
 * 示例 1：
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 *
 * 示例 2：
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 *
 * 示例 3：
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 *
 * 示例 4：
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *  
 *
 * 提示：
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 *
 * All rights Reserved, Designed By yyh
 * 比较含退格的字符串
 * @Package exercise.doublepoint
 * @author: yyh
 * @date: 2019-11-15 15:40
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_844 {

    /**
     * my result(once pass ;time over 99.57%)：对字符串进行处理，count记录#的数量，只有count=0才能添加
     * 时间复杂度：O(n)
     * @param S
     * @param T
     * @return
     */
    private static boolean backspaceCompare(String S, String T) {
        if(S == null || T == null){
            return S == null && T == null;
        }
        return getReal(S).equals(getReal(T));
    }

    private static String getReal(String s){
        if(s == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int count = 0;
        for (int i = len -1; i >= 0;i--) {
            if(s.charAt(i) == '#'){
                count++;
            }else {
                if(count > 0){
                    count--;
                }else {
                    sb.append(s.charAt(i));
                }
            }
        }
        return sb.reverse().toString();
    }

    /**
     * other ： 利用栈
     * @param S
     * @param T
     * @return
     */
    private static boolean backspaceCompare2(String S, String T) {
        if(S == null || T == null){
            return S == null && T == null;
        }
        Stack<Character> s = new Stack<>();
        Stack<Character> t = new Stack<>();
        for (Character c : S.toCharArray()) {
            if (c == '#' && !s.isEmpty()){
                // 第一个条件栈为空不符,跳到这,但是'#'不能添加进来,所以加限制条件
                s.pop();
            }
            else if (c != '#'){
                s.push(c);
            }
        }
        for (Character c : T.toCharArray()) {
            if (c == '#' && !t.isEmpty()) {
                t.pop();
            }
            else if (c != '#') {
                t.push(c);
            }
        }
        // 数量不相同直接false
        if (s.size() != t.size()) {
            return false;
        }
        while (s.size() != 0) {
            if (!s.pop().equals(t.pop())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare2("a#c#","b#"));
    }
}
