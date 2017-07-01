package zhy2002.leetcode.tests;

/**
 * https://leetcode.com/problems/student-attendance-record-i/#/description
 */
public class StudentAttendanceRecordITests {

    public class Solution {
        public boolean checkRecord(String s) {

            int aCount = 0;
            int lCount = 0;
            for (int i=0; i<s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == 'A') {
                    aCount++;
                    if (aCount > 1)
                        return false;
                    lCount = 0;
                } else if(ch == 'L') {
                    lCount++;
                    if (lCount > 2)
                        return false;
                } else if (ch == 'P') {
                    lCount = 0;
                }
            }

            return true;
        }
    }
}
