import java.util.*;

class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] count = new int[26];
        int left = 0;
        int max = 0;      
        int maxLen = 0;
        for (int right = 0; right < n; right++) {
            count[s.charAt(right) - 'A']++;
            max = Math.max(max, count[s.charAt(right) - 'A']);
            while ((right - left + 1) - max > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}



/*
-----------------------------------------------------
Time Complexity (TC):
TC = O(n) 
Each character is processed at most twice (once by right pointer, once by left pointer), n = s.length().

Space Complexity (SC):
SC = O(1) 
(only a fixed-size array of length 26 for character counts).

-----------------------------------------------------
Example Test Cases:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Longest substring after at most 1 replacement → "AABA" or "ABBA".

Input: s = "ABAB", k = 2
Output: 4
Explanation: Can replace 2 characters to make entire string same → "AAAA" or "BBBB".

Input: s = "AAAA", k = 0
Output: 4
Explanation: Already all same, no replacements needed.

Input: s = "ABCDE", k = 1
Output: 2
Explanation: Can replace 1 character to match another → longest substring length = 2.
-----------------------------------------------------
*/
