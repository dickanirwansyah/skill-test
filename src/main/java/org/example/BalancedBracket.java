package org.example;

import java.util.Stack;

public class BalancedBracket {

    public static void main(String[] args) {
        String[] inputs = {
                "{ [ ( ) ] }",
                "{ [ ( ] ) }",
                "{ ( ( [ ] ) [ ] ) [ ] }"
        };

        for (String input : inputs) {
            System.out.println(checkBalancedBrackets(input));
        }
    }

    public static String checkBalancedBrackets(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else if (ch == '}' || ch == ']' || ch == ')') {
                if (stack.isEmpty()) {
                    return "NO";
                }

                char top = stack.pop();
                if (!isMatchingPair(top, ch)) {
                    return "NO";
                }
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }

    private static boolean isMatchingPair(char opening, char closing) {
        return (opening == '{' && closing == '}') ||
                (opening == '[' && closing == ']') ||
                (opening == '(' && closing == ')');
    }
}
