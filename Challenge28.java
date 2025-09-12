public class Challenge28 {
    public static void main(String[] args) {
        int[] testCases = {5, 10, 0, 1, 92};

        for (int n : testCases) {
            long result = fibonacci(n);
            System.out.println("Input: " + n);
            System.out.println("Output: " + result);
            System.out.println("-----");
        }
    }

    public static long fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        long[] fibArray = new long[n + 1];
        fibArray[0] = 0;
        fibArray[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
        }

        return fibArray[n];
    }
}
