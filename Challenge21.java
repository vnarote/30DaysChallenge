import java.util.*;

public class Challenge21 {
    public static int firstElementKTimes(int[] arr, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (freq.containsKey(arr[i])) {
                freq.put(arr[i], freq.get(arr[i]) + 1);
            } else {
                freq.put(arr[i], 1);
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (freq.get(arr[i]) == k) {
                return arr[i];
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {3, 1, 4, 4, 5, 2, 6, 1, 4};
        int k1 = 2;
        System.out.println(firstElementKTimes(arr1, k1)); 
        // Test case 2
        int[] arr2 = {2, 3, 4, 2, 2, 5, 5};
        int k2 = 2;
        System.out.println(firstElementKTimes(arr2, k2)); 
        // Test case 3
        int[] arr3 = {1, 1, 1, 1};
        int k3 = 1;
        System.out.println(firstElementKTimes(arr3, k3)); 
        // Test case 4
        int[] arr4 = {10};
        int k4 = 1;
        System.out.println(firstElementKTimes(arr4, k4)); 
        // Test case 5
        int[] arr5 = {6, 6, 6, 6, 7, 7, 8, 8, 8};
        int k5 = 3;
        System.out.println(firstElementKTimes(arr5, k5)); 

        // Edge cases
        int[] arr6 = {5};
        int k6 = 2;
        System.out.println(firstElementKTimes(arr6, k6)); 

        int[] arr7 = {1, 2, 3, 4, 5};
        int k7 = 2;
        System.out.println(firstElementKTimes(arr7, k7));

        int[] arr8 = {-1, -1, 2, 2, 0, 0, 0};
        int k8 = 3;
        System.out.println(firstElementKTimes(arr8, k8)); 
    }
}
