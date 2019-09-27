package simple;



/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * All rights Reserved, Designed By yyh
 * 验证回文串
 * @Package simple
 * @author: yyh
 * @date: 2019-09-27 15:56
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_125 {

    /**
     * my result(一次通过)：直接转小写然后遍历 符合条件的拿出来进行拼接，然后比较
     * @param s
     * @return
     */
    private static boolean isPalindrome(String s) {
        if(null == s) {
            return false;
        }
        String lowerCase = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (char c : lowerCase.toCharArray()) {
             if( (c>='0' && c<='9') || (c>='a' && c<='z') ){
                 sb.append(c);
             }
        }
        return sb.toString().equals(sb.reverse().toString());
    }

    /**
     * 双指针法：跳过非数字字母的字符；将字母全部转化为小写体，之后判断。
     * @param s
     * @return
     */
    private static boolean isPalindrome2(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j){
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++; j--;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome2("A man, a plan, a canal: Panama"));
    }
}
