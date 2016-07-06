package zhy2002.leetcode.solutions.rangesumquerymutable;

/**
 * Use a bit to partition the nums array.
 */
public class NumArray {

    private int[] bit;
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = new int[nums.length];
        this.bit = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            update(i, nums[i]);
        }
    }

    public void update(int i, int val) {
        int delta = val - nums[i];
        nums[i] = val;
        //i+1 is the index node for nums[i]
        //j&-j isolate the right most 1 bit of j.
        //j+(j&-j) is the next sibling of j or the next sibling of j's parent.
        //if j is xxxx00010, j's next sibling is xxx00100.
        for (int j = i + 1; j < bit.length; j += (j & -j)) {
            bit[j] += delta;
        }
    }

    public int sumRange(int i, int j) {
        return sumFrom0(j) - sumFrom0(i - 1);
    }

    private int sumFrom0(int i) {
        int sum = 0;
        //j-=(j&-j) is the index of the parent of j in BIT.
        for (int j = i + 1; j > 0; j -= (j & -j)) {
            sum += bit[j];
        }
        return sum;
    }

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);

}
