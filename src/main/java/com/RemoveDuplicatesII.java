
// 82. Remove Duplicates from Sorted List II

// Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. 
// Return the linked list sorted as well.

// Input: head = [1,2,3,3,4,4,5]
// Output: [1,2,5]

// Input: head = [1,1,1,2,3]
// Output: [2,3]

// Constraints:

// The number of nodes in the list is in the range [0, 300].
// -100 <= Node.val <= 100
// The list is guaranteed to be sorted in ascending order.

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

public class RemoveDuplicatesII{
    public ListNode deleteDuplicates(ListNode head) {

        //a dummy head to keep track of start point in case the starting elements are duplicates
        ListNode dummy = new ListNode(-101, head);

        //a second head to keep track of last position with all the duplicates removed
        ListNode rmdup_head = dummy;

        while(head != null){
            //check if duplicates exist
            if(head.next != null && head.val == head.next.val)
            {
                //keep parsing till duplicates exist
                while(head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                //point the tracker head to the first non duplicate element
                //this elimanates all the duplicate elements encountered so far
                rmdup_head.next = head.next;
            }
            //if no duplicates found, move the tracking head to next element
            else{
                rmdup_head =rmdup_head.next;
            }
            //move the head to the next element
            head=head.next;
        }
        //the element next to the dummy head is the actual starting point of the list
        return dummy.next;
    }
}