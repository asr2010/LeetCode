package Problems;

import java.util.*;

public class TwoSum {
	public static void main(String[] args)
	{
		int[] set= {1,2,3,4,5,6};
		int target = 7;
		TwoSum twoSum =new TwoSum();
		int[] result= twoSum.checkTwoSum(set, target);
		
		System.out.println(Arrays.toString(result));
	}
	public int[] checkTwoSum(int[] numbers, int target)
	{
		Map<Integer, Integer> complementSet = new HashMap<Integer, Integer>();
		for(int i=0;i<numbers.length;i++)
		{
			
			if(complementSet.containsKey(numbers[i]))
			{
				return new int[] {complementSet.get(numbers[i]), i};
			}
			else
			{
				complementSet.put(target-numbers[i], i);
			}
		}
		return new int[] {-1,-1};
	}
}
