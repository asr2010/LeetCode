// 41. First Missing Positive

// Given an unsorted integer array nums, return the smallest missing positive integer.

// You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

 

// Example 1:

// Input: nums = [1,2,0]
// Output: 3
// Explanation: The numbers in the range [1,2] are all in the array.
// Example 2:

// Input: nums = [3,4,-1,1]
// Output: 2
// Explanation: 1 is in the array but 2 is missing.
// Example 3:

// Input: nums = [7,8,9,11,12]
// Output: 1
// Explanation: The smallest positive integer 1 is missing.
 

// Constraints:

// 1 <= nums.length <= 105
// -231 <= nums[i] <= 231 - 1

package com;

import java.util.Arrays;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        //nums = [1,2,5,3]
        
        //get the array length to figure out biggest possible missing +ve integer
        //n  =4
        int n = nums.length;

        //check if 1 is present
        //if 1 is not present, return 1
        if(Arrays.stream(nums).noneMatch(x -> x == 1))
        {
            return 1;
        }
        //clean the array of all non +ve numbers and numbers greater than n by replacing them with 1
        //we replace with 1 because we already know by now that 1 is not the first missing positive 
        // nums[1,2,5,3] => nums = [1,2,1,3]
        for(int i=0; i<n; i++){
            if(nums[i] <= 0 || nums[i]>n){
                nums[i] = 1;
            }
        }
        //update the array values in a way that the index represented by every value in array is negated
        //if the value is already negative, dont update it
        //nums[1,2,1,3] => nums[1,-2,-1,-3]
        for(int i=0; i<n; i++){
            int pos = Math.abs(nums[i]%n);
            nums[pos] = -1 * Math.abs(nums[pos]);
        }

        //check for first non negative occurence starting from index 1
        //-ve value implies that the number equivalent to that index is present
        //starting from 1 because index 1 represent the presence of number 1 and so on
        //this will check from 1 -> n-1
        for(int i=1; i<n;i++){
            if(nums[i] > 0){
                return i;
            }
        }
        // check the presence of nth number
        if(nums[0]>0){
            return n;
        }
        //if all 1 -> n are present, return the next number in sequence
        return n+1;
        
    }
}
