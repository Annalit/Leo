
public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0) {
            return "";
        }
        HashMap<Character, Integer> std  = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            char temp = t.charAt(i);
            if (std.containsKey(temp)) {
                std.put(temp, std.get(temp) + 1);
            } else {
                std.put(temp, 1);
            }
        }
        int left = 0, right = 0, count = 0;
        StringBuffer res = new StringBuffer();
        HashMap<Character, Integer> hm  = new HashMap<Character, Integer>();
        while (right < s.length()) {
            char cur = s.charAt(right);
            if (std.containsKey(cur)) {
                if (hm.containsKey(cur)) {
                    if (hm.get(cur) < std.get(cur)) {
                        count++;
                    }
                    hm.put(cur, hm.get(cur) + 1);
                } else {
                    hm.put(cur, 1);
                    count++;
                }
            }
            if (count == t.length()) {
                while (left <= right) {
                    char temp = s.charAt(left);
                    if (res.length() == 0 || res.length() >(right - left + 1)) {
                    	res.setLength(0);
                    	res.append(s.substring(left, right + 1));
                    }
                    if (std.containsKey(temp)) {
                        hm.put(temp, hm.get(temp) - 1);
                        if (hm.get(temp) < std.get(temp)) {
                            left++;
                            count--;
                            while (left <= right && !std.containsKey(s.charAt(left)))
                                left++;
                            break;
                        }
                    }
                    left++;
                }
            }
            right++;
         }
            return res.toString();
    }
}
