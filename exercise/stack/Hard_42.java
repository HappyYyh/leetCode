package exercise.stack;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * <p>
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * <p>
 * All rights Reserved, Designed By yyh
 * 接雨水
 *
 * @Package exercise.stack
 * @author: yyh
 * @date: 2019-11-26 15:02
 * @since V1.0.0-SNAPSHOT
 */
public class Hard_42 {

    /**
     * other : 双指针
     * 找到最高的位置，然后左右两边分别遍历
     * 左边从最左边开始，并记录左边最大值(aHighSide)，
     * 如果当前值比aHighSide小，则result加上两者之差，否则当前值为左边最大值aHighSide;
     * 右边从最右边开始，算法同理
     *
     * @param height
     * @return
     */
    private static int trap(int[] height) {
        int maxIndex = 0;
        // 找到最高点
        for (int i = 0; i < height.length; i++) {
            if (height[maxIndex] < height[i]) {
                maxIndex = i;
            }
        }
        int result = 0;
        //另一高边
        int aHighSide = 0;
        for (int i = 0; i < maxIndex; i++) {
            if (height[i] > aHighSide) {
                aHighSide = height[i];
            } else {
                result += aHighSide - height[i];
            }
        }
        aHighSide = 0;
        for (int i = height.length - 1; i > maxIndex; i--) {
            if (height[i] > aHighSide) {
                aHighSide = height[i];
            } else {
                result += aHighSide - height[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }
}
