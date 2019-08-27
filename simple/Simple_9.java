package simple;

/**
 * @ClassName: Simple_9
 * @description: 回文数
 * @author: 昊天
 * @create: 2019-08-25 10:21
 **/
public class Simple_9 {

    /**
     * my:利用stringBuilder.reverse方法，其内部用的是就是方法二
     * @param x
     * @return
     */
    private static boolean isPalindrome(int x) {
        String str = Integer.toString(x) ;
        StringBuilder reverse = new StringBuilder(str).reverse();
        return str.equals(reverse.toString());
    }

    /**
     * my : string转char数组，拼接然后对比
     * @param x
     * @return
     */
    private static boolean isPalindrome2(int x) {
        String str = Integer.toString(x) ;
        char[] chars = str.toCharArray();
        StringBuilder reverse = new StringBuilder();
        for (int i = chars.length-1; i >=0 ; i--) {
            reverse.append(chars[i]);
        }
        return str.equals(reverse.toString());
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome2(123211));
    }
}
