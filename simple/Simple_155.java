package simple;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * @ClassName: Simple_155
 * @description: 最小栈
 * @author: yyh
 * @create: 2019-10-11 20:24
 **/
public class Simple_155 {

    /**
     * myResult：利用LinkedList，不过getMin用了遍历时间复杂度肯定是O（n）
     */


    /**
     * 利用辅助stack，同步进行操作，help里面只存放最小的数,以空间换时间，时间复杂度O(1)
     */
    Stack<Integer> data;
    Stack<Integer> help;

    private Simple_155() {
        data = new Stack<>();
        help = new Stack<>();
    }

    private void push(int x) {
        data.push(x);
        if (help.isEmpty()) {
            help.add(x);
        } else {
            if(x <= help.peek()){
                help.add(x);
            }else {
                //如果当前元素比栈内的元素大，则添加栈内最小的元素
                help.add(help.peek());
            }
        }

    }

    private void pop() {
        data.pop();
        help.pop();
    }

    private int top() {
        return data.peek();
    }

    private int getMin() {
        return help.peek();
    }

    public static void main(String[] args) {
        Simple_155 obj = new Simple_155();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }
}


