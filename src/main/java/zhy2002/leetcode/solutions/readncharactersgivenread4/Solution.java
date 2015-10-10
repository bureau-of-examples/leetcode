package zhy2002.leetcode.solutions.readncharactersgivenread4;

/**
 * https://leetcode.com/problems/read-n-characters-given-read4/
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n Maximum number of characters to read
     * @return The number of characters read
     */
    public int read(char[] buf, int n) {
        if (buf == null)
            return 0;
        n = Math.min(n, buf.length);

        int count = 0;
        char[] buffer = new char[4];

        while (count < n) {
            int actualRead = read4(buffer);
            int canRead = n - count;
            canRead = Math.min(canRead, actualRead);

            for (int i = 0; i < canRead; i++) {
                buf[count++] = buffer[i];
            }

            if (actualRead < 4)
                break;
        }
        return count;
    }
}
