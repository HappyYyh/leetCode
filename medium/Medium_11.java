package medium;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例:
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 * All rights Reserved, Designed By yyh
 * 盛最多水的容器
 * @Package medium
 * @author: yyh
 * @date: 2019-10-09 16:48
 * @since V1.0.0-SNAPSHOT
 */
public class Medium_11 {

    /**
     * myResult:once pass 暴力破解，查找出所有的大小，时间复杂度O(n^2)
     * @param height
     * @return
     */
    private static int maxArea(int[] height) {
        int area = 0;
        for (int i = 0; i < height.length ; i++) {
            for (int j = i + 1; j < height.length ; j++) {
                area = Math.max(area,(j-i)*Math.min(height[i],height[j]));
            }
        }
        return area;
    }

    /**
     * 我们在由线段长度构成的数组中使用两个指针，一个放在开始，一个置于末尾。
     * 此外，我们会使用变量 maxarea来持续存储到目前为止所获得的最大面积。
     * 在每一步中，我们会找出指针所指向的两条线段形成的区域，更新 maxarea，并将指向较短线段的指针向较长线段那端移动一步。
     * 时间复杂度：O(n)，一次扫描。
     * 空间复杂度：O(1)，使用恒定的空间。
     * leetcode：双指针法
     * @param height
     * @return
     */
    private static int maxArea2(int[] height) {
        int maxArea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }


    public static void main(String[] args) {
        System.out.println(maxArea2(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
