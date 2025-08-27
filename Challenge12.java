public class Challenge12 {
    
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            String oddPalindrome = expandFromCenter(s, i, i);

            String evenPalindrome = expandFromCenter(s, i, i + 1);

            String currentLongest = oddPalindrome.length() > evenPalindrome.length() ? oddPalindrome : evenPalindrome;

            if (currentLongest.length() > longest.length()) {
                longest = currentLongest;
            }
        }

        return longest;
    }

    private static String expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println(longestPalindrome("babad")); 
        // Test case 2
        System.out.println(longestPalindrome("cbbd"));  
        // Test case 3
        System.out.println(longestPalindrome("a"));    
        // Test case 4
        System.out.println(longestPalindrome("aaaa"));  
        // Test case 5
        System.out.println(longestPalindrome("abc"));   
    }
}
