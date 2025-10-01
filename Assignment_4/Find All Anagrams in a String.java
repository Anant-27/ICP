import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        int[] pcount = new int[26];
        int[] scount = new int[26];
        for (char ch : p.toCharArray()) {
            pcount[ch - 'a']++;
        }
        int m = p.length();
        for (int i = 0; i < s.length(); i++) {
            scount[s.charAt(i) - 'a']++;
            if (i >= m) {
                scount[s.charAt(i - m) - 'a']--;
            }
            if (Arrays.equals(pcount, scount)) {
                result.add(i - m + 1);
            }
        }
        return result;
    }
}


/*
-----------------------------------------------------
Time Complexity (TC):
TC = O(n) 
where n = s.length(). Each index is processed once, and comparing frequency arrays costs O(26) = O(1).

Space Complexity (SC):
SC = O(1) 
(fixed 26-length arrays for counts) + O(k) for result storage (k = number of anagram indices).

-----------------------------------------------------
Example Test Cases:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation: Anagrams "cba" and "bac" found at indices 0 and 6.

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation: Substrings "ab", "ba", "ab" are all anagrams.

Input: s = "af", p = "be"
Output: []
Explanation: No substring of length 2 matches.

Input: s = "a", p = "ab"
Output: []
Explanation: s length < p length, so no result.
-----------------------------------------------------
*/
