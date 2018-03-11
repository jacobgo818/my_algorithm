package go.jacob.day0310_0311.查找相关问题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * "tree"
 * <p>
 * Output:
 * "eert"
 * <p>
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 * <p>
 * Input:
 * "cccaaa"
 * <p>
 * Output:
 * "cccaaa"
 * <p>
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 * <p>
 * Input:
 * "Aabb"
 * <p>
 * Output:
 * "bbAa"
 * <p>
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 */
public class P451_SortCharactersByFrequency {

    /*
    思路：map记录每个字母出现的次数
    然后再遍历一遍这个map，将相应的字母填入相应的次数对应的list，最后生成Stirng即可
     */
    public String frequencySort(String s) {
        if (s == null)
            return null;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        int max = 0;
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c))
                map.put(c, 1);
            else
                map.put(c, map.get(c) + 1);
            max = Math.max(max, map.get(c));
        }

        List<Character>[] array = buildArray(map, max);
        return buildString(array);
    }


    public List<Character>[] buildArray(Map<Character, Integer> map, int maxCount) {
        List<Character>[] array = new ArrayList[maxCount + 1];
        for(char c:map.keySet()){
            if(array[map.get(c)]==null)
                array[map.get(c)]=new ArrayList<Character>();
            array[map.get(c)].add(c);
        }

        return array;
    }

    public String buildString(List<Character>[] array){
        StringBuilder sb=new StringBuilder();

        for(int i=array.length-1;i>=0;i--){
            if(array[i]!=null){
                for(char c:array[i]){
                    for(int j=0;j<i;j++)
                        sb.append(c);
                }
            }
        }
        return sb.toString();
    }

}
