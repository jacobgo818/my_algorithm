package go.jacob.day0310_0311.查找相关问题;


import java.util.HashMap;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.

 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.

 Note:
 You may assume the string contains only lowercase alphabets.

 Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class P242_ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if(s==null||t==null||s.length()!=t.length())
            return false;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for(char c:s.toCharArray()){
            if(map.containsKey(c))
                map.put(c,map.get(c)+1);
            else
                map.put(c,1);
        }

        for(char c:t.toCharArray()){
            if(!map.containsKey(c)||map.get(c)<=0)
                return false;
            map.put(c,map.get(c)-1);
        }

        return true;
    }
}
