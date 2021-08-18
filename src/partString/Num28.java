package partString;
/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-08-18
 * Time : 오전 9:52
 * Title : Implement strStr()
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num28 {

    public int strStr(String haystack, String needle) {
        //hash code를 이용한 Rabin-Karp 방법.
        //O(N)의 시간 복잡도를 가진다.
        int needleHash = needle.hashCode();
        int needleLen = needle.length();
        int startIndex = 0;
        if (needle.isEmpty() || needle.equals(haystack)) {
            return 0;
        }
        while (startIndex + needleLen <= haystack.length()) {
            String sub = haystack.substring(startIndex, startIndex + needleLen);
            int stackHash = sub.hashCode();
            if (needleHash == stackHash) {
                boolean isEqual = true;
                for (int i = 0; i < needleLen; i++) {
                    if (needle.charAt(i) != sub.charAt(i)) {
                        isEqual = false;
                        break;
                    }
                }
                if (isEqual)
                    return startIndex;
            }
            startIndex++;
        }
        return -1;
    }
}

