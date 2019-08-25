package simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ����һ���������� nums?��һ��Ŀ��ֵ target�������ڸ��������ҳ���ΪĿ��ֵ����?����?���������������ǵ������±ꡣ
 *
 * ����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ��㲻���ظ��������������ͬ����Ԫ�ء�
 *
 * ʾ��:
 *
 * ���� nums = [2, 7, 11, 15], target = 9
 *
 * ��Ϊ nums[0] + nums[1] = 2 + 7 = 9
 * ���Է��� [0, 1]
 * 
 * @ClassName: Simple_1
 * @description: ����֮��
 * @author: ���
 * @create: 2019-08-25 09:54
 **/
public class Simple_1 {

    /**
     * my result :����ѭ������Ѱ��
     * ʱ�临�Ӷȣ�O(n^2)��
     * ����ÿ��Ԫ�أ�������ͼͨ��������������ಿ����Ѱ��������Ӧ��Ŀ��Ԫ�أ��⽫�ķ� O(n)O(n) ��ʱ�䡣
     * ���ʱ�临�Ӷ�Ϊ O(n^2)��
     * �ռ临�Ӷȣ�O(1)��

     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if(nums[i] + nums[j] == target){
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * �������������ϣ��
     * Ϊ�˶�����ʱ�临�ӶȽ����Ż���������Ҫһ�ָ���Ч�ķ���������������Ƿ����Ŀ��Ԫ�ء�������ڣ�������Ҫ�ҳ��������������������е�ÿ��Ԫ�����������໥��Ӧ����÷�����ʲô����ϣ��
     * ͨ���Կռ任ȡ�ٶȵķ�ʽ�����ǿ��Խ�����ʱ��� O(n)O(n) ���͵� O(1)O(1)����ϣ������Ϊ��Ŀ�Ķ������ģ���֧���� ���� �㶨��ʱ����п��ٲ��ҡ����á����ơ�������������Ϊһ�����ֳ�ͻ��������ʱ���ܻ��˻��� O(n)O(n)����ֻҪ����ϸ����ѡ��ϣ�������ڹ�ϣ���н��в��ҵ���ʱӦ����̯��Ϊ O(1)O(1)��
     * һ���򵥵�ʵ��ʹ�������ε������ڵ�һ�ε����У����ǽ�ÿ��Ԫ�ص�ֵ������������ӵ����С�Ȼ���ڵڶ��ε����У����ǽ����ÿ��Ԫ������Ӧ��Ŀ��Ԫ�أ�target - nums[i]target?nums[i]���Ƿ�����ڱ��С�ע�⣬��Ŀ��Ԫ�ز����� nums[i]nums[i] ����
     *
     * ʱ�临�Ӷȣ�O(n)��
     * ���ǰѰ����� nn ��Ԫ�ص��б�������Ρ����ڹ�ϣ������ʱ�����̵� O(1)O(1) ������ʱ�临�Ӷ�Ϊ O(n)O(n)��
     *
     * �ռ临�Ӷȣ�O(n)��
     * ����Ķ���ռ�ȡ���ڹ�ϣ���д洢��Ԫ���������ñ��д洢�� n ��Ԫ�ء�
     *
     */
    private static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * ��ʵ֤�������ǿ���һ����ɡ��ڽ��е�������Ԫ�ز��뵽���е�ͬʱ��
     * ���ǻ���ع�ͷ���������Ƿ��Ѿ����ڵ�ǰԪ������Ӧ��Ŀ��Ԫ�ء�
     * ��������ڣ��������Ѿ��ҵ��˶�Ӧ�⣬���������䷵�ء�
     * ʱ�临�Ӷȣ�O(n)��
     * ����ֻ�����˰����� nn ��Ԫ�ص��б�һ�Ρ��ڱ��н��е�ÿ�β���ֻ���� O(1)��ʱ�䡣
     * �ռ临�Ӷȣ�O(n)��
     * ����Ķ���ռ�ȡ���ڹ�ϣ���д洢��Ԫ���������ñ������Ҫ�洢 nn ��Ԫ�ء�
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }



    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum2(nums, 9)));
    }
}
