package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/word-ladder/#/description
 */
public class WordLadder2Tests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(
                solution.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")),
                equalTo(5)
        );
        assertThat(
                solution.ladderLength("abc", "ccc", Arrays.asList("acc", "ccc")),
                equalTo(3)
        );
        assertThat(
                solution.ladderLength("a", "c", Arrays.asList("c")),
                equalTo(2)
        );
        assertThat(
                solution.ladderLength("a", "a", Arrays.asList("a")),
                equalTo(1)
        );
    }

    public class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (!wordList.contains(endWord))
                return 0;

            BFS beginBfs = new BFS(beginWord, wordList);
            BFS endBfs = new BFS(endWord, wordList);
            boolean expandBegin = true;
            while (!beginBfs.finished() && !endBfs.finished()) {
                String common;
                if (expandBegin) {
                    common = beginBfs.step(endBfs.getFrontier());
                } else {
                    common = endBfs.step(beginBfs.getFrontier());
                }
                if (common != null) {
                    return beginBfs.getPathLength(common) + endBfs.getPathLength(common) + 1;
                }
                expandBegin = beginBfs.getFrontier().size() < endBfs.getFrontier().size();
            }
            return 0;
        }

        private class BFS {
            private Set<String> queued = new HashSet<>();
            private Set<String> frontier = new HashSet<>();
            private Map<String, String> fromMap = new HashMap<>();
            private List<String> wordList;

            BFS(String start, List<String> wordList) {
                this.wordList = wordList;
                frontier.add(start);
                queued.add(start);
            }

            Set<String> getFrontier() {
                return frontier;
            }

            boolean finished() {
                return frontier.isEmpty();
            }

            int getPathLength(String word) {
                int count = 0;
                while (true) {
                    word = fromMap.get(word);
                    if (word != null) {
                        count++;
                    } else {
                        break;
                    }
                }
                return count;
            }

            public String step(Set<String> otherFrontier) {
                Set<String> newFrontier = new HashSet<>();
                for (String fromWord : frontier) {
                    if (otherFrontier.contains(fromWord)) {
                        return fromWord;
                    }

                    for (String toWord : wordList) {
                        if (queued.contains(toWord) || !isAdjacent(fromWord, toWord))
                            continue;
                        newFrontier.add(toWord);
                        fromMap.put(toWord, fromWord);
                        queued.add(toWord);
                    }
                }

                this.frontier = newFrontier;
                return null;
            }
        }

        private boolean isAdjacent(String str1, String str2) {
            boolean hasDiff = false;
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    if (hasDiff)
                        return false;
                    hasDiff = true;
                }
            }
            return hasDiff;
        }
    }

}
