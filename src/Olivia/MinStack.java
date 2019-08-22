package src.Olivia;

//NO 155

import java.util.Stack;

class MinStack {
    private Stack<Integer> minStack;
    private Stack<Integer> stack;
    /** initialize your data structure here. */
    public MinStack() {
        minStack = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(!minStack.isEmpty()){
            if(x<=minStack.peek()){
                minStack.push(x);
            }
        }
        else{
            minStack.push(x);
        }
    }

    public void pop() {
        int tmp = stack.pop();
        if(tmp==minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */