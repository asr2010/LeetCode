// 135. Candy
// Hard

// There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

// You are giving candies to these children subjected to the following requirements:

// Each child must have at least one candy.
// Children with a higher rating get more candies than their neighbors.
// Return the minimum number of candies you need to have to distribute the candies to the children.

 

// Example 1:

// Input: ratings = [1,0,2]
// Output: 5
// Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
// Example 2:

// Input: ratings = [1,2,2]
// Output: 4
// Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
// The third child gets 1 candy because it satisfies the above two conditions.
 

// Constraints:

// n == ratings.length
// 1 <= n <= 2 * 104
// 0 <= ratings[i] <= 2 * 104
package com;

import java.util.Arrays;

public class Candy {

    public int candies(int[] ratings){
        
        //An array to store the candy amount for each student
        int[] c_amt = new int[ratings.length];
        //prefilling with 1 as thats the min number of candy for each student
        Arrays.fill(c_amt, 1);

        //traverse left to right checking the ratings of the left neighbour
        for(int i=1; i<ratings.length; i++){
            //since its the first raversal, no need to check the resepective candy values as they have not been updated yet
            if(ratings[i]>ratings[i-1]){
                c_amt[i] = c_amt[i-1] +1;
            }
        }

        //traverse from right to left, checking the ratings of the right neighbour
        for(int i=ratings.length-2; i>=0;i--){
            //we need to check for the candy amount as well because they might have been updated in the first traversal
            if(ratings[i] > ratings[i+1] && c_amt[i] <= c_amt[i+1]){
                c_amt[i] = c_amt[i+1] + 1;
            }
        }

        //sum up the respective candy amounts for each student
        int s=0;
        for(int i: c_amt){
            System.out.println(i);
            s += i;
        }
        return s;
    }

    public static void main(String[] args) {

        int[] ratings = {1,2,87,87,87,2,1};

        Candy candy = new Candy();

        System.out.println(candy.candies(ratings));


        
    }
    
}
