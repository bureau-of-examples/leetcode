package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.aliendictionary.Solution;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AlienDictionaryTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        String result = solution.alienOrder(new String[]{});
        assertThat(result, equalTo(""));

        result = solution.alienOrder(new String[]{"a", "b", "c"});
        assertThat(result, equalTo("abc"));

        result = solution.alienOrder(new String[]{"ab", "ac", "b"});
        assertThat(result, equalTo("abc"));

        result = solution.alienOrder(new String[]{"ab", "ba"});
        assertThat(result, equalTo("ab"));

        result = solution.alienOrder(new String[]{"ac", "ab", "ba", "bb", "bb"});
        assertThat(result, equalTo("acb"));

        result = solution.alienOrder(new String[]{"c", "ab", "ac", "b"});
        assertThat(result, equalTo(""));

        result = solution.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"});
        assertThat(result, equalTo("wertf"));

        result = solution.alienOrder(new String[]{"des", "tba", "aac", "dtc", "cbc"});
        assertThat(result, equalTo(""));

        result = solution.alienOrder(new String[]{"ac", "ab", "ae", "bf", "bc", "bg"});
        assertThat(result, equalTo("afcbeg"));

        result = solution.alienOrder(new String[]{"bsusz","rhn","gfbrwec","kuw","qvpxbexnhx","gnp","laxutz","qzxccww"});
        assertThat(result, equalTo(""));
    }


    @Test
    public void solution2Test() {
        Solution2 solution2 = new Solution2();
        assertThat(solution2.alienOrder(new String[] {"wrt","wrf","er","ett","rftt"}), equalTo("wretf"));
    }

    class Solution2 {

        private class Node {
            char ch;
            Set<Node> predecessors = new HashSet<>();

            public Node(char ch) {
                this.ch = ch;
            }
        }

        public String alienOrder(String[] words) {
            List<Node> nodes = buildDag(words);
            if (nodes.size() == 0)
                return "";
            Map<Node, Boolean> flags = new HashMap<>();
            StringBuilder result = new StringBuilder();
            for (Node node : nodes) {
                try {
                    dfs(result, flags, node);
                } catch(RuntimeException ex) {
                    return "";
                }
            }
            return result.toString();
        }

        private void dfs(StringBuilder result, Map<Node, Boolean> flags, Node node) {
            Boolean flag = flags.get(node);
            if (Boolean.TRUE.equals(flag))
                throw new RuntimeException("Cycle detected");
            else if (Boolean.FALSE.equals(flag))
                return; //visited
            flags.put(node, true);
            for (Node predecessor : node.predecessors) {
                dfs(result, flags, predecessor);
            }
            flags.put(node, false);
            result.append(node.ch);
        }

        private List<Node> buildDag(String[] words) {
            Map<Character, Node> nodeMap = new HashMap<>();
            for (String str : words) {
                for (char ch : str.toCharArray()) {
                    if (!nodeMap.containsKey(ch)) {
                        nodeMap.put(ch, new Node(ch));
                    }
                }
            }
            for (int i=0; i<words.length - 1; i++) {
                int len = Math.min(words[i].length(), words[i+1].length());
                for (int j=0; j<len; j++) {
                    char smaller = words[i].charAt(j);
                    char greater = words[i+1].charAt(j+1);
                    if (smaller != greater) {
                        Node smallerNode = nodeMap.get(smaller);
                        Node greaterNode = nodeMap.get(greater);
                        greaterNode.predecessors.add(smallerNode);
                        break;
                    }
                }
            }
            return new ArrayList<>(nodeMap.values());
        }
    }

}
