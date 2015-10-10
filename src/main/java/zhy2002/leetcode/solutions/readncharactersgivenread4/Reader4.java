package zhy2002.leetcode.solutions.readncharactersgivenread4;

/**
 * Implementation of the solution base class.
 */

public class Reader4 {

    private int nextIndex;
    private String fileContent;

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
        nextIndex = 0;
    }

    protected int read4(char[] buf) {
        if (fileContent == null)
            return 0;

        int b4Read = nextIndex;
        int afterRead = Math.min(fileContent.length(), nextIndex + 4);
        int j = 0;
        for (int i = b4Read; i < afterRead; i++) {
            buf[j++] = fileContent.charAt(i);
        }
        nextIndex = afterRead;
        return afterRead - b4Read;
    }
}
