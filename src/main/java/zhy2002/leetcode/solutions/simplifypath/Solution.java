package zhy2002.leetcode.solutions.simplifypath;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/simplify-path/
 * Use a stack, parse part by part (separated by '/').
 */
public class Solution {

    public String simplifyPath(String path) {
        if (path == null || path.length() == 0)
            return path;

        if (!path.startsWith("/"))
            throw new RuntimeException("Only support absolute path.");

        ArrayList<String> parts = new ArrayList<>();
        int start = 1;
        int end;
        while (start < path.length()) {
            String part;
            end = path.indexOf('/', start);
            if (end == -1) {
                part = path.substring(start);
                start = path.length();
            } else {
                part = path.substring(start, end);
                start = end + 1;
            }

            if (part.length() == 0)
                continue;

            if (part.equals("."))
                continue;

            if (part.equals("..")) {
                if (parts.size() > 0)
                    parts.remove(parts.size() - 1);
                continue;
            }

            parts.add(part);
        }

        if (parts.size() == 0)
            return "/";

        //product result
        StringBuilder stringBuilder = new StringBuilder();
        for (String part : parts) {
            stringBuilder.append("/");
            stringBuilder.append(part);
        }
        return stringBuilder.toString();

    }

}
