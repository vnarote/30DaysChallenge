import java.util.Stack;

public class Challenge19 {

    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sortStack(stack);
            insertSorted(stack, temp);
        }
    }

    public static void insertSorted(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() > element) {
            stack.push(element);
        } else {
            int temp = stack.pop();
            insertSorted(stack, element);
            stack.push(temp);
        }
    }

    public static void printStack(Stack<Integer> stack) {
        for (int num : stack)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        // Test case 1
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(3);
        stack1.push(1);
        stack1.push(4);
        stack1.push(2);
        sortStack(stack1);
        System.out.print("Test case 1 Output: ");
        printStack(stack1);

        // Test case 2
        Stack<Integer> stack2 = new Stack<>();
        stack2.push(7);
        stack2.push(1);
        stack2.push(5);
        sortStack(stack2);
        System.out.print("Test case 2 Output: ");
        printStack(stack2);

        // Test case 3
        Stack<Integer> stack3 = new Stack<>();
        stack3.push(5);
        sortStack(stack3);
        System.out.print("Test case 3 Output: ");
        printStack(stack3);

        // Test case 4
        Stack<Integer> stack4 = new Stack<>();
        stack4.push(-3);
        stack4.push(14);
        stack4.push(8);
        stack4.push(2);
        sortStack(stack4);
        System.out.print("Test case 4 Output: ");
        printStack(stack4);

        // Test case 5
        Stack<Integer> stack5 = new Stack<>();
        sortStack(stack5);
        System.out.print("Test case 5 Output: ");
        printStack(stack5);

        // Test case 6
        Stack<Integer> stack6 = new Stack<>();
        stack6.push(3);
        stack6.push(3);
        stack6.push(3);
        sortStack(stack6);
        System.out.print("Test case 6 Output: ");
        printStack(stack6);
    }
}
