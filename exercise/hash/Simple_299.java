package exercise.hash;


/**
 * 你正在和你的朋友玩 猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。
 * 每次他猜测后，你给他一个提示，告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），
 * 有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。你的朋友将会根据提示继续猜，直到猜出秘密数字。
 * <p>
 * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。
 * 请注意秘密数字和朋友的猜测数都可能含有重复数字。
 * <p>
 * 示例 1:
 * 输入: secret = "1807", guess = "7810"
 * 输出: "1A3B"
 * 解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
 * <p>
 * 示例 2:
 * 输入: secret = "1123", guess = "0111"
 * 输出: "1A1B"
 * 解释: 朋友猜测数中的第一个 1 是公牛，第二个或第三个 1 可被视为奶牛。
 * <p>
 * 说明: 你可以假设秘密数字和朋友的猜测数都只包含数字，并且它们的长度永远相等。
 *
 * @ClassName: Simple_299
 * @description: 猜数字游戏
 * @author: yyh
 * @create: 2019-11-30 18:31
 **/
public class Simple_299 {

    /**
     * my result(once pass, time over 91.55%)
     * 由于字符串中每一个字符都是数字，所以可以利用两个大小为10的数组来记录每个数出现的次数
     * 当这个同时不为0时，得出cows应该加的值
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param secret
     * @param guess
     * @return
     */
    private static String getHint(String secret, String guess) {
        int[] secretArr = new int[10];
        int[] guessArr = new int[10];
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                secretArr[secret.charAt(i) - '0'] += 1;
                guessArr[guess.charAt(i) - '0'] += 1;
            }
        }
        for (int i = 0; i < secretArr.length; i++) {
            if (secretArr[i] != 0 && guessArr[i] != 0) {
                //cows += guessArr[i] > secretArr[i] ? secretArr[i] : guessArr[i];
                cows += Math.min(guessArr[i],secretArr[i]);
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        System.out.println(getHint("1807", "7810"));
        System.out.println(getHint("1123", "0111"));
    }
}
