/**
 * https://leetcode.com/problems/count-and-say/description/
 */
package com.hpe.acm.leetcode;

import java.util.Stack;

public class CountAndSay {
    public String generateSay(String preSay) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> container = new Stack<Character>();
        for (char c : preSay.toCharArray()) {
            if (container.empty()) {
                container.push(c);
            } else {
                if (container.peek() == c) {
                    container.push(c);
                } else {
                    sb.append(container.size() + "" + container.pop().toString());
                    container.clear();
                    container.push(c);
                }
            }
        }
        if (!container.empty()) {
            sb.append(container.size() + "" + container.pop().toString());
        }
        return sb.toString();
    }

    /**
     * 
     * @param n get the nth count and say result with 
     * @return
     */
    public String countAndSay(int n) {
        String say = new String();
        if (n == 1) {
            return "1";
        }
        say = generateSay(countAndSay(n - 1));
        return say;
    }
}
