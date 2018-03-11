package go.jacob.day0310_0311.查找相关问题;

import java.util.HashMap;

/**
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * <p>
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 * <p>
 * Credits:
 * Special thanks to @minglotus6 for adding this problem and creating all test cases.
 */
public class P290_WordPattern {

    /*
    HashMap的性质，put方法会返回旧值

    注意：这里for循环里的i必须是Integer类型，不然又样例无法通过
     */
    public boolean wordPattern(String pattern, String str) {
        HashMap<Object, Integer> map = new HashMap<Object, Integer>();
        String[] words = str.split(" ");

        if (pattern.length() != words.length)
            return false;
        for (Integer i = 0; i < pattern.length(); i++)
            if (map.put(pattern.charAt(i), i) != map.put(words[i], i))
                return false;
        return true;
    }
}
