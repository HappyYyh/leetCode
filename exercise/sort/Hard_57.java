package exercise.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * 示例 1:
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 *
 * 示例 2:
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 * All rights Reserved, Designed By yyh
 * 插入区间
 * @Package exercise.sort
 * @author: yyh
 * @date: 2019-12-27 14:24
 * @since V1.0.0-SNAPSHOT
 */
public class Hard_57 {

    private static class Interval {
        int start;
        int end;
        Interval(int[] interval) {
            this.start = interval[0];
            this.end = interval[1];
        }

        int[] toArray() {
            return new int[]{this.start, this.end};
        }
    }

    /**
     * my result : 只需要把新的数组插入到原先排序好的数组中，然后 进行合并，合并直接复用Medium_56
     * @param intervals
     * @param newInterval
     * @return
     */
    private static int[][] insert(int[][] intervals, int[] newInterval) {
        List<Interval> intervalsList = new LinkedList<>();
        boolean add = false;
        for (int[] interval : intervals) {
            if(interval[0] > newInterval[0]){
                if(!add) {
                    intervalsList.add(new Interval(newInterval));
                    add = true;
                }
            }
            intervalsList.add(new Interval(interval));
        }
        // 如果没有添加过，则直接加载末尾
        if(!add){
            intervalsList.add(new Interval(newInterval));
        }

        LinkedList<Interval> merged = new LinkedList<>();
        for (Interval interval : intervalsList) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        int i = 0;
        int[][] result = new int[merged.size()][2];
        for (Interval mergedInterval : merged) {
            result[i] = mergedInterval.toArray();
            i++;
        }
        return result;
    }

    /**
     * my result (once pass ,time over 82.65%):先把新增的区间放入到原先的区间中，然后进行一次冒泡
     * 时间复杂度：O(n)
     * 空间复杂度：O(n + m)，m是结果的长度
     * @param intervals
     * @param newInterval
     * @return
     */
    private static int[][] insert2(int[][] intervals, int[] newInterval) {
        int[][] addArr = new int[intervals.length + 1][2];
        boolean add = false;
        int addIndex = 0;
        // 添加新增的区间
        for (int[] interval : intervals) {
            if(interval[0] > newInterval[0]){
                if(!add) {
                    add = true;
                    addArr[addIndex++] = newInterval;
                }
            }
            addArr[addIndex++] = interval;
        }
        if(!add){
            addArr[addArr.length-1] = newInterval;
        }
        //
        int mergeCount = 0;
        for (int i = 0; i < addArr.length - 1 ; i++) {
            if(addArr[i][1] >= addArr[i + 1][0]){
                addArr[i + 1][0] = addArr[i][0];
                addArr[i + 1][1] = Math.max(addArr[i][1],addArr[i + 1][1]);
                addArr[i] = null;
                mergeCount++;
            }
        }
        int[][] res = new int[addArr.length - mergeCount][];
        int resIndex = 0;
        for (int[] ints : addArr){
            if(ints != null){
                res[resIndex++] = ints;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {};
        int[][] merge = insert(intervals,new int[]{2,5});
        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }
//        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
//        int[][] merge = insert2(intervals,new int[]{4,8});
//        for (int[] ints : merge) {
//            System.out.println(Arrays.toString(ints));
//        }
    }

}
