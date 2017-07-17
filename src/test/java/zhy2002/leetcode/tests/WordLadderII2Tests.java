package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/word-ladder-ii/#/description
 */
public class WordLadderII2Tests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(
                Utils.listOfListToString(
                        solution.findLadders("red", "tax", Arrays.asList("ted", "tex", "red", "tax", "tad", "den", "rex", "pee"))
                ),
                equalTo("[[red,ted,tex,tax],[red,ted,tad,tax],[red,rex,tex,tax]]")
        );

        assertThat(
                Utils.listOfListToString(
                        solution.findLadders("a", "b", Arrays.asList("b", "c"))
                ),
                equalTo("[[a,b]]")
        );
        assertThat(
                Utils.listOfListToString(
                        solution.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))
                ),
                equalTo("[[hit,hot,lot,log,cog],[hit,hot,dot,dog,cog]]")
        );
    }

    public class Solution {
        private class BFS {
            private Set<String> frontier = new HashSet<>();
            private Set<String> allWords = new HashSet<>();
            private Map<String, List<String>> fromMap = new HashMap<>();
            private List<String> commonWords = new ArrayList<>();

            BFS(String startWord, List<String> allWords) {
                this.allWords.addAll(allWords);
                frontier.add(startWord);
                this.allWords.remove(startWord);
            }

            Set<String> getFrontier() {
                return frontier;
            }

            Map<String, List<String>> getFromMap() {
                return fromMap;
            }

            List<String> step(Set<String> otherFrontier) {
                if (commonWords.size() > 0 || frontier.isEmpty()) //result reached
                    return commonWords;

                Set<String> newFrontier = new HashSet<>();
                for (String word : frontier) {
                    if (otherFrontier.contains(word)) {
                        commonWords.add(word);
                    }
                    if (!commonWords.isEmpty())
                        continue;
                    addToNewFrontier(newFrontier, word);
                }

                if (commonWords.isEmpty()) {
                    frontier = newFrontier;
                    allWords.removeAll(newFrontier);
                }
                return commonWords;
            }

            private void addToNewFrontier(Set<String> newFrontier, String word) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char oldChar = chars[i];
                    for (char newChar = 'a'; newChar <= 'z'; newChar++) {
                        if (newChar == oldChar)
                            continue;

                        chars[i] = newChar;
                        String nextWord = new String(chars);
                        if (allWords.contains(nextWord)) {
                            newFrontier.add(nextWord);
                            fromMap.computeIfAbsent(nextWord, k -> new ArrayList<>()).add(word);
                        }
                    }
                    chars[i] = oldChar;
                }
            }
        }

        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            if (!wordList.contains(endWord))
                return Collections.emptyList(); //not reachable

            BFS beginBfs = new BFS(beginWord, wordList);
            BFS endBfs = new BFS(endWord, wordList);
            boolean expandBegin = true;
            while (beginBfs.getFrontier().size() > 0 && endBfs.getFrontier().size() > 0) {
                List<String> commonWords;
                if (expandBegin) {
                    commonWords = beginBfs.step(endBfs.getFrontier());
                } else {
                    commonWords = endBfs.step(beginBfs.getFrontier());
                }
                if (commonWords.size() > 0) {
                    return getPaths(commonWords, beginBfs.getFromMap(), endBfs.getFromMap());
                }
                expandBegin = beginBfs.getFrontier().size() < endBfs.getFrontier().size();
            }
            return Collections.emptyList(); //cannot reach
        }

        private List<List<String>> getPaths(List<String> commonWords, Map<String, List<String>> beginFromMap, Map<String, List<String>> endFromMap) {
            List<List<String>> result = new ArrayList<>();
            for (String commonWord : commonWords) {
                List<List<String>> leftPaths = new ArrayList<>();
                traceToStart(leftPaths, Collections.singletonList(commonWord), beginFromMap);
                List<List<String>> rightPaths = new ArrayList<>();
                traceToStart(rightPaths, Collections.singletonList(commonWord), endFromMap);
                join(result, leftPaths, rightPaths);
            }
            return result;
        }

        //todo recursive
        private void traceToStart(List<List<String>> result, List<String> prefix, Map<String, List<String>> fromMap) {
            String lastWord = prefix.get(prefix.size() - 1);
            List<String> fromWords = fromMap.get(lastWord);
            if (fromWords == null) {
                result.add(prefix);
                return;
            }

            for (String fromWord : fromWords) {
                List<String> newPrefix = new ArrayList<>(prefix);
                newPrefix.add(fromWord);
                traceToStart(result, newPrefix, fromMap);
            }
        }

        private void join(List<List<String>> result, List<List<String>> leftPaths, List<List<String>> rightPaths) {
            for (List<String> left : leftPaths) {
                for (List<String> right : rightPaths) {
                    List<String> joined = new ArrayList<>();
                    for (int i = left.size() - 1; i >= 1; i--) {
                        joined.add(left.get(i));
                    }
                    joined.addAll(right);
                    result.add(joined);
                }
            }
        }
    }

}
