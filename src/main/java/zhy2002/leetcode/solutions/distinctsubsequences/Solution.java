package zhy2002.leetcode.solutions.distinctsubsequences;

/**
 * https://oj.leetcode.com/problems/distinct-subsequences/
 * nd = numDistinct(S, T): number of S subsequences equal to T.
 * nd(Sa,Ta) =  nd(S,T) //these subsequences end at a
 *           +  nd(S,Ta) //these subsequences does not end at a
 * nd(Ss, Tb)=  nd(S,Tb)
 *
 * Termination:
 * nd("", "")=1
 * nd("", T)=0
 * nd(S, "")=1 //so how many empty subsequences does S have? Just one when no index is selected. Subsequence = selection of index.
 * List S vertically and T horizontally, we can make a table of (len(S)+1)*(len(T)+1):
 *         ""      t1     t2      t3
 *   ""         nd(0,1) nd(0,2)
 *   s1                 nd(1,2)
 *   s2
 *   s3
 *
 *   To calculate nd(i, j): //i is S index and j is T index
 *   we need nd(i-1,j-1) and nd(i-1, j)
 *   This can be done by rolling down row by row.
 */
public class Solution {

    public int numDistinct(String S, String T) {
        if(S.length() < T.length())
            return 0;

        int[] buffer = new int[T.length()+1]; //buffer T as T tend to be shorter.
        buffer[0] = 1;//populate first row
        for(int j=1; j<buffer.length; j++)
            buffer[j] = 0;

        for(int i=1; i<=S.length();i++){

            int oldBufferJ_1 = buffer[0];
            for(int j=1; j<=T.length(); j++){//calculate buffer[j] for row i
                if(S.charAt(i-1) == T.charAt(j-1)){
                  int temp = buffer[j];
                    buffer[j] += oldBufferJ_1;
                    oldBufferJ_1 = temp;
                } else {
                    oldBufferJ_1 = buffer[j];
                }
            }
        }

        return buffer[buffer.length-1];
    }
}
