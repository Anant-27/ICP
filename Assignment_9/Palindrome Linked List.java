/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list=new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head=head.next;
        }
        int left=0;
        int right=list.size()-1;
        while(left<=right){
            if(list.get(left)!=list.get(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }



  
    /*
    Time Complexity: O(n) → traverse linked list + compare half elements
    Space Complexity: O(n) → extra list to store elements
    

    Test Cases:
    1. head = [1,2,2,1] → true
    2. head = [1,2] → false
    3. head = [1,2,1] → true
    4. head = [1] → true
    5. head = [] → true
    */
}
