package partString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-08-23
 * Time : 오전 10:52
 * Title : Group Anagrams
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            int[] alpha = new int[26];
            for (int j = 0; j < str.length(); j++) {
                alpha[str.charAt(j) - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (alpha[j] > 0){
                    key.append((char)('a' + j)).append(alpha[j]);
                }
            }
            if (!map.containsKey(key.toString())){
                map.put(key.toString(), new ArrayList<>());
            }
            map.get(key.toString()).add(str);
        }
        List<List<String>> answer = new ArrayList<>();
        for (List<String> value : map.values()) {
            answer.add(value);
        }
        return answer;
    }
}
