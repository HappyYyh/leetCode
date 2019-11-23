package exercise.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 *
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 *
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * @ClassName: Simple_217
 * @description: 存在重复元素
 * @author: yyh
 * @create: 2019-11-23 10:16
 **/
public class Simple_217 {

    /**
     * my result (once pass): 哈希表
     * 时间复杂度 : O(n).search() 和 insert() 各自使用 n 次，每个操作耗费常数时间
     * 空间复杂度 : O(n).哈希表占用的空间与元素数量是线性关系
     * @param nums
     * @return
     */
    private static boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            } else {
                map.put(num, 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,2,3,4};
        System.out.println(containsDuplicate(nums));
    }
}
