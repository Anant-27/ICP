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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null; 
        }
        ListNode curr = head;
        while(curr != null && curr.next != null){
            if(curr.val == curr.next.val){
                curr.next = curr.next.next; 
            } else {
                curr = curr.next; 
            }
        }
        return head;
    }

  
/*

Time Complexity: O(n)
We traverse the linked list once, where n = number of nodes.
Space Complexity: O(1)
We do it in-place without using extra space.

*/

    /*
    Test Cases:

    1. Normal case with duplicates
       Input: head = [1,1,2,3,3]
       Output: [1,2,3]

    2. No duplicates
       Input: head = [1,2,3]
       Output: [1,2,3]

    3. All duplicates
       Input: head = [1,1,1,1]
       Output: [1]

    4. Single node
       Input: head = [1]
       Output: [1]

    5. Empty list
       Input: head = []
       Output: []
    */
}
