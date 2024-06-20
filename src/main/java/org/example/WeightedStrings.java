package org.example;

import java.util.HashSet;
import java.util.Set;

public class WeightedStrings {

    public static void main(String[] args) {
        String s = "abbcccd";
        int[] queries = {1, 3, 9, 8};
        String[] results = checkWeightedStrings(s, queries);

        for (String result : results) {
            System.out.println(result);
        }
    }

    public static String[] checkWeightedStrings(String s, int[] queries) {
        Set<Integer> weights = new HashSet<>();

        int n = s.length();
        int i = 0;

        while (i < n) {
            char currentChar = s.charAt(i);
            int weight = currentChar - 'a' + 1;
            int count = 0;

            // Calculate all possible weights for current repeated character sequence
            while (i < n && s.charAt(i) == currentChar) {
                count++;
                weights.add(weight * count);
                i++;
            }
        }

        // Check each query
        String[] results = new String[queries.length];
        for (int j = 0; j < queries.length; j++) {
            if (weights.contains(queries[j])) {
                results[j] = "Yes";
            } else {
                results[j] = "No";
            }
        }

        return results;
    }
}
