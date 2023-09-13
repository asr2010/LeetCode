// 1293. Shortest Path in a Grid with Obstacles Elimination

// Hard

// You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle). You can move up, down, left, or right from and to an empty cell in one step.

// Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1) given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.

 

// Example 1:


// Input: grid = [[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]], k = 1
// Output: 6
// Explanation: 
// The shortest path without eliminating any obstacle is 10.
// The shortest path with one obstacle elimination at position (3,2) is 6. Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
// Example 2:


// Input: grid = [[0,1,1],[1,1,1],[1,0,0]], k = 1
// Output: -1
// Explanation: We need to eliminate at least two obstacles to find such a walk.
 

// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 40
// 1 <= k <= m * n
// grid[i][j] is either 0 or 1.
// grid[0][0] == grid[m - 1][n - 1] == 0
package com;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathWithObstacleElemination {
    public int shortestPath(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;
        //Valid travelling Directions
        int[][] directions = {{0,1}, {1,0},{0,-1},{-1,0}};
        //keep tracked of visited Grid cells
        boolean[][][] visited = new boolean[m][n][k+1];
        //Keep tracks of the neighbours for next exploration step
        Queue<int[]> queue = new LinkedList<>();

        int steps = 0;

        //starting point
        queue.add(new int[]{0,0,k});

        while(!queue.isEmpty()){
            int size = queue.size();
            //while all the neighbours have not been explored
            while(size-- > 0){

                //pop the first neighbour in the queue
                int[] current = queue.poll();

                //check if the current cell is the destination
                if(current[0] == m-1 && current[1]==n-1)
                    return steps;

                //Explore all possible directions
                for(int[] d : directions){

                    //cordinates for moving in that direction
                    int i = current[0]+d[0];
                    int j = current[1]+d[1];

                    //retrive the obstacle balance for that grid cell
                    int obstacleBalance = current[2];

                    //Traverse through valid cells
                    if(i>=0 && i< m && j>=0 && j<n){

                        //if its an empty cell & has not been visited
                        if(grid[i][j] == 0 && !visited[i][j][obstacleBalance]){
                            //add it to queue
                            queue.add(new int[]{i,j,obstacleBalance});
                            //mark it as visited
                            visited[i][j][obstacleBalance] = true;
                        }

                        //if its an obstacle, but we have obstacle balance left, and the cell has not been visited
                        else if(grid[i][j] == 1 && obstacleBalance >0 && !visited[i][j][obstacleBalance-1])
                        {
                            //add it to queue with a decrement in obstacle balance
                            queue.add(new int[]{i,j,obstacleBalance-1});
                            //mark it as visited
                            visited[i][j][obstacleBalance-1] = true;
                        } 
                    }

                }
            }
            //increase the step count
            ++steps;
        }
        //if destination cant be reached
        return -1;

        
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{1,1,0}, {0,0,0}, {0,1,1},{0,0,0}};
        int k =1;

        ShortestPathWithObstacleElemination shortestPathWithObstacleElemination = new ShortestPathWithObstacleElemination();
        System.out.println(shortestPathWithObstacleElemination.shortestPath(grid, k));
    }
    
}
