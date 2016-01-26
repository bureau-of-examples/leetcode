package zhy2002.leetcode.solutions.uglynumberii;

import java.util.PriorityQueue;


//need to generate the first n ugly numbers
//use a priority queue to poll the smallest out n times
//every ugly number is an ugly number * 2, 3 or 5.
public class PriorityQueueSolution implements Solution {

    private final int MAX2 = Integer.MAX_VALUE / 2;
    private final int MAX3 = Integer.MAX_VALUE / 3;
    private final int MAX5 = Integer.MAX_VALUE / 5;


    public int nthUglyNumber(int n) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        int last = -1;
        int count = 0;
        while (true) {
            int number = queue.poll(); //discard the first n-1 ugly numbers.
            if (number != last) {
                last = number;
                if (++count == n)
                    break;

                if(number <= MAX2){ //too big to be the answer.
                    queue.add(number * 2);
                }

                if(number <= MAX3){
                    queue.add(number * 3);
                }

                if(number <= MAX5) {
                    queue.add(number * 5);
                }
            }
        }
        return last;
    }
}
