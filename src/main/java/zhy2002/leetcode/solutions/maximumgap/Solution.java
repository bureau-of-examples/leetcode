package zhy2002.leetcode.solutions.maximumgap;

/**
 * https://leetcode.com/problems/maximum-gap/
 * Question discussion page: https://leetcode.com/discuss/oj/maximum-gap
 * The general idea is allocate enough bucket such that putting all values in buckets will always leave some buckets empty.
 * Then the max gap will span an empty bucket.
 */
public class Solution {

    //get the max(a[i]-a[i-1]) where a is num sorted
    public int maximumGap(int[] num) {
        //trivial
        if (num == null || num.length < 2)
            return 0;

        //find max, min and range
        long min = num[0];
        long max = num[0];
        for (int i = 1; i < num.length; i++) {
            if (num[i] > max)
                max = num[i];
            else if (num[i] < min)
                min = num[i];
        }
        long range = max - min + 1; //could overflow int

        //divide range of [min, max] into num.length + 1 buckets
        //this way at least 1 bucket will be empty when all values are in place
        long numLenPlus1 = num.length + 1;
        int bucketCount = (int)numLenPlus1;
        //if range % bucketCount == 0 it is ok otherwise add one more bucket
        //e.g. range = 17 and bucketCount = 4 then every block of 4 is put in the same bucket but the last value in range should be put in yet another bucket
        if (range % bucketCount != 0)
            bucketCount++;
        //buckets[i] and buckets[i+1] forms a bucket, where i is even
        Integer[] buckets = new Integer[bucketCount * 2];//or use int[] and represent min / max as shift from bucket start, init items in int[] to -1

        for (int val : num) {
            //the allocate below guarantees bucket size at most differ by 1
            int buckIndex = (int) ((val - min) * numLenPlus1 / range); //cannot use (val - min) / bucketSize because it does not handle range < bucketCount as bucketSize is defined as range/bucketCount
            int minIndex = buckIndex << 1;//times 2 to find the lower bound cell for the bucket
            int maxIndex = minIndex + 1; //the next is the upper bound for the cell
            //populate the bucket: push lower bound <<< and >>> upper bound
            if (buckets[minIndex] == null) {
                buckets[minIndex] = val;
                buckets[maxIndex] = val;
            } else {
                if (val < buckets[minIndex]) {
                    buckets[minIndex] = val;
                } else if (val > buckets[maxIndex]) {
                    buckets[maxIndex] = val;
                }
            }
        }

        //loop through buckets, at least one must be empty in (first_bucket, last_bucket)
        int result = 0;
        int maxSoFar = buckets[1];
        for (int i = 1; i < bucketCount; i++) {
            int minIndex = i << 1;
            if (buckets[minIndex] != null) {
                int gap = buckets[minIndex] - maxSoFar;
                if (gap > result)
                    result = gap;
                maxSoFar = buckets[minIndex + 1];
            }
        }
        return result;
    }
}
