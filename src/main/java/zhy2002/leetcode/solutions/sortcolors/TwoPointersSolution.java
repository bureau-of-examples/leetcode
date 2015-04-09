package zhy2002.leetcode.solutions.sortcolors;

/**
 * Maintain a red pointer (end of red section) and a blue pointer (start of blue section):
 * [red][green][blue].
 */
public class TwoPointersSolution implements Solution {

    @Override
    public void sortColors(int[] A) {
        int redIndex = 0;
        int blueIndex = A.length - 1;
        for(int i=0; i<= blueIndex; i++){
            if(A[i] == 0){
                swap(A, redIndex++, i);
            } else if(A[i] == 2){
                swap(A, blueIndex--, i);
                i--;//redo this one as it may be red
            }
        }
    }

    private static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
