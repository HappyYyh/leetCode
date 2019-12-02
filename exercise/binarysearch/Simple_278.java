package exercise.binarysearch;

/**
 * 你是产品经理，目前正在带领一个团队开发新的产品。
 * 不幸的是，你的产品的最新版本没有通过质量检测。
 * 由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 *
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 *
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。
 * 实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 * 示例:
 * 给定 n = 5，并且 version = 4 是第一个错误的版本。
 *
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 *
 * 所以，4 是第一个错误的版本。 
 *
 * All rights Reserved, Designed By yyh
 * 第一个错误的版本
 * @Package exercise.binarySearch
 * @author: yyh
 * @date: 2019-12-02 14:10
 * @since V1.0.0-SNAPSHOT
 */
public class Simple_278 {

    /**
     * 这个定义在父类中
     * @param version
     * @return
     */
    private static boolean isBadVersion(int version){
        // mock

        return version > 1702766719;
    }

    /**
     * my result : 线性查找，超时
     * @param n
     * @return
     */
    private static int firstBadVersion(int n) {
        for (int i = 1; i < n; i++) {
            if (isBadVersion(i)) {
                return i;
            }
        }
        return n;
    }

    private static int firstBadVersion2(int n) {
        return binarySearch(1,n);
    }

    /**
     * my result(半参照leetcode) :二分查找，注意mid会越界
     * @param left
     * @param right
     * @return
     */
    private static int binarySearch(int left,int right){
        if(left == right){
            return left;
        }
        // int mid = (left + right) / 2;
        int mid = left + (right - left) / 2;
        if(isBadVersion(mid)){
            return binarySearch(1,mid);
        }else {
            return binarySearch(mid + 1 ,right);
        }
    }

    /**
     * leetcode :二分查找
     * @param n
     * @return
     */
    private static int firstBadVersion3(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        System.out.println(firstBadVersion2(2126753390));
    }
}

