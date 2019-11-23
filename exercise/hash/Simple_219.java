package exercise.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，
 * 并且 i 和 j 的差的绝对值最大为 k。
 *
 * 示例 1:
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 *
 * 示例 2:
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 *
 * 示例 3:
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 *
 * @ClassName: Simple_219
 * @description: 存在重复元素 II
 * @author: yyh
 * @create: 2019-11-23 10:37
 **/
public class Simple_219 {

    /**
     * my result:线性查找，双层for循环
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param nums
     * @param k
     * @return
     */
    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i + 1; j < nums.length ; j++) {
                if(nums[i] == nums[j] && (j<=k+i)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * my result(once pass,time over95.47%):哈希表
     * 时间复杂度：O(n)
     * 空间复杂度: O(n)
     * @param nums
     * @param k
     * @return
     */
    private static boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            if(map.containsKey(nums[i])){
                // 如果存在相同则计算索引差值
                int mix = i - map.get(nums[i]);
                if(mix <= k){
                    return true;
                }else {
                    // 大于k则更新map里的位置，如果后续还有重复则会接着判断
                    map.put(nums[i],i);
                }
            }else {
                map.put(nums[i],i);
            }
        }
        return false;
    }

    /**
     * leetcode :set
     * 时间复杂度：O(n)。我们会做 nn 次 搜索，删除，插入 操作，每次操作都耗费常数时间。
     * 空间复杂度：O(min(n,k))开辟的额外空间取决于散列表中存储的元素的个数，也就是滑动窗口的大小 O(min(n,k))。
     *
     * @param nums
     * @param k
     * @return
     */
    private static boolean containsNearbyDuplicate3(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate3(new int[]{1,2,3,1},3));
        System.out.println(containsNearbyDuplicate2(new int[]{1,0,1,1},1));
        System.out.println(containsNearbyDuplicate2(new int[]{1,2,3,1,2,3},2));
    }
}
