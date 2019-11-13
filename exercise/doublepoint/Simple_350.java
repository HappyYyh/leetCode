package exercise.doublepoint;

import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 *
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 *
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 *
 * 进阶:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * All rights Reserved, Designed By yyh
 * 两个数组的交集Ⅱ
 * @Package exercise.doublepoint
 * @author: yyh
 * @date: 2019-11-13 15:21
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_350 {

    /**
     * my result：利用hashMap
     * @param nums1
     * @param nums2
     * @return
     */
    private static int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){
            return new int[0];
        }
        if(nums1.length > nums2.length){
            return intersection(nums2,nums1);
        }else {
            return intersection(nums1,nums2);
        }

    }

    /**
     * nums1.length <= num2s.length
     * @param nums1
     * @param nums2
     * @return
     */
    private static int[] intersection(int[] nums1, int[] nums2){
        Map<Integer,Integer> map = new HashMap<>();
        for (int value : nums2){
            map.put(value,map.getOrDefault(value,0)+1);
        }
        List<Integer> list =new ArrayList<>();
        for(int num1 : nums1){
            Integer exist = map.get(num1);
            if(exist != null && exist > 0){
                list.add(num1);
                map.put(num1,exist-1);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * other : 排序好，利用双指针
     * 1、如果nums1[p1] == nums2[p2]，说明俩数组中都有这个数，是其交集，所以将它丢入list中。
     * 2、如果不等，则移动小的那个指针。
     * 时间复杂度为O(nlogn)，
     * 空间复杂度为O(1)
     * @param nums1
     * @param nums2
     * @return
     */
    private static int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while(p1 < nums1.length && p2 < nums2.length) {
            if(nums1[p1] < nums2[p2]) {
                p1++;
            }
            else if(nums1[p1] > nums2[p2]){
                p2++;
            }
            else {
                list.add(nums1[p1]);
                p1++;
                p2++;
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = list.get(i);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums1 = {1,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(intersect2(nums1, nums2)));
    }
}
