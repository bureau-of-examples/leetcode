package zhy2002.leetcode.solutions.bitwiseandofnumbersrange;


/**
 * This is equivalent to finding common 1 bits of all numbers.
 * For each bit in m from the right most bit:
 * We check if this bit will remain 1 after calculation. If so all the bits to the left will also remain their value in m.
 */
public class MySolution implements Solution{

    public int rangeBitwiseAnd(int m, int n) {

        int trailing0s = 0;
        int mask = 0;
        //if this bit is 0 the iteration does not change m
        //if this bit is 1, then if n > ????[1]111, we know ????0000 is in range then this bit will become 0.
        //if this bit is 1 and n <= ????[1]111 then this bit will remain 1.
        while (m > 0 && n > (m | mask)) {
            m &= ~(1 << trailing0s);    //in turn set bit to 0 from right
            trailing0s++;
            mask <<= 1; //in turn shift in a 1 bit from right
            mask |= 1;
        }
        return m;

    }
}
