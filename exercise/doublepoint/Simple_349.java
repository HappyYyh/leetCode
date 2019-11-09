package exercise.doublepoint;

import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 *
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 *
 * 说明:
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * @ClassName: Simple_349
 * @description: 两个数组的交集
 * @author: yyh
 * @create: 2019-11-09 12:00
 **/
public class Simple_349 {

    /**
     * my result: 暴力法：判断每一种情况
     * 时间复杂度：O(n^2)
     * @param nums1
     * @param nums2
     * @return
     */
    private static int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        for (int value : nums1) {
            for (int i : nums2) {
                if (value == i) {
                    set.add(value);
                }
            }
        }
        int[] res = new int[set.size()];
        int ind = 0;
        for (int val : set) {
            res[ind++] = val;
        }
        return res;
    }

    /**
     * my result: 利用hash表存放nums1，然后遍历nums2，存在则放入set中（空间换时间）
     * 时间复杂度：O(n)
     * @param nums1
     * @param nums2
     * @return
     */
    private static int[] intersection2(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){
            return new int[0];
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int value : nums1){
            map.put(value,map.getOrDefault(value,0)+1);
        }
        Set<Integer> set = new HashSet<>();
        for (int value : nums2){
            Integer exist = map.get(value);
            if(exist != null){
                set.add(value);
            }
        }
        int[] res = new int[set.size()];
        int ind = 0;
        for (int val : set) {
            res[ind++] = val;
        }
        return res;
    }

    /**
     * leetcode : 使用内置函数
     * @param nums1
     * @param nums2
     * @return
     */
    private static int[] intersection3(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1) {
            set1.add(n);
        }
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2) {
            set2.add(n);
        }

        set1.retainAll(set2);

        int [] output = new int[set1.size()];
        int idx = 0;
        for (int s : set1) {
            output[idx++] = s;
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersection2(nums1, nums2)));
    }
}
