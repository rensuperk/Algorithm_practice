package atOffer;

import java.util.ArrayList;

/**
 * 题目描述
 * 输入一个false，
 * 按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵：
 *  1  2  3  4
 *  5  6  7  8
 *  9 10 11 12
 * 13 14 15 16
 * 则依次打印出数字
 *  1, 2, 3, 4,8,12,16,15,14,13, 9, 5,6, 7,11,10.
 */
public class PrintMatrix {
    public static void main(String[] args) {
        PrintMatrix printMatrix = new PrintMatrix();
        int[][] matrix = {{1, 2}, {4, 3}};
        /**
         * {{ 1, 2, 3, 4},
         *  { 5, 6, 7, 8},
         *  { 9,10,11,12},
         *  {13,14,15,16}};
         */
        int[][] matrix2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printMatrix.printMatrix(matrix2);
    }

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null) {
            return null;
        }
        printMatrix(list, matrix, 0, 0, 0, matrix[0].length - 1, matrix.length, matrix[0].length, 1);
        return list;
    }

    public void printMatrix(ArrayList<Integer> list, int[][] matrix, int startRow, int startColunm, int endRow, int endColunm, int rows, int columns, int flag) {
        if(rows <= 0 || columns <= 0){
            return;
        }
        if (rows == 1 && columns == 1) {
            list.add(matrix[startRow][startColunm]);
            return;
        }
        //从右往左
        if (flag == 3) {
            for (int i = startColunm; i >= endColunm; i--) {
                list.add(matrix[startRow][i]);
            }
            printMatrix(list, matrix, startRow - 1, endColunm, startRow-1-rows+1+1, endColunm, rows - 1, columns, 4);
        }
        if (flag == 1) {
            //从左往右
            for (int i = startColunm; i <= endColunm; i++) {
                list.add(matrix[startRow][i]);
            }

            printMatrix(list, matrix, startRow + 1, endColunm, startRow+1+rows-1-1, endColunm, rows - 1, columns, 2);
        }
            //从下往上
            if (flag == 4) {
                for (int i = startRow; i >= endRow; i--) {
                    list.add(matrix[i][startColunm]);
                }
                printMatrix(list, matrix, endRow, startColunm + 1, endRow, startColunm+1+columns-1-1, rows, columns - 1, 1);
            }
            if (flag == 2) {
                //从上往下
                for (int i = startRow; i <= endRow; i++) {
                    list.add(matrix[i][startColunm]);
                }
            printMatrix(list, matrix, endRow, startColunm - 1, endRow, startColunm-1-columns+1+1, rows, columns - 1, 3);}
        }


}
