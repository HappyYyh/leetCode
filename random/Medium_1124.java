package random;

import java.util.Stack;

/**
 * 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 * 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 * 请你返回「表现良好时间段」的最大长度。
 *
 * 示例 1：
 * 输入：hours = [9,9,6,0,6,6,9]
 * 输出：3
 * 解释：最长的表现良好时间段是 [9,9,6]。
 *
 * 提示：
 * 1 <= hours.length <= 10000
 * 0 <= hours[i] <= 16
 *
 * @ClassName: Medium_1124
 * @description: 表现良好的最长时间段
 * @author: yyh
 * @create: 2020-04-05 12:21
 **/
public class Medium_1124 {

    /**
     * my result(once pass time pass : 6.96%) : 两层循环（时间复杂度太高）
     *
     * @param hours
     * @return
     */
    private static int longestWPI(int[] hours) {
        if(hours.length == 0){
            return 0;
        }
        int max = 0;
        for (int i = 0; i < hours.length ; i++) {
            int count = 0 ;
            int tmpMax = 0;
            for (int j = i; j < hours.length ; j++) {
                count += hours[j] > 8 ? 1 : -1;
                if(count > 0){
                    // 最大连续天数
                    tmpMax = j-i + 1;
                }
            }
            max = Math.max(max,tmpMax);
        }
        return max;
    }

    /**
     * 这题不是更优解，相反复杂度很高，但是把问题给简化了，是当时做题的思路
     * @param hours
     * @return
     */
    private static int longestWPI2(int[] hours) {
        if(hours.length == 0){
            return 0;
        }
        for (int i = 0; i < hours.length ; i++) {
            hours[i] = hours[i] > 8 ? 1 : -1;
        }
        // 问题可以简化成 ：从类似 {1 1 -1 -1 -1 -1 1}找出连续和 > 0 的最大跨度
        int max = 0;
        for (int i = 0; i < hours.length ; i++) {
            int sum = hours[i];
            for (int j = i + 1; j < hours.length; j++) {
                sum += hours[j];
                if(sum > 0){
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    /**
     * other:单调栈
     * @param hours
     * @return
     */
    private static int longestWPI3(int[] hours) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        int[] prefixSrc = new int[hours.length + 1];
        //大于8的置为1，否则置为-1
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8) {
                max = 1;
                hours[i] = 1;
            } else {
                hours[i] = -1;
            }
            //初始化前缀和数组
            prefixSrc[0] = 0;
            prefixSrc[i + 1] = prefixSrc[i] + hours[i];
        }
        for (int i = 0; i < prefixSrc.length - 1; i++) {
            //实现单调栈
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                if (prefixSrc[i] < prefixSrc[stack.peek()]) {
                    stack.push(i);
                }
            }
        }
        //开始寻找,从后往前遍历
        for (int i = prefixSrc.length - 1; i >= 0; i--) {
            int last = i;
            while (!stack.isEmpty() && prefixSrc[i] > prefixSrc[stack.peek()]) {
                last = stack.pop();
            }
            if (last != i) {
                int width = i - last;
                max = Math.max(max, width);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] hours = {9,9,6,0,6,6,9};
        System.out.println(longestWPI3(hours));
    }
}
