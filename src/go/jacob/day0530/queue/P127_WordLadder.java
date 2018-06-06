package go.jacob.day0530.queue;

import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * <p>
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 * <p>
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * Output: 5
 * <p>
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 * <p>
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * Output: 0
 * <p>
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 * <p>
 * 解法：
 * 该题一样可以简化为图论的问题
 */
public class P127_WordLadder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(beginWord, 1));
        Set<String> dict = new HashSet<String>(wordList);
        Set<String> visited = new HashSet<String>();

        if (!dict.contains(endWord))
            return 0;

        while (!queue.isEmpty()) {
            String str = queue.peek().str;
            int step = queue.peek().step;
            queue.poll();

            for (int i = 0; i < str.length(); i++) {
                char[] chars = str.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[i] = c;

                    String word = new String(chars);
                    if (word.equals(endWord))
                        return step + 1;

                    if (dict.contains(word) && !visited.contains(word)) {
                        queue.add(new Pair(word, step + 1));
                        visited.add(word);
                    }
                }
            }
        }

        return 0;
    }



    public static int ladderLength(String beginWord, String endWord, HashSet<String> dict) {
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(beginWord, 1));
        Set<String> visited = new HashSet<String>();

        if (!dict.contains(endWord))
            return 0;

        while (!queue.isEmpty()) {
            String str = queue.peek().str;
            int step = queue.peek().step;
            queue.poll();

            for (int i = 0; i < str.length(); i++) {
                char[] chars = str.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[i] = c;

                    String word = new String(chars);
                    if (word.equals(endWord))
                        return step + 1;

                    if (dict.contains(word) && !visited.contains(word)) {
                        queue.add(new Pair(word, step + 1));
                        visited.add(word);
                    }
                }
            }
        }

        return 0;
    }

    static class Pair {
        public String str;
        public int step;

        public Pair(String str, int step) {
            this.str = str;
            this.step = step;
        }
    }


}








