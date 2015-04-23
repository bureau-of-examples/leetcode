package zhy2002.leetcode.solutions.wordladderii;

import java.util.*;

/**
 * C:\zhy\dev\git_repos\leetcode\src\main\java\zhy2002\leetcode\solutions\wordladderii
 * Breadth first search from both ends - this is significantly faster than single ended search.
 *
 */
public class Solution {
    @SuppressWarnings("unchecked")
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {

        HashSet<String>[] buffers = new HashSet[]{new HashSet(), new HashSet(), new HashSet(), new HashSet()}; //start front, end front, start back, end back
        HashMap<String, List<String>>[] comeFrom = new HashMap[]{new HashMap(), new HashMap()}; //track where a word is from for the front buffer and end buffer, multi-map
        buffers[0].add(start);
        comeFrom[0].put(start, null);
        buffers[1].add(end);
        comeFrom[1].put(end, null);

        int index = 0;   //buffer index
        boolean startReachedEnd = false;
        List<String> meetPoints = new ArrayList<>();
        while (true) {//check buffer by buffer
            int backIndex = (index + 2) % 4;
            int nextIndex = (index + 1) % 4;
            int trackIndex = index % 2;

            for (String word : buffers[index]) {//check if these words reach the other end
                if (buffers[nextIndex].contains(word)) {
                    startReachedEnd = true;
                    meetPoints.add(word);
                } else if (!startReachedEnd) {
                    char[] chars = word.toCharArray();
                    for (int i = 0; i < word.length(); i++) {
                        char oriCh = chars[i];
                        for (char ch = 'a'; ch <= 'z'; ch++) {
                            if (ch != oriCh) {
                                chars[i] = ch;
                                String newWord = new String(chars);
                                if (dict.contains(newWord) && !buffers[index].contains(newWord)) {
                                    buffers[backIndex].add(newWord);
                                    if (!comeFrom[trackIndex].containsKey(newWord)) {
                                        comeFrom[trackIndex].put(newWord, new ArrayList<String>());
                                    }
                                    comeFrom[trackIndex].get(newWord).add(word);
                                }
                            }
                        }
                        chars[i] = oriCh;
                    }
                    dict.remove(word);//examined
                }
            }
            if (startReachedEnd)
                break;
            buffers[index].clear();
            if (buffers[backIndex].isEmpty())
                break;
            index = nextIndex;
        }

        return dumpPaths(comeFrom, meetPoints);
    }

    private static List<List<String>> dumpPaths(HashMap<String, List<String>>[] comeFrom, List<String> meetPoints) {
        List<List<String>> result = new ArrayList<>();
        ArrayList<String> partial = new ArrayList<>();
        for (String meetPoint : meetPoints) {
            partial.add(meetPoint);
            List<List<String>> firstHalves = new ArrayList<>();
            addPaths(firstHalves, comeFrom[0], partial);
            List<List<String>> secondHalves = new ArrayList<>();
            addPaths(secondHalves, comeFrom[1], partial);
            partial.clear();

            for (List<String> half : firstHalves) {
                int head = 0, tail = half.size() - 1;
                while (head < tail) {
                    String temp = half.get(head);
                    half.set(head, half.get(tail));
                    half.set(tail, temp);
                    head++;
                    tail--;
                }
                half.remove(half.size() - 1);//remove last
            }

            for (List<String> first : firstHalves) {
                for (List<String> second : secondHalves) {
                    List<String> path = new ArrayList<>();
                    path.addAll(first);
                    path.addAll(second);
                    result.add(path);
                }
            }
        }
        return result;
    }

    private static void addPaths(List<List<String>> result, HashMap<String, List<String>> comeFrom, List<String> partial) {
        String last = partial.get(partial.size() - 1);
        List<String> fromWords = comeFrom.get(last);
        if (fromWords == null) {
            result.add(new ArrayList<>(partial));
            return;
        }

        for (String from : fromWords) {
            partial.add(from);
            addPaths(result, comeFrom, partial);
            partial.remove(partial.size() - 1);
        }
    }
}
