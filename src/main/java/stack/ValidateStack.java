package stack;

import java.util.Stack;

public class ValidateStack {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j=0;
        for (int i : pushed) {
            stack.push(i);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                j++;
                System.out.println(stack.pop());
            }
        }
        return stack.isEmpty() && j == popped.length;
    }

    public static boolean validateStackSequencesByModifyingFirstArray(int[] pushed, int[] popped) {
        int i = 0, j = 0;
        for (int x : pushed) {
            pushed[i++] = x; // Push x to the "stack" by placing it in pushed
            while (i > 0 && pushed[i - 1] == popped[j]) { // Check top of "stack"
                i--; // Pop the stack
                j++;
            }
        }
        return i == 0;
    }

    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,1,2};
        System.out.println(validateStackSequences(pushed, popped));
        System.out.println(validateStackSequencesByModifyingFirstArray(pushed, popped));

    }
}
