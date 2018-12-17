package com.justintullgren.hackerrank.datastructures;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @see <a href="https://www.hackerrank.com/challenges/jesse-and-cookies/problem">problem</a>
 */
public class JessesCookies {
    /**
     * Returns the number of times Jesse must make new cookies to meet a minimum sweetness.
     * If not sweet enough make a new cookie by this formula: <br/>
     * newcookie = (1 * lowestCookie) + (2 * nextLowestCookie)
     *
     * @param k       minimum cookie sweetness
     * @param cookies the cookies
     * @return the number of times jesse must make new cookies with her algorithm
     */
    public static int cookies(int k, int[] cookies) {
        int ops = 0;
        Arrays.sort(cookies);
        Queue<Integer> newCookies = new LinkedList<>();
        for (int i = 0; i < cookies.length; i++) {
            int cookie = cookies[i];
            if (cookie < k) {
                if (newCookies.isEmpty()) {
                    int nextCookie = cookies[i + 1];
                    int newCookie = cookie + (2 * nextCookie);
                    newCookies.add(newCookie);
                    ops++;
                    i++;
                } else {
                    int smallestCookie = cookie;
                    if (newCookies.peek() < smallestCookie) {
                        smallestCookie = newCookies.poll();
                    }
                    int nextSmallestCookie;
                    if (!newCookies.isEmpty() && newCookies.peek() < cookies[i + 1]) {
                        nextSmallestCookie = newCookies.poll();
                    } else {
                        nextSmallestCookie = cookies[i + 1];
                        i++;
                    }
                    int newCookie = smallestCookie + (2 * nextSmallestCookie);
                    newCookies.add(newCookie);
                    ops++;
                }
            } else {
                // sorted so anything else after this is greater than k
                break;
            }
        }
        return ops;
    }

    public static int cookiesOptimized(int k, int[] cookies) {
        int ops = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < cookies.length; i++) {
            queue.add(cookies[i]);
        }
        while (queue.size() > 1 && queue.peek() < k) {
            int smallest = queue.poll();
            int nextSmallest = queue.poll();

            queue.add(smallest + (2 * nextSmallest));
            ops++;
        }
        if (queue.peek() < k) {
            return -1;
        } else {
            return ops;
        }
    }
}
