import java.util.Stack;

public class ValidateStackSequence {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j=0; int popEle;
        for (int k : pushed) {
            stack.push(k);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                popEle = stack.pop();
                j++;
                System.out.println(popEle);
            }
        }
        return stack.isEmpty() && j == popped.length;
    }

    public static void main(String[] args) {
        ValidateStackSequence test = new ValidateStackSequence();
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};
        int[] popped1= {4,3,5,1,2};
        System.out.println(test.validateStackSequences(pushed, popped));
        System.out.println(test.validateStackSequences(pushed, popped1));

    }
}
