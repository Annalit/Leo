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
        int hayHash = 0;
        int needHash = 0;
        int big = BigInteger.probablePrime(31, new Random()).intValue();
        for (int i = 0; i < len_n; i++) {
            hayHash = (hayHash * 256 % big+ haystack.charAt(i)) % big;
            needHash = (needHash* 256 % big + needle.charAt(i)) % big;
        }
        if (hayHash == needHash) {
            return 0;
        }
        for (int i = len_n; i < len_h; i++) {
        	if (i == 7) {
        		int a = 3;
        	}
        	int head = (int) (haystack.charAt(i - len_n) * Math.pow(256, len_n - 1) % big);
            hayHash = (int) (((hayHash - head) * 256 % big + haystack.charAt(i)) % big) % big;
            if (hayHash == needHash) {
                return i - len_n + 1;
            }
        }
        return -1;
    }
}
