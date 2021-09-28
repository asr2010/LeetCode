package Problems;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    
		ListNode dummyHead = new ListNode(0);
		
		ListNode firstNumber = l1, secondNumber = l2, current = dummyHead;
		int carry=0;
		
		while(firstNumber != null || secondNumber != null)
		{
			int x = (firstNumber != null)?firstNumber.val : 0;
			int y = (secondNumber != null)?secondNumber.val : 0;
			int sum = x+y+carry;
			carry = sum/10;
			current.next = new ListNode(sum%10);
			current = current.next;
			
			if(firstNumber != null)
			{
				firstNumber = firstNumber.next;
			}
			if(secondNumber != null)
			{
				secondNumber = secondNumber.next;
			}
		}
		if(carry>0)
		{
			current.next = new ListNode(carry);
		}
		
		return dummyHead.next;
    }

}
