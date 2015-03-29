package zhy2002.leetcode.solutions.containerwithmostwater;


/**
 * start from the two sides, gradually closes in.
 * We start from the widest container and try to increase the height to hold more water.
 */
public class ClosingInSolution implements Solution {

    @Override
    public int maxArea(int[] height) {
        if(height == null || height.length <= 1)
            return 0;
        int start = 0;
        int end = height.length - 1;
        int max = 0; //max area so far
        do{
            int thisMax = Math.min(height[start], height[end]) * (end - start);//water contained
            if(thisMax > max){
                max = thisMax;
            }
            //The invariance we maintain is there is the max container whose left border <= start and right border >= end is examined.
            if(height[start] <= height[end]){
                //1) start to any k < end <= thisMax
                //2) any container with k >= end on the right has been examined
                //all containers with start on the left has been examined
                start++;
            } else {
                //1) end to any j > start <= thisMax
                //2) any container with j <= start on the left has been examined
                //all containers with end on the right has been examined
                end--;
            }
        }while (start < end);
        return max;
    }
}
