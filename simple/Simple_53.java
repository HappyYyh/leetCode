package simple;

/**
 * ����һ���������� nums���ҵ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�
 *
 * ʾ��:
 * ����: [-2,1,-3,4,-1,2,1,-5,4],
 * ���: 6
 *
 * ����:����������[4,-1,2,1] �ĺ����Ϊ6��
 * ����:
 *
 * ������Ѿ�ʵ�ָ��Ӷ�Ϊ O(n) �Ľⷨ������ʹ�ø�Ϊ����ķ��η���⡣
 *
 * @ClassName: Simple_53
 * @description: ��������
 * @author: ���
 * @create: 2019-08-31 10:27
 **/
public class Simple_53 {

    /**
     * ������ö�̬�滮��˼·�����ѽ�����Ƚ��ѵ��Ǻ���������÷��η���⣬�������䲻�����Žⷨ�������Ȳ��г���
     * ��̬�滮�������ȶ�������б�������ǰ������������к�Ϊ sum�����Ϊ ans
     * ��� sum > 0����˵�� sum �Խ��������Ч������ sum ���������ϵ�ǰ��������
     * ��� sum <= 0����˵�� sum �Խ��������Ч������Ҫ�������� sum ֱ�Ӹ���Ϊ��ǰ��������
     * ÿ�αȽ� sum �� ans�Ĵ�С�������ֵ��Ϊans�������������ؽ��
     * ʱ�临�Ӷȣ�O(n)
     *
     * @param nums
     * @return
     */
    private static int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        // ���nums[i] + nums[i-1] ��С�ˣ�����Ҫǰһ�����֣�ֱ�Ӵ�nums[i]��ʼ
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
