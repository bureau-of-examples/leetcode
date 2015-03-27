package zhy2002.leetcode.solutions.medianoftwosortedarrays;

/**
 * Similar to MedianSolution but has no solveTrivial helper function.
 */
public class MedianNoTrivialSolution implements Solution{

    @Override
    public double findMedianSortedArrays(int[] A, int[] B) {
        //try to find lower and upper median together
        int startA = 0, endA = A.length - 1;
        int startB = 0, endB = B.length - 1;

        while (true) {
            if (startA > endA)
                return findMedian(B, startB, endB);

            if (startB > endB)
                return findMedian(A, startA, endA);

            if (startA == endA && startB == endB) {
                return ((double) A[startA] + B[startB]) / 2;
            }

            int lmA = (startA + endA) >> 1;
            int umA = (startA + endA + 1) >> 1;
            int lmB = (startB + endB) >> 1;
            int umB = (startB + endB + 1) >> 1;

            if (lmA == umA) {
                if (lmB == umB) {
                    if (A[lmA] == B[lmB])
                        return A[lmA];
                    if (A[lmA] < B[lmB]) {
                        int left = lmA - startA;
                        if (left == 0) {
                            if (A[lmA] < B[startB]) {
                                startA++;
                                endB--;
                            } else {
                                startB++;
                                endB--;
                            }
                            continue;
                        }
                        int right = endB - lmB;
                        if (right == 0) {
                            if (B[lmB] > A[endA]) {
                                endB--;
                                startA++;
                            } else {
                                startA++;
                                endA--;
                            }
                            continue;
                        }
                        int cut = Math.min(left, right);
                        startA += cut;
                        endB -= cut;
                    } else {
                        int left = lmB - startB;
                        if (left == 0) {
                            if (B[lmB] < A[startA]) {
                                startB++;
                                endA--;
                            } else {
                                startA++;
                                endA--;
                            }
                            continue;
                        }
                        int right = endA - lmA;
                        if (right == 0) {
                            if (A[lmA] > B[endB]) {
                                endA--;
                                startB++;
                            } else {
                                startB++;
                                endB--;
                            }
                            continue;
                        }
                        int cut = Math.min(left, right);
                        startB += cut;
                        endA -= cut;
                    }
                } else {
                    if (A[lmA] == B[lmB] || A[lmA] == B[lmB] || A[lmA] > B[lmB] && A[lmA] < B[umB])
                        return A[lmA];
                    if (A[lmA] < B[lmB]) {
                        int left = lmA - startA + 1;
                        int right = endB - lmB;
                        int cut = Math.max(1, Math.min(left, right));
                        startA += cut;
                        endB -= cut;
                    } else {
                        int left = lmB - startB;
                        int right = endA - lmA + 1;
                        int cut = Math.max(1, Math.min(left, right));
                        startB += cut;
                        endA -= cut;
                    }
                }
            } else {
                if (lmB == umB) {
                    if (B[lmB] == A[lmA] || B[lmB] == A[umA] || B[lmB] > A[lmA] && B[lmB] < A[umA])
                        return B[lmB];
                    if (B[lmB] < A[lmA]) {
                        int left = lmB - startB + 1;
                        int right = endA - lmA;
                        int cut = Math.max(1, Math.min(left, right));
                        startB += cut;
                        endA -= cut;
                    } else {
                        int left = lmA - startA;
                        int right = endB - lmB + 1;
                        int cut = Math.max(1, Math.min(left, right));
                        startA += cut;
                        endB -= cut;
                    }
                } else {
                    if (A[lmA] == B[umB])
                        return A[lmA];
                    if (A[umA] == B[lmB])
                        return A[umA];
                    if (A[lmA] == B[lmB] && A[umA] == B[umB])
                        return ((double) A[lmA] + A[umA]) / 2;
                    if (A[lmA] < B[umB]) {
                        int left = lmA - startA;
                        if (left == 0) {
                            if (A[lmA] < B[lmB]) {
                                startA++;
                                if(B[endB] > A[umA])
                                    endB--;
                                else
                                    endA--;
                            } else if (A[umA] < B[umB]) {
                                startB++;
                                endB--;
                            } else {
                                endA--;
                                startB++;
                            }
                            continue;
                        }
                        int right = endB - umB;
                        if (right == 0) {
                            if (B[umB] > A[umA]) {
                                startA++;
                                if(A[endA] > B[umB])
                                    endA--;
                                else
                                    endB--;
                            } else if (B[lmB] > A[lmA]) {
                                startA++;
                                endA--;
                            } else {
                                endA--;
                                startB++;
                            }
                            continue;
                        }
                        int cut = Math.min(left, right);
                        startA += cut;
                        endB -= cut;
                    } else {
                        int left = lmB - startB;
                        int right = endA - lmA;
                        int cut = Math.max(1, Math.min(left, right));
                        startB += cut;
                        endA -= cut;
                    }
                }
            }

        }

    }

    private double findMedian(int[] array, int start, int end) {
        int lowerMedian = (start + end) >> 1;
        int upperMedian = (start + end + 1) >> 1;
        if (lowerMedian == upperMedian)
            return array[lowerMedian];
        return ((double) array[lowerMedian] + array[upperMedian]) / 2.0;
    }
}
