package go.jacob.day0303.array;

/**
 * Write a function that takes a string as input and returns the string reversed.
 * <p>
 * Example:
 * Given s = "hello", return "olleh".
 */
public class P344_ReverseString {

    public String reverseString(String s) {
        if (s == null || s.length() < 2)
            return s;

        char[] chars = s.toCharArray();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            exch(chars, l, r);
            l++;
            r--;
        }

        return new String(chars);
    }

    private void exch(char[] chars, int l, int r) {
        char c = chars[l];
        chars[l] = chars[r];
        chars[r] = c;
    }
}
