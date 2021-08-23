package partString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-08-23
 * Time : 오전 10:28
 * Title : Add Strings
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num415 {
    public String addStrings(String num1, String num2) {
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();

        int pointer1 = num1.length() - 1;
        int pointer2 = num2.length() - 1;
        int carry = 0;
        List<Integer> list = new ArrayList<>();
        while (pointer1 >= 0 || pointer2 >= 0){
            int sum = carry;
            if (pointer1 >= 0){
                sum += arr1[pointer1--] - '0';
            }
            if (pointer2 >= 0){
                sum += arr2[pointer2--] - '0';
            }

            carry = sum / 10;
            sum %= 10;
            list.add(sum);
        }
        if (carry > 0) list.add(carry);
        StringBuilder builder = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            builder.append(list.get(i));
        }
        return builder.toString();
    }
}
