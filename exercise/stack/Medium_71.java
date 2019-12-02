package exercise.stack;

import java.util.Stack;

/**
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * 在 Unix 风格的文件系统中，
 * 一个点（.）表示当前目录本身；
 * 此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；
 * 两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 *
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。
 * 最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 *
 *  
 * 示例 1：
 * 输入："/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 *
 * 示例 2：
 * 输入："/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
 *
 * 示例 3：
 * 输入："/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 *
 * 示例 4：
 * 输入："/a/./b/../../c/"
 * 输出："/c"
 *
 * 示例 5：
 * 输入："/a/../../b/../c//.//"
 * 输出："/c"
 *
 * 示例 6：
 * 输入："/a//b////c/d//././/.."
 * 输出："/a/b/c"
 *
 * All rights Reserved, Designed By yyh
 * 简化路径
 * @Package exercise.stack
 * @author: yyh
 * @date: 2019-11-22 13:25
 * @since V1.0.0-SNAPSHOT
 */
public class Medium_71 {

    /**
     * other:
     * 1.此题主要考察的是栈,所以定义一个辅助栈;
     * 2.先把字符串以"/"为分隔符分割成数组,此时数组有"路径"、""、"."、".."这四种情况;
     * 3.遍历数组,当s[i].equals("..")并且栈不空时pop,当!s[i].equals("") && !s[i].equals(".") && !s[i].equals(".."),即s[i]是路径入栈;
     * 4.栈空,返回"/",栈非空,用StringBuffer做一个连接返回即可;
     * 5完结。
     *
     * @param path
     * @return
     */
    private static String simplifyPath(String path) {
        String[] s = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String item : s) {
            if (!stack.isEmpty() && "..".equals(item)) {
                stack.pop();
            } else if (!"".equals(item) && !".".equals(item) && !"..".equals(item)) {
                stack.push(item);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder res = new StringBuilder();
        for (String value : stack) {
            res.append("/").append(value);
        }
        return res.toString();
    }


    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/b/c../..////b"));
    }
}