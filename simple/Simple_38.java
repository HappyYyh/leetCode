package simple;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 *
 * 注意：整数顺序将表示为一个字符串。
 * All rights Reserved, Designed By yyh
 * 报数
 * @Package simple
 * @author: yyh
 * @date: 2019-08-29 17:24
 * @since V1.1.0-SNAPSHOT
 */
public class Simple_38 {

    /**
     * my result:
     * 思路：有多少个重复的就变成 重复数+当前数，比如n=5 111221——》312211（三个1两个2一个1）
     * @param n
     * @return
     */
    private String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        //初始值为11
        String result = "11";
        while (n > 2){
            char[] chars = result.toCharArray();
            StringBuilder sb  = new StringBuilder();
            //统计有多少个重复的值
            int count = 1;
            for (int i = 0; i < chars.length; i++) {
                int j = i + 1;
                if( j < chars.length){
                    if(chars[i] == chars[j]){
                        count++;
                    }else {
                        //遇见不同的把之前的先添加上然后count置为1
                        sb.append(count).append(chars[i]);
                        count = 1;
                    }
                }else {
                    //当j到指针末尾时
                    sb.append(count).append(chars[i]);
                }

            }
            result = sb.toString();
            n--;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Simple_38().countAndSay(8));
    }

}
