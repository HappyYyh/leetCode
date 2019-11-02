package exercise.str;

import java.util.Arrays;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 *
 * 示例 1：
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 *
 * 示例 2：
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 *
 * @ClassName: Simple_344
 * @description: 反转字符串
 * @author: yyh
 * @create: 2019-11-02 11:25
 **/
public class Simple_344 {

    /**
     * my result（once pass ；time than 100%） :
     * 利用两个指针，分别指向数组的头尾，然后一次遍历，左右交换
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param s
     */
    private static void reverseString(char[] s) {
        int left = 0;
        int right = s.length -1 ;
        while (left < right){
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }


    public static void main(String[] args) {
        char[] origin = {'H','a','n','n','a','h'};
        System.out.println("origin char arr is : \n"+ Arrays.toString(origin));
        reverseString(origin);
        System.out.println("reverse char arr end ,now char arr is :\n" + Arrays.toString(origin));
    }
}
