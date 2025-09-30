import java.util.*;

class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int zeros = 0;
        int maxLen = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] == 0) {
                zeros++;
            }
            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
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
(each element is visited at most twice by left and right pointers).

Space Complexity (SC):
SC = O(1) 
(only counters used, no extra data structures).

-----------------------------------------------------
Example Test Cases:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: Longest subarray after flipping at most 2 zeros → [1,1,1,0,0,1,1,1,1,1,1]

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: Longest subarray length is 10 after flipping 3 zeros.

Input: nums = [1,1,1,1], k = 0
Output: 4
Explanation: No flips needed, all ones.

Input: nums = [0,0,0,0], k = 2
Output: 2
Explanation: Can flip at most 2 zeros, so max length = 2.
-----------------------------------------------------
*/
