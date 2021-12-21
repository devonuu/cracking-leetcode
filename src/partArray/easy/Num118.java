package partArray.easy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-12-21
 * Time : 오후 9:26
 * Title : Pascal's Triangle
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for (int i = 0; i < numRows; i++)
        {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++)
                row.set(j, row.get(j) + row.get(j + 1));
            allrows.add(new ArrayList<Integer>(row));
        }
        return allrows;
    }
}
