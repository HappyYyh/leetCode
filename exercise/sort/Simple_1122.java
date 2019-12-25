package exercise.sort;

import java.util.Arrays;

/**
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
 * 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 * 示例：
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *  
 *
 * 提示：
 *
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 *
 * All rights Reserved, Designed By yyh
 * 数组的相对排序
 * @Package exercise.sort
 * @author: yyh
 * @date: 2019-12-25 15:17
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_1122 {

    /**
     * my result (once pass,time over 100%)
     * 1、利用hash表把arr1的数组存储起来，值为数组下标，次数为hash表的值；
     * 2、遍历arr2，把tmp数组中的元素放入到结果中
     * 3、遍历tmp，不为0的代表未出现在arr2中的数字，依次放入结果中
     * 时间复杂度：O(n)
     * 空间复杂度：O(1001 + n) (可以用arr1代替nums，节省空间)
     * @param arr1
     * @param arr2
     * @return
     */
    private static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] nums = new int[arr1.length];
        int[] tmp = new int[1001];
        // hash表
        for (int num : arr1){
            tmp[num] ++;
        }
        int index = 0;
        // 放入出现的元素
        for (int num : arr2){
            for (int i = index; i < index + tmp[num] ; i++) {
                nums[i] = num;
            }
            index += tmp[num];
            tmp[num] = 0;
        }
        // 剩余的未出现在arr2中的元素
        for (int i = 0; i < tmp.length ; i++) {
            if(tmp[i] != 0){
                for (int j = index; j < index + tmp[i] ; j++) {
                    nums[j] = i;
                }
                index += tmp[i];
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        System.out.println(Arrays.toString(relativeSortArray(arr1,arr2)));
    }
}
