package simple;

/**
 * ����һ����������Сд��ĸ�Ϳո�' '���ַ��������������һ�����ʵĳ��ȡ�
 * ������������һ�����ʣ��뷵�� 0��
 * ˵����һ��������ָ����ĸ��ɣ����������κοո���ַ�����
 *
 * ʾ��:
 * ����: "Hello World"
 * ���: 5
 *
 * @ClassName: Simple_58
 * @description: ���һ�����ʵĳ���
 * @author: yyh
 * @create: 2019-09-01 09:32
 **/
public class Simple_58 {

    /**
     * my result : ����string��split�������Ƚ�͵��
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
     * �ο�
     * @param s
     * @return
     */
    private static int lengthOfLastWord2(String s) {
        if(s != null && s.trim().length() > 0) {
           int end = s.length() -1 ;
           //�����ո���˵����ҵ���һ�����ǿո����ĸ
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
