package go.jacob.day0304.array.滑动窗口;

import java.util.HashSet;
import java.util.Set;


/**
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3.
 Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


 */
public class P3_LongestSubstringWithoutRepeatingCharacters {

    /*
    采用hashSet求解，也可以用数组，int[256]
     */
    public int lengthOfLongestSubstring(String s) {

        int l = 0, r = -1;
        int res = 0;

        Set<Character> set = new HashSet<Character>();

        while (l < s.length()) {
            if (r + 1 < s.length() && !set.contains(s.charAt(r + 1))) {
                set.add(s.charAt(++r));
                res = Math.max(res, set.size());
            } else {
                set.remove(s.charAt(l++));
            }
        }

        return res;
    }
}
