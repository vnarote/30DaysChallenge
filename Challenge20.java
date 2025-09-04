import java.util.Stack;

public class Challenge20 {

    public static void insertAtBottom(Stack<Integer> stack, int item) {
        if (stack.isEmpty()) {
            stack.push(item);
            return;
        }
        int top = stack.pop();
        insertAtBottom(stack, item);
        stack.push(top);
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        reverse(stack);
        insertAtBottom(stack, top);
    }

    public static void printStack(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            int item = stack.pop();
            System.out.print(item + " ");
            temp.push(item);
        }
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test Case 1: [1, 2, 3, 4]
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        System.out.print("Original: ");
        printStack(stack1);
        reverse(stack1);
        System.out.print("Reversed: ");
        printStack(stack1);

        // Test Case 2: [3, 2, 1]
        Stack<Integer> stack2 = new Stack<>();
        stack2.push(3);
        stack2.push(2);
        stack2.push(1);
        System.out.print("Original: ");
        printStack(stack2);
        reverse(stack2);
        System.out.print("Reversed: ");
        printStack(stack2);

        // Test Case 3: [5]
        Stack<Integer> stack3 = new Stack<>();
        stack3.push(5);
        System.out.print("Original: ");
        printStack(stack3);
        reverse(stack3);
        System.out.print("Reversed: ");
        printStack(stack3);

        // Test Case 4: [-5, -10, -15]
        Stack<Integer> stack4 = new Stack<>();
        stack4.push(-5);
        stack4.push(-10);
        stack4.push(-15);
        System.out.print("Original: ");
        printStack(stack4);
        reverse(stack4);
        System.out.print("Reversed: ");
        printStack(stack4);

        // Test Case 5: []
        Stack<Integer> stack5 = new Stack<>();
        System.out.print("Original: ");
        printStack(stack5);
        reverse(stack5);
        System.out.print("Reversed: ");
        printStack(stack5);

        // Test Case 6: [3, 3, 3]
        Stack<Integer> stack6 = new Stack<>();
        stack6.push(3);
        stack6.push(3);
        stack6.push(3);
        System.out.print("Original: ");
        printStack(stack6);
        reverse(stack6);
        System.out.print("Reversed: ");
        printStack(stack6);
    }
}
