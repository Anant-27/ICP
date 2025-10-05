class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n<2){
            return nums[0];
        }
        int[] dp= new int[nums.length];

        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);

        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[nums.length-1];
    }
}


/*
House Robber — Dynamic Programming Approach:

Time Complexity: O(n)
   → We traverse the array once.

Space Complexity: O(n)
   → DP array stores maximum loot at each house.

Can be optimized to O(1) space using two variables instead of a DP array.
*/



/*
Example 1:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then house 3 (money = 3). Total = 4.


Example 2:
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob houses 1, 3, and 5 for maximum loot = 2 + 9 + 1 = 12.
*/
