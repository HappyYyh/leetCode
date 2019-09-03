package simple;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * All rights Reserved, Designed By yyh
 * 二进制求和
 * @Package simple
 * @author: yyh
 * @date: 2019-09-03 10:48
 * @since V1.1.0-SNAPSHOT
 */
public class Simple_67 {

    /**
     * 先把长度短的添加0，然后逐位相加
     * @param a
     * @param b
     * @return
     */
    private static String addBinary(String a, String b) {
        int len =Math.max(a.length(),b.length());
        if(a.length() > b.length()){
            b = addZero(a.length(),b.length()) + b;
        }else {
            a = addZero(b.length(),a.length()) + a;
        }
        StringBuilder sb = new StringBuilder();
        //是否进位
        int j = 0;
        for (int i = len - 1; i >= 0 ; i--) {
            //两数相加以及进位的值
            int sum = Integer.parseInt(String.valueOf(a.charAt(i))) + Integer.parseInt(String.valueOf(b.charAt(i))) + j;
            int value;
            if(sum == 3){
                j = 1;
                value = 1;
            }else if(sum == 2){
                j = 1;
                value = 0;
            }else {
                j = 0;
                value = sum;
            }
            sb.append(value);
        }
        //如果需要进位则添加上
        if(j == 1){
            sb.append(j);
        }
        return sb.reverse().toString();
    }

    /**
     * 添加0
     * @param big
     * @param small
     * @return
     */
    private static String addZero(int big,int small){
        int mix = big -small;
        StringBuilder sb = new StringBuilder();
        while (mix > 0){
            sb.append("0");
            mix--;
        }
        return sb.toString();
    }

    /**
     * 更加的灵活，直接在for循环中判断长度是否一致
     * @param a
     * @param b
     * @return
     */
    private String addBinary2(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for(int i = a.length() - 1, j = b.length() - 1;i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            // 判断j>=0的含义是有可能两个数字长度不一致，如果j<0的话则将其当做0来处理，否则获取其值，也就是 b.charAt(j) - '0'
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            // sum%2是在做二进制取模运算，比如sum=2，这时候将sum%2=0放入结果集中
            ans.append(sum % 2);
            // 这里是计算进位，比如sum=2，ca = 1，ca表示进位的意思，满2进1
            ca = sum / 2;
        }
        //这一步表示是不是最后还有进位，比如1+1 = 10，10前面的1就是最后留存的进位，需要将其放进去
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(addBinary("1010","1011"));
    }
}
