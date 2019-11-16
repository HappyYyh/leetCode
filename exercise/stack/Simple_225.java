package exercise.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 *
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 *
 * @ClassName: Simple_225
 * @description: 用队列实现栈
 * @author: yyh
 * @create: 2019-11-16 11:58
 **/
public class Simple_225 {

    private Queue<Integer> queue;
    private int top;

    /** Initialize your data structure here. */
    public Simple_225() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        //将栈顶元素加入到队列尾
        queue.add(x);
        top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        //使用一个临时队列来更新
        Queue<Integer> temp = new LinkedList<>();
        //因为要返回弹出的元素，所以事先保存下来
        int oldTop = top;
        int size = queue.size();
        //循环更新每个元素，执行到最后时栈顶元素也更新了
        for(int i = 0; i < size -1 ; i++){
            top = queue.remove();
            temp.add(top);
        }
        //更新队列（栈）
        queue = temp;
        return oldTop;
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.size() == 0;
    }


    public static void main(String[] args) {
        Simple_225 stack = new Simple_225();
        stack.push(1);
        stack.push(3);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}
