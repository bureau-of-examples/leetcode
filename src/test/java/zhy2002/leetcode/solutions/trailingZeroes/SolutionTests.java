package zhy2002.leetcode.solutions.trailingZeroes;

import org.junit.Test;
import zhy2002.leetcode.Utils;

import static org.junit.Assert.*;


public class SolutionTests {

    @Test
    public void smallNTest(){
        Solution solution = new Solution();

        for(int i=0; i<=16;i++){
            String factorial = String.valueOf( Utils.factorial((byte)i));
            int zeroCount = 0;
            for(int j=factorial.length() - 1; j>=0; j--){
                if(factorial.charAt(j) == '0')
                    zeroCount++;
                else
                    break;
            }

            int result = solution.trailingZeroes(i);
            assertEquals(zeroCount, result);
        }
    }

    @Test
    public void timeoutTest() throws InterruptedException{
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                new Solution().trailingZeroes(2147483647);
            }
        });
        thread.start();
        thread.join(1000);
        if(thread.getState() != Thread.State.TERMINATED){
            thread.interrupt();
            assertTrue(false); //timeout
        }

    }


}
