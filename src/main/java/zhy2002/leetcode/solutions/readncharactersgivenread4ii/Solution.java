package zhy2002.leetcode.solutions.readncharactersgivenread4ii;

import zhy2002.leetcode.solutions.readncharactersgivenread4.Reader4;

/**
 * https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/
 */
public class Solution extends Reader4 {

    private char[] buffer = new char[4];
    private int bufferNextIndex = 4;
    private int bufferSize = 4;

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return The number of characters read
     */
    public int read(char[] buf, int n) {
        int bufNextIndex = 0;
        n = Math.min(n, buf.length);
        if (n == 0)
            return 0;

        while (true) {
            if (bufferNextIndex == bufferSize) {
                if (bufferSize != 4) //last read was the last
                    break;

                bufferSize = read4(buffer);
                bufferNextIndex = 0;
            } else {
                buf[bufNextIndex++] = buffer[bufferNextIndex++];
                if (bufNextIndex == n)
                    break;
            }
        }
        return bufNextIndex;
    }

    /**
     * Reset the internal state when the source is reset.
     * This is not a part of the solution as it is coupled to my implementation of the Reader4 class.
     */
    @Override
    public void setFileContent(String fileContent) {
        super.setFileContent(fileContent);
        bufferNextIndex = 4;
        bufferSize = 4;
    }
}
