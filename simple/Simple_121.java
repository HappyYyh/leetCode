package simple;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 *
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * All rights Reserved, Designed By yyh
 * 买股票的最佳时机
 * @Package simple
 * @author: yyh
 * @date: 2019-09-24 17:05
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_121 {

    /**
     * my result(一次通过）:两次遍历，暴力破解，时间复杂度O（n）
     * @param prices
     * @return
     */
    private static int maxProfit(int[] prices) {
        int max = 0 ;
        for (int i = 0; i < prices.length ; i++) {
            for (int j = i + 1; j < prices.length ; j++) {
                max = Math.max(max,prices[j] - prices[i]);
            }
        }
        return max > 0 ? max : 0;
    }

    /**
     * my result :找到最小的数，然后从最小的开始，返回最大的差值，时间复杂度O（n）
     * @param prices
     * @return
     */
    private static int maxProfit2(int[] prices) {
        if(null == prices || prices.length ==0){
            return 0;
        }
        int start = prices[0] ;
        int max = 0;
        for (int i = 1; i < prices.length ; i++) {
           if(prices[i] < start){
               start = prices[i];
           }else {
               max = Math.max(max,prices[i] - start);
           }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit2(new int[]{7,1,5,3,6,4}));
    }
}
