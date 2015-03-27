package zhy2002.leetcode.solutions.medianoftwosortedarrays;


public class MedianSolution implements Solution {

    public double findMedianSortedArrays(int[] A, int[] B) {
        //try to find lower and upper median together
        int startA = 0, endA = A.length - 1;
        int startB = 0, endB = B.length - 1;

        while (true) {
            if (endA - startA <= 1)
                return solveTrivial(B, startB, endB, A, startA, endA);

            if (endB - startB <= 1)
                return solveTrivial(A, startA, endA, B, startB, endB);

            int lmA = (startA + endA) >>> 1;
            int umA = (startA + endA + 1) >>> 1;
            int lmB = (startB + endB) >>> 1;
            int umB = (startB + endB + 1) >>> 1;

            if (lmA == umA) {
                if (lmB == umB) {
                    if (A[lmA] == B[lmB])
                        return A[lmA];
                    if (A[lmA] < B[lmB]) {
                        int left = lmA - startA;
                        int right = endB - lmB;
                        int cut = Math.min(left, right);
                        startA += cut;
                        endB -= cut;
                    } else {
                        int left = lmB - startB;
                        int right = endA - lmA;
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
                        int cut = Math.min(left, right);
                        startA += cut;
                        endB -= cut;
                    } else {
                        int left = lmB - startB;
                        int right = endA - lmA + 1;
                        int cut = Math.min(left, right);
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
                        int cut = Math.min(left, right);
                        startB += cut;
                        endA -= cut;
                    } else {
                        int left = lmA - startA;
                        int right = endB - lmB + 1;
                        int cut = Math.min(left, right);
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
                        int right = endB - umB;
                        int cut = Math.min(left, right);
                        startA += cut;
                        endB -= cut;
                    } else {
                        int left = lmB - startB;
                        int right = endA - lmA;
                        int cut = Math.min(left, right);
                        startB += cut;
                        endA -= cut;
                    }
                }
            }

        }

    }

    //cases when assume endB - startB <= 2
    private double solveTrivial(int[] A, int startA, int endA, int[] B, int startB, int endB){

        int lenB = endB - startB + 1;
        int lenA = endA - startA + 1;
        if(lenA <= 0){
            if(lenB == 1)
                return B[startB];
            else
                return ((double)B[startB] + B[endB]) / 2;
        }

        if(lenB <= 0){
            int lmIndex = (startA + endA) >>> 1;
            int umIndex = (startA + endA + 1) >>> 1;
            if(lmIndex == umIndex)
                return A[lmIndex];
            return ((double)A[lmIndex] + A[umIndex]) / 2;
        }

        if(lenA == 1){
            if(lenB == 1)
                return ((double)A[startA] + B[startB]) / 2;
            else
                return Math.min(Math.max(A[startA], B[startB]), B[endB]);
        }

        if(lenA == 2){
            if(lenB == 1)
                return Math.min(Math.max(B[startB], A[startA]), A[endA]);
            else
                return ((double)Math.max(A[startA], B[startB]) + Math.min(A[endA], B[endB])) / 2;
        }

        //lenA > 2 - binary search position of B[startB] in A
        int lmIndex = startA + (endA - startA + lenB) / 2;
        int umIndex = startA + (endA - startA + lenB + 1) / 2;
        int posStartB = findIndex(A, startA, endA, B[startB]);
        int posEndB = endB == startB ? Integer.MAX_VALUE : findIndex(A, posStartB + 1, endA, B[endB]);
        int lm = findValue(A, lmIndex, posStartB, B[startB], posEndB, B[endB]);
        if(umIndex == lmIndex)
            return lm;
        int um = findValue(A, umIndex, posStartB, B[startB], posEndB, B[endB]);
        return ((double)lm + um) / 2;
    }

    //find value in list A + startVal + endVal
    private int findValue(int[] A, int index, int posStartB, int startVal, int posEndB, int endVal) {
        if(index <= posStartB)
            return A[index];
        if(index == posStartB + 1)
            return startVal;
        if(index - 1 <= posEndB)
            return A[index - 1];
        if(index - 1 == posEndB + 1)
            return endVal;
        return A[index - 2];
    }

    //binary search for position that target should be inserted after
    private int findIndex(int[] A, int startA, int endA, int target){
        while (startA <= endA){
            int mid = (startA + endA) >>> 1;
            if(A[mid] == target)
                return mid;
            if(A[mid] > target)
                endA = mid - 1;
            else
                startA = mid + 1;
        }
        return endA;
    }



}
