package exercise.str;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1:
 * 输入: "hello"
 * 输出: "holle"
 *
 * 示例 2:
 * 输入: "c"
 * 输出: "leotcede"
 *
 * 说明:
 * 元音字母不包含字母"y"。  元音字母：a、e、i、o、u
 *
 * @ClassName: Simple_345
 * @description: 反转字符串中的元音字母
 * @author: yyh
 * @create: 2019-11-02 11:36
 **/
public class Simple_345 {

    /**
     * my result :双指针法
     * 列出所有的元音字母，然后两侧匹配，同时满足则交换
     * 时间复杂度：O(n)
     * 空间复杂度：O(1),只创建了几个对象
     * @param s
     * @return
     */
    private static String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int left = 0,right = chars.length-1;
        while (left < right){
            if(vowels.indexOf(chars[left]) == -1 ){
                left++;
                continue;
            }
            if(vowels.indexOf(chars[right]) == -1){
                right--;
                continue;
            }
            char tmp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = tmp;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("aA"));
    }
}
