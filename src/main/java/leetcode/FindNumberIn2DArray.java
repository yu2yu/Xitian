package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        return findNumberIn2DArray(matrix, target, 0, 0);
    }


    public boolean findNumberIn2DArray(int[][] matrix, int target, int row, int column) {
        if (matrix == null || row >= matrix.length  || column >= matrix[0].length) return false;
        if (matrix[row][column] == target) return true;
        else if (matrix[row][column] > target) return false;
        else {
            return findNumberIn2DArray(matrix, target, row + 1, column) || findNumberIn2DArray(matrix, target, row, column + 1);
        }
    }

    public boolean findNumberIn2DArrayTwo(int[][] matrix, int target) {
        int i = matrix.length - 1,j = 0;
        while (i >= 0 && j < matrix[0].length){
            if(matrix[i][j] > target) i--;
            else if(matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }



    @Test
    @DisplayName("二维数组中的查找")
    public void testFindNumberIn2DArray() {
        int[][] ints = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        System.out.println(findNumberIn2DArray(ints, 20));
    }
}
