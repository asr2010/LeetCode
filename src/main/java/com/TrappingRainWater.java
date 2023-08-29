package com;
// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

// Example 1:


// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
// Example 2:

// Input: height = [4,2,0,3,2,5]
// Output: 9
 

// Constraints:

// n == height.length
// 1 <= n <= 2 * 104
// 0 <= height[i] <= 105

public class TrappingRainWater {
    public int trap(int[] height) {

        //start with two pointers on the extreme ends to mark the limits of the container
        int left = 0;
        int right = height.length-1;

        //keep track of the highest wall on both ends as they marks the containers bottleneck
        int leftMax= height[0];
        int rightMax = height[right];

        //to store the cumulative capacity of the container
        int ans = 0;

        //keeping moving till the poonters overlap
        while(left<right){
            //move the pointer that stores the smaller wall, as water will spill over the smaller side
            if(leftMax < rightMax){
                
                left +=1;
                //update the leftmax wall height
                leftMax = Math.max(leftMax, height[left]);

                //the amount of water that can be stored at that given point
                ans += leftMax-height[left];
            }
            else
            {
                
                right -=1;
                //update the rightmax wall height
                rightMax = Math.max(rightMax, height[right]);
                
                //the amount of water that can be stored at that given point
                ans +=rightMax-height[right];
            }
        }
        
        return ans;
        
    }
}
