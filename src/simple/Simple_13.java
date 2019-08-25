package simple;

import java.util.HashMap;
import java.util.Map;

/**
 * �������ְ������������ַ�:?I��?V��?X��?L��C��D?��?M��
 *
 * �ַ�          ��ֵ
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * ���磬 �������� 2 д��II����Ϊ�������е� 1��12 д��XII����ΪX+II�� 27 д��XXVII, ��ΪXX+V+II��
 *
 * ͨ������£�����������С�������ڴ�����ֵ��ұߡ���Ҳ�������������� 4 ��д��IIII������IV��
 * ���� 1 ������ 5 ����ߣ�����ʾ�������ڴ��� 5 ��С�� 1 �õ�����ֵ 4 ��
 * ͬ���أ����� 9 ��ʾΪIX���������Ĺ���ֻ�������������������
 *
 * I���Է���V(5) ��X(10) ����ߣ�����ʾ 4 �� 9��
 * X���Է���L(50) ��C(100) ����ߣ�����ʾ 40 ��90��
 * C���Է���D(500) ��M(1000) ����ߣ�����ʾ400 ��900��
 * ����һ���������֣�����ת��������������ȷ���� 1�� 3999 �ķ�Χ�ڡ�
 *
 * ʾ��1:
 * ����:"III"
 * ���: 3
 *
 * ʾ��2:
 * ����:"IV"
 * ���: 4
 *
 * ʾ��3:
 * ����:"IX"
 * ���: 9
 *
 * ʾ��4:
 * ����:"LVIII"
 * ���: 58
 * ����: L = 50, V= 5, III = 3.
 *
 * ʾ��5:
 * ����:"MCMXCIV"
 * ���: 1994
 * ����: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * @ClassName: Simple_13
 * @description: ��������ת����
 * @author: ���
 * @create: 2019-08-25 11:15
 **/
public class Simple_13 {

    /**
     * my result : �ȱ��������ַ����֣��ڱ���һ���ַ�����
     * @param s
     * @return
     */
    private static int romanToInt(String s) {
        int result = 0;
        //1����������
        for (Special special : Special.values()){
            if(s.contains(special.getKey())){
                result += special.getValue();
                //�Ƴ���һ����
                s = s.replace(special.getKey(),"");
            }
        }
        //2����Ϊȥ��������ź�ֻʣ�µ���������ת��char���飬Ȼ��ƥ��
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
     * ���Ƚ����е���Ͽ������г�����ӵ���ϣ����
     * Ȼ����ַ������б������������ֻ�����֣�һ���� 1 ���ַ���һ���� 2 ���ַ������� 2 ���ַ������� 1 ���ַ�
     * ���ж������ַ�������ڹ�ϣ�����Ƿ���ڣ�������ֵȡ���ӵ���� ans �У��������2���ַ������������жϵ�ǰ
     * 1 ���ַ��Ƿ���ڣ�������ֵȡ���ӵ���� ans �У�������� 1 ���ַ�
     * �����������ؽ�� ans
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
