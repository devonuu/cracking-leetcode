package partArray;
/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-08-30
 * Time : 오전 11:43
 * Title : Search a 2D Matrix II
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int y = matrix.length - 1;
        int x = 0;
        while (x < matrix[0].length && y >= 0){
            if (matrix[y][x] == target) return true;
            else if (matrix[y][x] > target) y--;
            else x++;
        }
        return false;
    }
}
