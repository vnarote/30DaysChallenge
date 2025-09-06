public class Challenge22 {
    public static int[] maxSlidingWindow(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
            return new int[0];
        }

        int n = arr.length;
        int[] result = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            int max = arr[i];
            for (int j = i; j < i + k; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
            }
            result[i] = max;
        }

        return result;
    }

    public static void printArray(int[] arr) {
        if (arr.length == 0) {
            System.out.println("[]");
            return;
        }
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        

        // Test Case 1
        printArray(maxSlidingWindow(new int[]{1, 5, 3, 2, 4, 6}, 3));       
        // Test Case 2
        printArray(maxSlidingWindow(new int[]{1, 2, 3, 4}, 2));             
        // Test Case 3
        printArray(maxSlidingWindow(new int[]{7, 7, 7, 7}, 1));           

        // Edge Case 1
        printArray(maxSlidingWindow(new int[]{42}, 1));                      
        // Edge Case 2
        printArray(maxSlidingWindow(new int[]{2, 2, 2, 2}, 4));              
        // Edge Case 3
        printArray(maxSlidingWindow(new int[]{5, 5, 5, 5, 5}, 2));          

}
}