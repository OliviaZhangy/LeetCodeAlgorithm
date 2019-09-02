package src.Olivia;

import java.util.Stack;

class MyQueue {
    Stack<Integer> input;
    Stack<Integer> output;
    /** Initialize your data structure here. */
    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        input.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!output.isEmpty()){
            return output.pop();
        }
        while(!input.isEmpty()){
            output.add(input.pop());
        }
        return output.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(!output.isEmpty()){
            return output.peek();
        }
        while(!input.isEmpty()){
            output.add(input.pop());
        }
        return output.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (output.isEmpty()&&input.isEmpty());
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