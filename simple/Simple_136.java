package simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * All rights Reserved, Designed By yyh
 * 只出现一次的数字
 * @Package simple
 * @author: yyh
 * @date: 2019-09-29 16:56
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_136 {

    /**
     * my result:时间复杂度O(n*n)，空间复杂度O(n)
     * @param nums
     * @return
     */
    private static int singleNumber(int[] nums) {
        if(null == nums || nums.length == 0){
            return 0;
        }
        Map<Integer,Boolean> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            map.put(i,true);
            for (int j = 0; j <nums.length ; j++) {
                if(i != j && nums[i] == nums[j]){
                    map.put(i,false);
                    break;
                }
            }
        }
        for (Map.Entry<Integer,Boolean> m : map.entrySet()){
            if(m.getValue()){
                return nums[m.getKey()];
            }
        }
        return nums[0];
    }

    /**
     * hash表优化：时间复杂度O(n)，空间复杂度O(n)
     * @param nums
     * @return
     */
    private static int singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            Integer count = map.get(i);
            count = count == null ? 1 : ++count;
            map.put(i, count);
        }
        for (Integer i : map.keySet()) {
            Integer count = map.get(i);
            if (count == 1) {
                return i;
            }
        }
        // can't find it.
        return -1;
    }

    /**
     * 使用快排，复杂度 O(nlogn)
     * @param nums
     * @return
     */
    private static int singleNumber3(int[] nums) {

        return 0;
    }

    /**
     * 最快方法：异或，时间复杂度O(n)，空间复杂度O(1)
     * @param nums
     * @return
     */
    private static int singleNumber4(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(singleNumber4(new int[]{4,2,1,4,2}));
    }
}
