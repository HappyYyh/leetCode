package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 * 输入: 3
 * 输出: "III"
 *
 * 示例 2:
 * 输入: 4
 * 输出: "IV"
 *
 * 示例 3:
 * 输入: 9
 * 输出: "IX"
 *
 * 示例 4:
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 *
 * 示例 5:
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * All rights Reserved, Designed By yyh
 * 整数转罗马数字
 * @Package medium
 * @author: yyh
 * @date: 2019-10-15 13:49
 * @since V1.0.0-SNAPSHOT
 */
public class Medium_12 {

    private static Map<Integer, String> getMap(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"I");
        map.put(4,"IV");
        map.put(5,"V");
        map.put(9,"IX");
        map.put(10,"X");
        map.put(40,"XL");
        map.put(50,"L");
        map.put(90,"XC");
        map.put(100,"C");
        map.put(400,"CD");
        map.put(500,"D");
        map.put(900,"CM");
        map.put(1000,"M");
        return map;
    }

    private static int[] intToArr(int num){
        int time = 3;
        int[] arr = new int[time+1];
        while (time >= 0){
            int val = (int)(Math.pow(10,time));
            int yu = num / val ;
            arr[3-time] = yu * val;
            num %= val;
            time -- ;
        }
        return arr;
    }

    /**
     * my result: 把数字拆分成数组，按位存储，之后每一位去匹配罗马数字；
     *            如果匹配则直接添加，不匹配然后判断是否超过5（50，500）,然后按次数追加
     *            时间复杂度：看起来有循环，但是其实都是常数，所以是O(1)
     * @param num
     * @return
     */
    private static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, String> map = getMap();
        int[] arr = intToArr(num);
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] == 0){
                continue;
            }
            if(map.containsKey(arr[i])){
                sb.append(map.get(arr[i]));
            }else {
                //5-50-500-5000
                int fiveMultiple = (int) (5 * (Math.pow(10, arr.length - i -1)));
                //1-10-100-1000
                int oneMultiple = (int) (Math.pow(10, arr.length - i -1));
                //超过5-50-500-5000的追加超过部分的值
                if(arr[i] / fiveMultiple > 0){
                    sb.append(map.get(fiveMultiple));
                    arr[i] %= fiveMultiple;
                }
                //剩余的循环追加
                for(int time = 0 ; time < (arr[i] / oneMultiple) ;time++){
                    sb.append(map.get(oneMultiple));
                }
            }
        }
        return sb.toString();
    }

    /**
     * other:贪心
     * @param num
     * @return
     */
    private static String intToRoman2(int num) {
        // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中
        // 并且按照阿拉伯数字的大小降序排列，这是贪心选择思想
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (index < 13) {
            // 特别注意：这里是等号
            while (num >= nums[index]) {
                // 注意：这里是等于号，表示尽量使用大的"面值"
                stringBuilder.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int num = 3210;
        System.out.println(Arrays.toString(intToArr(num)));
        System.out.println(intToRoman2(num));
    }
}
