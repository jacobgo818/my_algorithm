package go.jacob.day0325.leetcode;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:

 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 Note: All inputs will be in lower-case.


 */
public class P49_GroupAnagrams {
    /*
    核心：使用什么数据结构来存储什么？
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null||strs.length==0)
            return new ArrayList<List<String>>();

        HashMap<String, List<String>> map = new HashMap<String, List<String>>();

        for(String s:strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            if(map.containsKey(String.valueOf(chars))){
                map.get(String.valueOf(chars)).add(s);
            }
            else{
                ArrayList<String> list = new ArrayList<String>();
                list.add(s);
                map.put(String.valueOf(chars),list);
            }
        }


        return new ArrayList<List<String>>(map.values());
    }
}
