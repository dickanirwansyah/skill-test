package org.example;

public class HighestPalindrome {
    public static void main(String[] args) {
        System.out.println(makeHighestPalindrome("3943", 1)); // Output: 3993
        System.out.println(makeHighestPalindrome("932239", 2)); // Output: 992299
    }

    public static String makeHighestPalindrome(String s, int k) {
        char[] chars = s.toCharArray();
        char[] result = new char[chars.length];
        if (createPalindrome(chars, result, 0, chars.length - 1, k)) {
            return new String(result);
        } else {
            return "-1";
        }
    }

    private static boolean createPalindrome(char[] chars, char[] result, int left, int right, int k) {
        if (left > right) {
            return true;
        }

        if (chars[left] != chars[right]) {
            if (k == 0) {
                return false;
            }
            if (chars[left] > chars[right]) {
                result[left] = chars[left];
                result[right] = chars[left];
            } else {
                result[left] = chars[right];
                result[right] = chars[right];
            }
            return createPalindrome(chars, result, left + 1, right - 1, k - 1);
        } else {
            result[left] = chars[left];
            result[right] = chars[right];
            return createPalindrome(chars, result, left + 1, right - 1, k);
        }
    }
}
