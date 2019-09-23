package simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 * 输入: 3
 * 输出: [1,3,3,1]
 *
 * 进阶：
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 *
 * All rights Reserved, Designed By yyh
 * 杨辉三角Ⅱ
 * @Package simple
 * @author: yyh
 * @date: 2019-09-23 15:27
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_119 {

    /**
     * my result: 和simple118一致，空间复杂度比较高
     * @param rowIndex
     * @return
     */
    private static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        //添加第一个
        List<Integer> list = new ArrayList<>();
        list.add(1);
        if(rowIndex == 0){
            return list;
        }
        result.add(list);
        for (int i = 1; i <= rowIndex ; i++) {
            //获取上一个list
            List<Integer> last = result.get(i - 1);
            //当前的list
            List<Integer> now = new ArrayList<>();
            now.add(1);
            for (int j = 1; j < last.size() ; j++) {
                now.add(last.get(j-1) + last.get(j));
            }
            now.add(1);
            result.add(now);
        }
        return result.get(rowIndex);
    }

    private static List<Integer> getRow2(int rowIndex) {
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                //
                cur.set(j, cur.get(j - 1) + cur.get(j));
            }
            //补上每层的最后一个 1
            cur.add(1);
        }
        return cur;
    }

    /**
     * 公式法
     * @param rowIndex
     * @return
     */
    private List<Integer> getRow3(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        int N = rowIndex;
        long pre = 1;
        ans.add(1);
        for (int k = 1; k <= N; k++) {
            long cur = pre * (N - k + 1) / k;
            ans.add((int) cur);
            pre = cur;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(getRow2(4));
    }
}
