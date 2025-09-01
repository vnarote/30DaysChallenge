public class Challenge17 {

    public static int countDivisors(int N) {
        int count = 0;
        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                if (i * i == N) {
                    count += 1; 
                } else {
                    count += 2; 
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] testCases = {12, 18, 29, 100, 1, 997};
        for (int n : testCases) {
            System.out.println("N = " + n + ", Number of divisors = " + countDivisors(n));
        }
    }
}
