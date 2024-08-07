package Stack.MonotonusStack;

import java.util.Stack;

/**
 * @author : Kunal Sharma
 * @since : 03/08/24, Saturday
 **/
class StockSpanner {
    private Stack<int[]> stack;

    // Constructor
    public StockSpanner() {
        stack = new Stack<>();
    }

    // Method to calculate the span for the current price
    public int next(int price) {
        int span = 1; // The span for the current price starts at 1

        // Calculate the span by checking previous prices
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.peek()[1]; // Add the span of the previous price
            stack.pop(); // Remove the previous price from the stack
        }

        // Push the current price and its span onto the stack
        stack.push(new int[] { price, span });

        return span;
    }
}
