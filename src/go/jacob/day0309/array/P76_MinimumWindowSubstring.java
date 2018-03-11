package go.jacob.day0309.array;


import org.junit.Test;

import java.util.HashMap;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * <p>
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * <p>
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class P76_MinimumWindowSubstring {

    /*
    思路：用map储存t中字符对应的出现次数，当次数都为零的时候，说明s子串包含了t
    然后移动right指针，结束
     */
    public String minWindow(String s, String t) {
        if (s == null || s.length() < t.length() || s.length() == 0) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : t.toCharArray()) {
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }

        int left = 0;
        int minLeft = 0;
        int minLen = s.length() + 1;
        int count = 0;

        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                if (map.get(s.charAt(right)) >= 0)
                    count++;

                while (count == t.length()) {
                    if (right - left + 1 < minLen) {
                        minLen = right - left + 1;
                        minLeft = left;
                    }
                    if (map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        if (map.get(s.charAt(left)) > 0)
                            count--;
                    }
                    left++;
                }
            }

        }
        if (minLen > s.length())
            return "";

        return s.substring(minLeft, minLeft + minLen);
    }

    @Test
    public void test1() {
        System.out.println("111:" + minWindow("ADOBECODEBANC", "ABC"));
    }
}
