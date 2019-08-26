package simple;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 *
 * 解释: 输入不存在公共前缀。
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 *
 * All rights Reserved, Designed By yyh
 *
 * @Package simple
 * @author: yyh
 * @date: 2019-08-26 9:12
 * @since V1.1.0-SNAPSHOT
 */
public class Simple_14 {

    private static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if(strs.length > 0) {
            String first = strs[0];
            for (int i = 0 ; i < first.length(); i++ ) {
                //记录相同的次数
                int time = 0;
                for (String str : strs) {
                    if(null == str){
                        break;
                    }
                    if(str.length() < i+1){
                        break;
                    }
                    if(str.charAt(i) == first.charAt(i)){
                        time++;
                    }
                }
                //每个字符串都包含才算公共前缀
                if (time == strs.length) {
                    sb.append(first.charAt(i));
                }else {
                    //不满足则跳出循环
                    break;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs  = {"flower","flow","floght"};
        String[] strs2  = {"dog","racecar","car"};
        String[] strs3 = new String[1];
        String[] strs4  = {"aa","ab"};
        String[] strs5  = {"aca","cba"};
        System.out.println(longestCommonPrefix(strs5));
    }
}
