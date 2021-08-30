package partArray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-08-30
 * Time : 오전 11:28
 * Title : Search a 2D Matrix
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int yMax = matrix.length - 1;
        int xMax = matrix[0].length - 1;

        while (row <= yMax){
            if (matrix[row][xMax] == target) return true;
            else if (matrix[row][xMax] < target) row++;
            else{
                int start = 0;
                while (start <= xMax){
                    int mid = (start + xMax) / 2;
                    if (matrix[row][mid] == target) return true;
                    else if (matrix[row][mid] > target) xMax = mid - 1;
                    else start = mid + 1;
                }
                break;
            }
        }
        return false;
    }

    @Test
    void 테스트(){
        Assertions.assertEquals(true, searchMatrix(new int[][]{{1,3,5}}, 1));
    }
}
