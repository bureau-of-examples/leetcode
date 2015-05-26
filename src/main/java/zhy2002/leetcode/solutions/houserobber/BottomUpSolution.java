package zhy2002.leetcode.solutions.houserobber;

/**
 * bottom up dp.
 */
public class BottomUpSolution  implements Solution{

    @Override
    public int rob(int[] num) {
        if(num.length == 0)
            return 0;

        int rob = num[0], notRob = 0;  //max money we get if we rob/not rob the ith house.
        for(int i=1; i<num.length; i++){
            int newRob = notRob + num[i];
            if(rob > notRob)
                notRob = rob;
            rob = newRob;
        }

        return rob > notRob ? rob : notRob;
    }
}
