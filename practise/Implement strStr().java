import java.math.BigInteger;
import java.util.Random;
public class Solution {
   public static int strStr(String haystack, String needle) {
       if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        int n = haystack.length();
        int m = needle.length();
        if(n < m)
            return 0;
        long hayHash = 0, needHash = 0, highest = 1;
        int d = 256, q = 101;
        
        for(int i = 0; i < m-1; i++)
            highest = (highest * d) % q;
        for(int i = 0; i < m; i++) {
            hayHash = (hayHash * d + haystack.charAt(i)) % q;
            needHash = (needHash * d + needle.charAt(i)) % q;
        }
        
        for(int i = 0; i <= n-m; i++) {
            if(hayHash == needHash) {
                boolean flag = true;
                for(int j = 0; j < m; j++) {
                    if(haystack.charAt(i+j) != needle.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if(flag == true)
                    return i;
            }
            else {
                if(i < n-m) {
                    hayHash = ((hayHash - haystack.charAt(i) * highest) * d + haystack.charAt(i+m)) % q;
                }
                if(hayHash < 0)
                    hayHash = hayHash + q;
            }
        }
        
        return -1;
    }
}

public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        int len_h = haystack.length();
        int len_n = needle.length();
        if (len_h == 0 && len_n == 0) {
            return 0;
        }
        long hayHash = 0;
        long needHash = 0;
        //long big = BigInteger.probablePrime(33, new Random()).longValue();
        //long big = Integer.MAX_VALUE;//
        long big = 101;
        for (int i = 0; i < len_n; i++) {
            hayHash = (hayHash * 256+ haystack.charAt(i)) % big;
            needHash = (needHash * 256+ needle.charAt(i)) % big;
        }
        if (hayHash == needHash) {
            return 0;
        }
        long highest = 1;
        for (int j = 0; j < len_n - 1; j++) {
                highest = highest * 256 % big;
        }

        for (int i = len_n; i < len_h; i++) {
            long head = (long)((haystack.charAt(i - len_n) % big * highest % big));
            hayHash = (long)(((hayHash - head) * 256 % big + haystack.charAt(i)) % big);
            if (hayHash == needHash) {
                return i - len_n + 1;
            }
        }
        return -1;
    }
