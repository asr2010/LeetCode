package com;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BusRoutes {
    public static void main(String[] args) {
        BusRoutes busRoutes = new BusRoutes();

        int[][] routes = {{1,2,7}, {3,6,7}};
        int source =1;
        int target =7;

        System.out.println(busRoutes.numBusesToDestination(routes, source, target));
    }
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        if(source == target)    
        {
            return 0;
        }

        HashMap<Integer, HashSet<Integer>> stopInfo =new HashMap<>();

        for(int i=0; i<routes.length; i++){
            for(int j=0;j<routes[i].length;j++){
                HashSet<Integer> busInRoutes = stopInfo.getOrDefault(routes[i][j], new HashSet<>());
                busInRoutes.add(i);
                stopInfo.put(routes[i][j], busInRoutes);
            }
        }

        Queue<Integer> q =new LinkedList<>();
        q.add(source);

        int busCount =0;

        HashSet<Integer> seen =new HashSet<>();

        while(!q.isEmpty()){
            busCount++;

            int size = q.size();
            while(size-- >0)
            {
                int currentStop = q.poll();

                HashSet<Integer> buses= stopInfo.get(currentStop);

                for(Integer bus : buses){
                    if(seen.add(bus)){
                        for(Integer stop: routes[bus]){
                            if(stop == target){
                                return busCount;
                            }
                            else{
                                q.add(stop);
                            }
                        }
                    }
                }
            }
        }  
        return -1;
    }


}
