package com.justintullgren.hackerrank.crackingthecodinginterview.chapterone;

/**
 * Implement string compression using counts.
 * If the compressed would not be smaller than original, return original.
 * f(n) -> n
 * Example: compress("aabcccccaaa") -> "a2b1c5a3"
 * Example: compress("aa") -> "aa" NOT "a2"
 */
public class StringCompression {
    public static String compress(String string) {
        if (string.isEmpty()) {
            return string;
        }

        StringBuilder stringBuilder = new StringBuilder();
        char lastLetter = string.charAt(0);
        int count = 1;
        for (int i = 1; i < string.length(); i++) {
            char letter = string.charAt(i);
            if (lastLetter == letter) {
                count++;
            } else {
                stringBuilder.append(lastLetter).append(count);
                lastLetter = letter;
                count = 1;
            }
        }
        stringBuilder.append(lastLetter).append(count);
        String result = stringBuilder.toString();
        return (result.length() == string.length()) ? string : result;
    }
}
