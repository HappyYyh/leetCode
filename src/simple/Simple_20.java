package simple;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * ����һ��ֻ���� '('��')'��'{'��'}'��'['��']'���ַ������ж��ַ����Ƿ���Ч��
 *
 * ��Ч�ַ��������㣺
 *
 * �����ű�������ͬ���͵������űպϡ�
 * �����ű�������ȷ��˳��պϡ�
 * ע����ַ����ɱ���Ϊ����Ч�ַ�����
 *
 * ʾ�� 1:
 * ����: "()"
 * ���: true
 *
 * ʾ��2:
 * ����: "()[]{}"
 * ���: true
 *
 * ʾ��3:
 * ����: "(]"
 * ���: false
 *
 * ʾ��4:
 * ����: "([)]"
 * ���: false
 *
 * ʾ��5:
 * ����: "{[]}"
 * ���: true
 *

 * @ClassName: Simple_20
 * @description: ����ƥ��
 * @author: ���
 * @create: 2019-08-26 21:13
 **/
public class Simple_20 {

    /**
     * ����ִ�д���
     */
    private int methodTime;
    /**
     * ����true�Ĵ���
     */
    private int trueTime;

    /**
     * my result:�ݹ�
     * @param str
     * @return
     */
    private boolean isValid(String str){
        methodTime++;
        if(str.length()==0){
            trueTime++;
            return true;
        }
        if(str.length()%2==0){
            Map<Character,Character> map = new HashMap<>();
            map.put('(',')');
            map.put('{','}');
            map.put('[',']');
            char[] chars = str.toCharArray();
            StringBuilder sb = new StringBuilder(str);
            for (int i = 0; i < chars.length/2; i++) {
                if(map.get(chars[i]) != null) {
                    //������һ��ƥ������������ɾ�����ַ��������еݹ�
                    if (map.get(chars[i]).equals(chars[i + 1])) {
                        sb.delete(i, i + 2);
                        trueTime++;
                        isValid(sb.toString());
                        break;
                    }
                }else {
                    //�����ſ�ͷ��ֱ�ӷ���false
                    return false;
                }
            }
        }
        System.out.println("methodTime:"+methodTime);
        System.out.println("trueTime:"+trueTime);
        return methodTime == trueTime;
    }

    /**
     * ���Ȱ��ַ������������������Ӧ�������Ž�ջ�����������������ŵ�ʱ�򣬾��ж���������Ƿ�͸ս�ջ���ַ�һ����
     * �ڲ���֮ǰ�����ջΪ�գ�˵������ַ�֮ǰ�����Ŷ�����Եģ���������������ţ�����false
     * ���磻����[]){�� ǰ�ĸ��ַ���ԣ������û����Ե�,���Է���false.
     * @param str
     * @return
     */
    private boolean isValid2(String str){
        Stack<Character> stack= new Stack<>();
        for(char c:str.toCharArray()){
            if(c=='('){
                stack.push(')');
            } else if(c=='['){
                stack.push(']');
            }
            else if(c=='{') {
                stack.push('}');
            } else if(stack.isEmpty()||stack.pop()!=c) {
                return false;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println(new Simple_20().isValid2("{[]}"));
    }
}
