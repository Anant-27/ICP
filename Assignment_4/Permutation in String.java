import java.util.*;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int[] s1count = new int[26];
        int[] s2count = new int[26]; 
        for (char ch : s1.toCharArray()) {
            s1count[ch - 'a']++;
        }
        int m = s1.length();
        for (int i = 0; i < s2.length(); i++) {
            s2count[s2.charAt(i) - 'a']++; 

            if (i >= m) { 
                s2count[s2.charAt(i - m) - 'a']--;
            }
            if (Arrays.equals(s1count, s2count)) {
                return true;
            }
        }
        return false;
    }


  
    /*
     * Time Complexity: 
     *   - O(n * 26) ≈ O(n), where n = length of s2
     *   - Because for each step we compare two arrays of size 26
     * 
     * Space Complexity:
     *   - O(26) = O(1), constant extra space (two frequency arrays)
     */


    // Example 1:
        // Input: s1 = "ab", s2 = "eidbaooo"
        // Output: true
        // Explanation: s2 contains one permutation of s1 ("ba")

  // Example 2:
        // Input: s1 = "ab", s2 = "eidboaoo"
        // Output: false
