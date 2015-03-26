package zhy2002.leetcode.solutions.medianoftwosortedarrays;

/**
 * Implement find kth statistics, then calculate the mean of the upper and lower medians.
 */
public class KthStatisticsSolution implements Solution{

    @Override
    public double findMedianSortedArrays(int A[], int B[]) {
        int totalLen = A.length + B.length;
        int lowIndex = (totalLen - 1) / 2;
        int highIndex = totalLen / 2;
        int lowMedian = findMinKth(A, B, lowIndex + 1);
        if (highIndex == lowIndex)
            return lowMedian;
        int highMedian = findMinKth(A, B, highIndex + 1);
        return (0.0 + lowMedian + highMedian) / 2.0;//0.0 + -> avoid overflow
    }

    public int findMinKth(int A[], int B[], int k) {
        if (k <= 0 || k > A.length + B.length)
            throw new IllegalArgumentException("k");

        int startA = 0, endA = Math.min(k - 1, A.length - 1);//the last possible index of kth statistics is k-1
        int startB = 0, endB = Math.min(k - 1, B.length - 1);
        int findK = k;
        while (true) {
            if (startA > endA)//kth statistics is not in the other array
                return B[startB + findK - 1];
            if (startB > endB)
                return A[startA + findK - 1];

            int lowerA = (startA + endA) >>> 1;//this partitions the two lists best
            int upperB = (startB + endB + 1) >>> 1;
            int bottomCount = (lowerA - startA) + (upperB - startB) + 1; //how many items are below max(A[lowerA], B[upperB])
            //int topCount = (endB - startB + 1) + (endA - startA + 1) - bottomCount;
            if (A[lowerA] <= B[upperB]) {
                if (findK <= bottomCount) {
                    endB = upperB - 1;
                } else {
                    findK -= lowerA - startA + 1;
                    startA = lowerA + 1;
                }
            } else {
                if (findK <= bottomCount) {
                    endA = lowerA - 1;
                } else {
                    findK -= upperB - startB + 1;
                    startB = upperB + 1;
                }
            }
        }
    }
}
