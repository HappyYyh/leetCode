package exercise.doublepoint;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。
 * 这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.
 *
 * 示例 1:
 * 输入: [3, 1, 4, 1, 5], k = 2
 * 输出: 2
 * 解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
 *
 * 示例 2:
 * 输入:[1, 2, 3, 4, 5], k = 1
 * 输出: 4
 * 解释: 数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
 *
 * 示例 3:
 * 输入: [1, 3, 1, 5, 4], k = 0
 * 输出: 1
 * 解释: 数组中只有一个 0-diff 数对，(1, 1)。
 * 注意:
 *
 * 数对 (i, j) 和数对 (j, i) 被算作同一数对。
 * 数组的长度不超过10,000。
 * 所有输入的整数的范围在 [-1e7, 1e7]。
 *

 * @ClassName: Simple_532
 * @description: 数组中的K-diff数对
 * @author: yyh
 * @create: 2019-11-14 20:42
 **/
public class Simple_532 {

    /**
     * my result: 双层循环，
     * @param nums
     * @param k
     * @return
     */
    private static int findPairs(int[] nums, int k) {
        int count = 0;
        Arrays.sort(nums);
        // 利用这个值判断是否已经存在（由于给出的数有范围限制），一开始使用0作为记录，发现当数组里数为0会有问题
        int exist = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1 ; i++) {
            for (int j = i + 1; j < nums.length ; j++) {
                int mix = nums[j] - nums[i];
                if(mix > k){
                    break;
                }
                if(mix == k && exist != nums[i]){
                    exist = nums[i];
                    count++;
                    // 遇到符合结果时推出，因为后面的要么重复要么大
                    break;
                }
            }
        }
        return count;
    }

    /**
     * other，本来我也是这么写的但是判断条件是利用  nums[i] == nums[i + 1]然后不行，早知道就试试减法了
     * @param nums
     * @param k
     * @return
     */
    private static int findPairs2(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i =0; i < nums.length;i++){
            if(i > 0 && nums[i] == nums[i -1]) {
                continue;
            }
            for(int j = i +1 ;j < nums.length;j++){
                if(Math.abs(nums[i] - nums[j]) == k){
                    sum ++;
                    break;
                }
            }
        }
        return sum;
    }

    /**
     * hash表
     * @param nums
     * @param k
     * @return
     */
    private static int findPairs3(int[] nums, int k){
        int sum = 0;
        HashMap<Integer , Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        for(int i: hashMap.keySet()){
            // 如果为0说明只要有重复即可，即value > 1
            if(k == 0){
                if(hashMap.get(i) > 1) {
                    sum ++;
                }
            }else{
                if(hashMap.containsKey(i + k)){
                    sum++;
                }
            }
        }

        return sum;

    }

    public static void main(String[] args) {
        int[] nums = {0,0,0};
        System.out.println(findPairs2(nums,0));
    }
}
