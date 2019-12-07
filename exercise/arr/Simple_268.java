package exercise.arr;

/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 * 输入: [3,0,1]
 * 输出: 2
 *
 * 示例 2:
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 *
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 *
 * @ClassName: Simple_268
 * @description: 缺失数字
 * @author: yyh
 * @create: 2019-12-07 09:49
 **/
public class Simple_268 {

    /**
     * my result(once pass :time over 94.73%)
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @return
     */
    private static int missingNumber(int[] nums) {
        int[] arr = new int[nums.length + 1];
        // 把每个数组中的元素值放入到arr位置上，表示已存在
        for (int num : nums) {
            arr[num] = 1;
        }
        int ans = -1;
        // 如果为0说明缺失
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] == 0){
                ans = i;
                break;
            }
        }
        return ans;
    }

    /**
     * leetcode :位运算
     * 异或运算（XOR）满足结合律，并且对一个数进行两次完全相同的异或运算会得到原来的数
     * @param nums
     * @return
     */
    private static int missingNumber2(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    /**
     * leetcode : 数学解法
     * 利用高斯公式 n*(n+1) / 2求出所有数字的和，然后求出nums中的和，相减即为缺失的数字
     * 会溢出？
     * @param nums
     * @return
     */
    private static int missingNumber3(int[] nums) {
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }



    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber3(nums));
    }
}
