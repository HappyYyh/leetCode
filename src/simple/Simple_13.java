package simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符:I，V，X，L，C，D和M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 *
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1到 3999 的范围内。
 *
 * 示例1:
 * 输入:"III"
 * 输出: 3
 *
 * 示例2:
 * 输入:"IV"
 * 输出: 4
 *
 * 示例3:
 * 输入:"IX"
 * 输出: 9
 *
 * 示例4:
 * 输入:"LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 *
 * 示例5:
 * 输入:"MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * @ClassName: Simple_13
 * @description: 罗马数字转整数
 * @author: 昊天
 * @create: 2019-08-25 11:15
 **/
public class Simple_13 {

    /**
     * my result : 先遍历两个字符部分，在遍历一个字符部分
     * @param s
     * @return
     */
    private static int romanToInt(String s) {
        int result = 0;
        //1、遍历特殊
        for (Special special : Special.values()){
            if(s.contains(special.getKey())){
                result += special.getValue();
                //移除这一部分
                s = s.replace(special.getKey(),"");
            }
        }
        //2、因为去掉特殊符号后只剩下单个，所以转成char数组，然后匹配
        char[] chars = s.toCharArray();
        for (char c :chars){
            for (Common common :Common.values()){
                if(common.getKey().equals(String.valueOf(c))){
                    result += common.getValue();
                }
            }
        }
        return result;
    }

    /**
     * 首先将所有的组合可能性列出并添加到哈希表中
     * 然后对字符串进行遍历，由于组合只有两种，一种是 1 个字符，一种是 2 个字符，其中 2 个字符优先于 1 个字符
     * 先判断两个字符的组合在哈希表中是否存在，存在则将值取出加到结果 ans 中，并向后移2个字符。不存在则将判断当前
     * 1 个字符是否存在，存在则将值取出加到结果 ans 中，并向后移 1 个字符
     * 遍历结束返回结果 ans
     *
     * @param s
     * @return
     */
    private static int romanToInt2(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int ans = 0;
        for(int i = 0;i < s.length();) {
            if(i + 1 < s.length() && map.containsKey(s.substring(i, i+2))) {
                ans += map.get(s.substring(i, i+2));
                i += 2;
            } else {
                ans += map.get(s.substring(i, i+1));
                i ++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(romanToInt2("MCDLXXVI"));
    }

    private enum Common {
        I("I",1),
        V("V",5),
        X("X",10),
        L("L",50),
        C("C",100),
        D("D",500),
        M("M",1000),

        ;
        private String key;
        private int value;

        Common(String key, int value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }

    private enum Special {
        IV("IV",4),
        IX("IX",9),
        XL("XL",40),
        XC("XC",90),
        CD("CD",400),
        CM("CM",900),

        ;
        private String key;
        private int value;

        Special(String key, int value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }

}
