package go.jacob.day0304.array.滑动窗口;


import java.util.ArrayList;
import java.util.List;


/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

 Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

 The order of output does not matter.

 Example 1:

 Input:
 s: "cbaebabacd" p: "abc"

 Output:
 [0, 6]

 Explanation:
 The substring with start index = 0 is "cba", which is an anagram of "abc".
 The substring with start index = 6 is "bac", which is an anagram of "abc".
 Example 2:

 Input:
 s: "abab" p: "ab"

 Output:
 [0, 1, 2]

 Explanation:
 The substring with start index = 0 is "ab", which is an anagram of "ab".
 The substring with start index = 1 is "ba", which is an anagram of "ab".
 The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class P438_FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();

        if (s == null || s.length() == 0 || p == null || p.length() == 0)
            return res;

        int l = 0, r = 0;
        int count = p.length();

        int[] hash = new int[256];

        for (char c : p.toCharArray()) {
            hash[c]++;
        }


        while (r < s.length()) {

            if (hash[s.charAt(r++)]-- > 0) {
                count--;
            }

            if (count == 0)
                res.add(l);

            if (r - l == p.length() && hash[s.charAt(l++)]++ >= 0)//要增加l前，需要判断
                count++;
        }


        return res;

    }

    public static void main(String[] args) {
        int a=6;
        if(a++>6)
            ;
        System.out.println(a);

    }
}
