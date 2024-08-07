package Stack;

import java.util.Stack;

/**
 * @author : Kunal Sharma
 * @since : 03/08/24, Saturday
 **/
class MyQueue {

    Stack<Integer> input;
    Stack<Integer> output;

    public MyQueue() {
        input = new Stack<Integer>();
        output = new Stack<Integer>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        if (!output.empty()) {
            return output.pop();
        }

        while (!input.empty()) {
            output.push(input.pop());
        }
        return output.pop();  // amortised
    }

    public int peek() {
        if (!output.empty()) {
            return output.peek();
        }

        while (!input.empty()) {
            output.push(input.pop());
        }
        return output.peek();

    }

    public boolean empty() {
        return output.size() == 0 && input.size() == 0;

    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
