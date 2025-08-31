import java.util.ArrayList;
import java.util.List;

public class Challenge16 {
    public static List<Integer> primeFactors(int N) {
        List<Integer> factors = new ArrayList<>();
        
        while (N % 2 == 0) {
            factors.add(2);
            N = N / 2;
        }
        
        for (int i = 3; i <= Math.sqrt(N); i += 2) {
            while (N % i == 0) {
                factors.add(i);
                N = N / i;
            }
        }
        
        if (N > 2) {
            factors.add(N);
        }
        return factors;
    }

    public static void main(String[] args) {
        int[] testCases = {
            // Test case 1
            30,
            // Test case 2
            49,
            // Test case 3
            19,
            // Test case 4
            64,
            // Test case 5
            123456   
        };
        for (int N : testCases) {
            List<Integer> result = primeFactors(N);
            System.out.println("Input: N = " + N);
            System.out.println("Output: " + result);
        }
    }
}
