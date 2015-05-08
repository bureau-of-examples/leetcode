package zhy2002.leetcode.solutions.happynumber;

/**
 * https://leetcode.com/discuss/33349/o-1-space-java-solution
 * As stated in a comment:
 * "This is a bit similar to finding if a singly linked list has a cycle."
 */
public class O1SpaceSolution {
    public class Solution {

        public boolean isHappy(int n) {
            int x = n;
            int y = n;
            while(x>1){
                x = cal(x) ;
                if(x==1) return true ;
                y = cal(cal(y));
                if(y==1) return true ;

                if(x==y) return false;
            }
            return true ;
        }
        public int cal(int n){
            int x = n;
            int s = 0;
            while(x>0){
                s = s+(x%10)*(x%10);
                x = x/10;
            }
            return s ;
        }
    }
}
