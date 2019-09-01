package simple;

/**
 * 给定一个仅包含大小写字母和空格' '的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0。
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 * 输入: "Hello World"
 * 输出: 5
 *
 * @ClassName: Simple_58
 * @description: 最后一个单词的长度
 * @author: yyh
 * @create: 2019-09-01 09:32
 **/
public class Simple_58 {

    /**
     * my result : 利用string的split方法，比较偷懒
     * @param s
     * @return
     */
    private static int lengthOfLastWord(String s) {
        if(s != null && s.trim().length() > 0) {
            String[] strs = s.split(" ");
            return strs[strs.length - 1].length();
        }
        return 0;
    }

    /**
     * 参考
     * @param s
     * @return
     */
    private static int lengthOfLastWord2(String s) {
        if(s != null && s.trim().length() > 0) {
           int end = s.length() -1 ;
           //遇到空格过滤掉，找到第一个不是空格的字母
           while (end > 0 && s.charAt(end) == ' '){
               end--;
           }
           int start = end;
           while (start >= 0 && s.charAt(start) != ' '){
               start--;
           }
           return end - start;
        }
        return 0;

    }

    public static void main(String[] args) {
        String str = "a";
        System.out.println(lengthOfLastWord2(str));
    }
}
