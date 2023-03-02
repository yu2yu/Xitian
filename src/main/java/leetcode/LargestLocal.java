package leetcode;

/**
 * 给你一个大小为 n x n 的整数矩阵 grid 。
 *
 * 生成一个大小为(n - 2) x (n - 2) 的整数矩阵 maxLocal ，并满足：
 *
 * maxLocal[i][j] 等于 grid 中以 i + 1 行和 j + 1 列为中心的 3 x 3 矩阵中的 最大值 。
 * 换句话说，我们希望找出 grid 中每个3 x 3 矩阵中的最大值。
 *
 * 返回生成的矩阵。
 */
public class LargestLocal {

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] result = new int[n-2][n-2];
        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < n - 2; j++) {
                int max = grid[i][j];
                for (int k = i; k < i+3; k++) {
                    for (int l = j; l < j+3; l++) {
                        max = Math.max(max,grid[k][l]);
                    }
                }
                result[i][j] = max;
            }
        }
        return result;
    }

}
