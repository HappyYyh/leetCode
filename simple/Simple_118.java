package simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * @ClassName: Simple_118
 * @description: 杨辉三角
 * @author: yyh
 * @create: 2019-09-22 08:53
 **/
public class Simple_118 {

    /**
     * myresult：equals leetcode ，动态规划，根据上一行直接生成下一行的内容（首尾为1）
     * @param numRows
     * @return
     */
    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0){
            return result;
        }
        //添加第一个
        List<Integer> list = new ArrayList<>();
        list.add(1);
        result.add(list);
        for (int i = 1; i < numRows ; i++) {
            //获取上一个list
            List<Integer> last = result.get(i - 1);
            //当前的list
            List<Integer> now = new ArrayList<>();
            now.add(1);
            for (int j = 0; j < last.size() -1 ; j++) {
                now.add(last.get(j) + last.get(j + 1));
            }
            now.add(1);
            result.add(now);
        }
        return result;
    }


    public static void main(String[] args) {
        List<List<Integer>> generate = generate(6);
        for (List<Integer> first : generate){
            for (Integer num : first){
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }
}
