package zhy2002.amazalgo2;

import java.util.Scanner;


public class Lock {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int h = scanner.nextInt();
        int w = scanner.nextInt();
        int r = scanner.nextInt();

        int[][] matrix = new int[h][w];
        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

//        int r = 2;
//        int[][] matrix = new int[][] {
//                {1, 2 ,3 ,4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},
//                {13, 14, 15, 16}
//        };
//        int h = matrix.length;
//        int w = matrix[0].length;

        rotate(h, w, r, matrix);

        for (int i=0; i<h; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<w; j++) {
                sb.append(matrix[i][j] + " ");
            }
            System.out.println(sb.toString());
        }
    }

    private static void rotate(int h, int w, int r, int[][] matrix) {
        int layerCount = Math.min(h, w) / 2;

        int top = 0;
        int bottom = h - 1;
        int left = 0;
        int right = w - 1;

        //rotate each layer
        for (int l = 0; l < layerCount; l++) {
            int layerSize = (right - left) * 2 + (bottom - top) * 2;
            int rCount = r % layerSize;

            int[] buffer = new int[layerSize];
            int index = 0;
            for (int i = top; i<bottom; i++) {
                buffer[index++] = matrix[i][left];
            }
            for (int i = left; i<right; i++) {
                buffer[index++] = matrix[bottom][i];
            }
            for (int i = bottom; i>top; i--) {
                buffer[index++] = matrix[i][right];
            }
            for (int i = right; i>left; i--) {
                buffer[index++] = matrix[top][i];
            }

            index = 0;
            for (int i = top; i<bottom; i++) {
                matrix[i][left] = buffer[(index++ - rCount + layerSize) % layerSize];
            }
            for (int i = left; i<right; i++) {
                matrix[bottom][i] = buffer[(index++ - rCount + layerSize) % layerSize];
            }
            for (int i = bottom; i>top; i--) {
                matrix[i][right] = buffer[(index++ - rCount + layerSize) % layerSize];
            }
            for (int i = right; i>left; i--) {
                matrix[top][i] = buffer[(index++ - rCount + layerSize) % layerSize];
            }

            top++;
            bottom--;
            left++;
            right--;
        }
    }
}
