package go.jacob.day0310_0311.查找相关问题;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 * <p>
 * For example,
 * Given "egg", "add", return true.
 * <p>
 * Given "foo", "bar", return false.
 * <p>
 * Given "paper", "title", return true.
 * <p>
 * Note:
 * You may assume both s and t have the same length.
 */
public class P205_IsomorphicStrings {

    /*
    不能简单的使用一个map来解决问题，因为可能ab映射到aa，这样用map无法判断出false；
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        HashSet<Character> set = new HashSet<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), t.charAt(i));
                if(!set.add(t.charAt(i)))
                    return false;
            }
            else if(map.get(s.charAt(i))!=t.charAt(i))
                return false;
        }

        return true;
    }
}
