package exercise.stack;

import java.util.Stack;

/**
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 * 示例：
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。
 * 之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *  
 *
 * 提示：
 *
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 *
 * All rights Reserved, Designed By yyh
 * 删除字符串中的所有相邻重复项
 * @Package exercise.stack
 * @author: yyh
 * @date: 2019-11-21 18:35
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_1047 {

    /**
     * my result (once pass) :利用栈操作，遇到相同的出栈，最后留在栈中的肯定是不同的
     * @param S
     * @return
     */
    private static String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length() ; i++) {
            if(stack.isEmpty()){
                stack.push(S.charAt(i));
            }else {
                if(stack.peek() == S.charAt(i)){
                    stack.pop();
                }else {
                    stack.push(S.charAt(i));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }
}
