import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        int left = 0;
        HashSet<Character> set = new HashSet<>();
        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}

/*
-----------------------------------------------------
Time Complexity (TC):
TC = O(n).

Space Complexity (SC):
SC = O(min(n, charset_size)).

-----------------------------------------------------
✅ Example Test Cases:

Input: "abcabcbb"
- Step: "abc" → maxLen = 3
- Output: 3

Input: "bbbbb"
- Step: longest unique substring = "b"
- Output: 1

Input: "pwwkew"
- Step: longest unique substring = "wke"
- Output: 3

Input: ""
- Empty string → maxLen = 0
- Output: 0

Input: "au"
- Longest unique substring = "au"
- Output: 2
-----------------------------------------------------
*/
