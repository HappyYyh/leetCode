package exercise.stack;

import java.util.Stack;

/**
 * 使用栈实现队列的下列操作：
 *
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * 示例:
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 * 说明:
 *
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 *
 * @ClassName: Simple_232
 * @description: 用栈实现队列
 * @author: yyh
 * @create: 2019-11-16 13:05
 **/
public class Simple_232 {

    private Stack<Integer> stack;
    private int top;

    /** Initialize your data structure here. */
    public Simple_232() {
        stack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        Stack<Integer> tmp = new Stack<>();
        top = stack.get(0);
        for (int i = 1; i < stack.size() ; i++) {
            tmp.push(stack.get(i));
        }
        stack = tmp;
        return top;
    }

    /** Get the front element. */
    public int peek() {
        return stack.get(0);
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        Simple_232 queue = new Simple_232();
        queue.push(1);
        queue.push(3);
        queue.push(5);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
        System.out.println(queue.peek());
    }
}
