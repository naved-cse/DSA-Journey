class Solution {
    public int evalRPN(String[] tokens) {
        // We can use the modern ArrayDeque we talked about!
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (String token : tokens) {
            // If it's an operator, pop the top two numbers and do the math
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } 
            else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } 
            else if (token.equals("-")) {
                // ORDER MATTERS! The first pop is the SECOND number.
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 - num2);
            } 
            else if (token.equals("/")) {
                // ORDER MATTERS!
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 / num2);
            } 
            else {
                // If it's not an operator, it MUST be a number!
                // Convert the String to an int and push it.
                stack.push(Integer.parseInt(token));
            }
        }
        
        // At the very end, the only thing left in the stack is the final answer
        return stack.pop();
    }
}