package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/find-duplicate-file-in-system/#/description
 */
public class FindDuplicateFileInSystemTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(
                solution.findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"}).toString(),
                equalTo("")
        );
    }

    public class Solution {
        public List<List<String>> findDuplicate(String[] paths) {
            Map<String, List<String>> contentToPath = new HashMap<>();
            for (String path : paths) {
                parseDir(contentToPath, path);
            }
            return contentToPath.values().stream().filter(list -> list.size() > 1).collect(Collectors.toList());
        }

        private void parseDir(Map<String, List<String>> contentToPath, String path) {
            String[] files = path.split("\\s+");
            for (int i = 1; i < files.length; i++) {
                parseFile(contentToPath, files[0], files[i]);
            }
        }

        private void parseFile(Map<String, List<String>> contentToPath, String dir, String file) {
            int index = file.indexOf("(");
            String fileName = file.substring(0, index);
            String fileContent = file.substring(index + 1, file.length() - 1);
            contentToPath.computeIfAbsent(fileContent, key -> new ArrayList<>()).add(dir + "/" + fileName);
        }
    }


}
