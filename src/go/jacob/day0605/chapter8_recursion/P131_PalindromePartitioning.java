package go.jacob.day0605.chapter8_recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 * <p>
 * Example:
 * <p>
 * Input: "aab"
 * Output:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class P131_PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (s == null || s.length() == 0)
            return res;

        solve(s, 0, new ArrayList<String>(), res);
        return res;
    }

    private void solve(String s, int index, ArrayList<String> preList, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<String>(preList));
            return;
        }
        ArrayList<String> list = new ArrayList<String>(preList);
        for (int i = index + 1; i <= s.length(); i++) {
            if (isPalindrom(s.substring(index, i))) {
                list.add(s.substring(index, i));
                solve(s, i, list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrom(String s) {
        if (s == null)
            return false;

        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;

    }


}
