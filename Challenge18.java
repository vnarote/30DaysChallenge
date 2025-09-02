
public class Challenge18 {

    private static int eval(String[] tokens, int[] idx) {
        String t = tokens[idx[0]];
        idx[0]--;
        if (isOperator(t)) {
            int b = eval(tokens, idx);
            int a = eval(tokens, idx);
            if (t.equals("+")) {
                return a + b;
            }
            if (t.equals("-")) {
                return a - b;
            }
            if (t.equals("*")) {
                return a * b;
            }
            if (t.equals("/")) {
                return a / b;
            }
        }
        return Integer.parseInt(t);
    }

    private static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    public static int evaluatePostfix(String expr) {
        String[] tokens = expr.trim().split("\\s+");
        int[] idx = {tokens.length - 1};
        return eval(tokens, idx);
    }

    public static void main(String[] args) {
        String[] tests = {
            // Test case 1
            "2 1 + 3 *",
            // Test case 2
            "5 6 +",
            // Test case 3
            "-5 6 -",
            // Test case 4
            "15 7 1 1 + - / 3 * 2 1 1 + + -",
            // Test case 5
            "5"
        };
        for (String test : tests) {
            int res = evaluatePostfix(test);
            System.out.println("Input: \"" + test + "\"");
            System.out.println("Output: " + res);
        }
    }
}
