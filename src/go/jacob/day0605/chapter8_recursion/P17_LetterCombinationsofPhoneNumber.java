package go.jacob.day0605.chapter8_recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 * <p>
 * Example:
 * <p>
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * <p>
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class P17_LetterCombinationsofPhoneNumber {
    private String[] map = new String[]{
            " ",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    private List<String> res;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<String>();
        if (digits == null || digits.length() == 0)
            return res;

        findCombination(digits, "", 0);
        return res;
    }

    private void findCombination(String digits, String s, int index) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }
        char digit = digits.charAt(index);
        for (char c : map[digit - '0'].toCharArray()) {
            findCombination(digits, s + c, index + 1);
        }
    }
}
