package partArray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-08-30
 * Time : 오전 9:45
 * Title : Rotate Image
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num48 {
    public void rotate(int[][] matrix) {

        int xMax = matrix[0].length - 1;
        int yMax = matrix.length - 1;

        for (int i = 0; i <= yMax / 2; i++) {
            for (int j = 0; j < (xMax + 1) / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[yMax - j][i];
                matrix[yMax - j][i] = matrix[yMax - i][xMax - j];
                matrix[yMax - i][xMax - j] = matrix[j][xMax - i];
                matrix[j][xMax - i] = tmp;
            }
        }
    }

    @Test
    void 테스트(){
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(arr);
        Assertions.assertArrayEquals(new int[][]{{7,4,1},{8,5,2},{9,6,3}}, arr);
    }
}
