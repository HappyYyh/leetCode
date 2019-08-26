package simple;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 * 输入: "()"
 * 输出: true
 *
 * 示例2:
 * 输入: "()[]{}"
 * 输出: true
 *
 * 示例3:
 * 输入: "(]"
 * 输出: false
 *
 * 示例4:
 * 输入: "([)]"
 * 输出: false
 *
 * 示例5:
 * 输入: "{[]}"
 * 输出: true
 *

 * @ClassName: Simple_20
 * @description: 括号匹配
 * @author: 昊天
 * @create: 2019-08-26 21:13
 **/
public class Simple_20 {

    /**
     * 方法执行次数
     */
    private int methodTime;
    /**
     * 返回true的次数
     */
    private int trueTime;

    /**
     * my result:递归
     * @param str
     * @return
     */
    private boolean isValid(String str){
        methodTime++;
        if(str.length()==0){
            trueTime++;
            return true;
        }
        if(str.length()%2==0){
            Map<Character,Character> map = new HashMap<>();
            map.put('(',')');
            map.put('{','}');
            map.put('[',']');
            char[] chars = str.toCharArray();
            StringBuilder sb = new StringBuilder(str);
            for (int i = 0; i < chars.length/2; i++) {
                if(map.get(chars[i]) != null) {
                    //遇到第一个匹配的括号则进行删除该字符，并进行递归
                    if (map.get(chars[i]).equals(chars[i + 1])) {
                        sb.delete(i, i + 2);
                        trueTime++;
                        isValid(sb.toString());
                        break;
                    }
                }else {
                    //右括号开头的直接返回false
                    return false;
                }
            }
        }
        System.out.println("methodTime:"+methodTime);
        System.out.println("trueTime:"+trueTime);
        return methodTime == trueTime;
    }

    /**
     * 首先把字符串里面的左括号所对应的右括号进栈，当遇到不是左括号的时候，就判断这个括号是否和刚进栈的字符一样。
     * 在查完之前，如果栈为空，说明这个字符之前的括号都是配对的，并且这个是右括号，返回false
     * 例如；’（[]){’ 前四个字符配对，第五个没有配对的,所以返回false.
     * @param str
     * @return
     */
    private boolean isValid2(String str){
        Stack<Character> stack= new Stack<>();
        for(char c:str.toCharArray()){
            if(c=='('){
                stack.push(')');
            } else if(c=='['){
                stack.push(']');
            }
            else if(c=='{') {
                stack.push('}');
            } else if(stack.isEmpty()||stack.pop()!=c) {
                return false;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println(new Simple_20().isValid2("{[]}"));
    }
}
