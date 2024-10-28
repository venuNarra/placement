package stack;

import java.util.Stack;

public class SortStack {
   //  Approach 1. using temp stack is one solution
    // Approach 2. Recursive approach
    // Approach 3. Collect into list and sort it and then push into the stack
    public static void sortStack(Stack<String> stack){

   }
    public static void main(String[] args) {
        Stack<String> stack= new Stack<>();
        stack.push("1");
        stack.push("5");
        stack.push("4");
        stack.push("2");
        sortStack(stack);
    }

}
