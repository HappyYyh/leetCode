package exercise.doublepoint;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。-2 -1 0 0 1 2
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * <p>
 * All rights Reserved, Designed By yyh
 * 四数之和
 *
 * @Package exercise.doublepoint
 * @author: yyh
 * @date: 2019-11-12 12:18
 * @since V1.0.0-SNAPSHOT
 */
public class Medium_18 {

    /**
     * other：差一点点搞定
     * @param nums
     * @param target
     * @return
     */
    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        if (len < 4) {
            return result;
        }
        for (int i = 0; i < len - 3; ++i) {
            if (nums[i] > target / 4) {
                //最小的数都大于target的1/4，后面的不用看了
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
                //去重
            }
            for (int j = i + 1; j < len - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    //去重
                    continue;
                }
                int low = j + 1;
                int high = len - 1;
                while (low < high) {
                    if (nums[high] < target / 4) {
                        //最大的都小于targer的1/4，后面的不用看了
                        break;
                    }
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) {
                            ++low;//跳过相同的值
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            --high;//跳过相同的值
                        }
                        ++low;
                        --high;
                    } else if (sum < target) {
                        //和小于目标值，low增大，使和增大
                        while (low < high && nums[low] == nums[low + 1]){
                            ++low;
                        }
                        ++low;
                    } else {//和大于目标值，high减小，使值减小
                        while (low < high && nums[high] == nums[high - 1]) {
                            --high;
                        }
                        --high;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
