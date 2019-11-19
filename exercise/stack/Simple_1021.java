package exercise.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。
 * 例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 *
 * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），
 * 其中 A 和 B 都是非空有效括号字符串。
 *
 * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，
 * 其中 P_i 是有效括号字符串原语。
 *
 * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 *
 * 示例 2：
 *
 * 输入："(()())(())(()(()))"
 * 输出："()()()()(())"
 * 解释：
 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * 删除每隔部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 *
 * 示例 3：
 *
 * 输入："()()"
 * 输出：""
 * 解释：
 * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * 删除每个部分中的最外层括号后得到 "" + "" = ""。
 *  
 *
 * 提示：
 *
 * S.length <= 10000
 * S[i] 为 "(" 或 ")"
 * S 是一个有效括号字符串
 *
 * All rights Reserved, Designed By yyh
 * 删除最外层的括号
 * @Package exercise.stack
 * @author: yyh
 * @date: 2019-11-19 14:10
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_1021 {

    /**
     * my result(once pass):先把第一个左括号入栈，然后记录当前位置；
     *                      之后如果还是左括号则接着入栈，右括号则出栈，直到栈为空，说明一对括号匹配完毕；
     *                      最后把存放在list的位置取出，截取字符串
     * @param S
     * @return
     */
    private static String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack<>();
        List<Integer> ind = new ArrayList<>();
        for (int i = 0; i < S.length() ; i++) {
            // 为空入栈，并记录位置
            if(stack.isEmpty()){
                ind.add(i);
                stack.push(S.charAt(i));
            }else {
                if(S.charAt(i) == '('){
                    stack.push(S.charAt(i));
                }else {
                    // 遇到右括号则消除
                    stack.pop();
                    if(stack.isEmpty()) {
                        // 栈为空则说明一对匹配完毕，记录位置
                        ind.add(i);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ind.size() ; i+= 2) {
            // 两个一组截取字符串
            String tmp = S.substring(ind.get(i) + 1, ind.get(i + 1));
            sb.append(tmp);
        }
        return sb.toString();
    }

    /**
     * my result(once pass) :对于上面方法的优化，不需要记录位置，直接用sb添加
     * @param S
     * @return
     */
    private static String removeOuterParentheses2(String S) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length() ; i++) {
            // 为空入栈，并记录位置
            if(stack.isEmpty()){
                stack.push(S.charAt(i));
            }else {
                if(S.charAt(i) == '('){
                    stack.push(S.charAt(i));
                    sb.append(S.charAt(i));
                }else {
                    // 遇到右括号则消除
                    stack.pop();
                    if(!stack.isEmpty()) {
                        // 栈不为空说明还可以记录
                        sb.append(S.charAt(i));
                    }
                }
            }
        }
        return sb.toString();
    }

    /**
     * other : 没有利用栈，用变量记录是否需要添加
     * @param S
     * @return
     */
    private static String removeOuterParentheses3(String S) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (char c : S.toCharArray()) {
            if (c == ')') {
                --level;
            }
            if (level >= 1) {
                sb.append(c);
            }
            if (c == '(') {
                ++level;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses3("(()())(())"));
    }
}
