package com.justintullgren.hackerrank.datastructures;

import java.util.Stack;

/**
 * @see <a href="https://www.hackerrank.com/challenges/balanced-brackets/problem">Problem</a>
 */
public class BalancedBrackets {
    static String isBalanced(String s) {
        if (s == null || s.equals("")) {
            return "NO";
        }
        if (s.length() == 1 || s.length() % 2 != 0) {
            return "NO";
        }


        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);
            if (isOpen(bracket)) {
                stack.push(bracket);
            } else {
                if (stack.isEmpty() || !matchingBrackets(stack.pop(), bracket)) {
                    return "NO";
                }
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }

    private static boolean isOpen(char bracket) {
        return bracket == '{' || bracket == '[' || bracket == '(';
    }

    private static boolean matchingBrackets(char left, char right) {
        return (left == '{' && right == '}') ||
                (left == '[' && right == ']') ||
                (left == '(' && right == ')');
    }

}
