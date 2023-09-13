package com;

public class ChampagneTower {

    public double champagneTower(int poured, int query_row, int query_glass){
        
        //intialize a 2D array to simulate the pour down in the tower
        double[][] tower = new double[query_row+2][query_row+2];

        tower[0][0] = poured;

        for(int i = 0; i<=query_row; i++){
            for(int j=0; j<=i; j++){
                //calculate the amount of overflow
                double overflow = (tower[i][j] - 1) /2.0;

                if(overflow > 0){
                    //distribute the overflow in the glasses below
                    //the first glass
                    tower[i+1][j] += overflow;
                    //the second glass
                    tower[i+1][j+1] += overflow; 
                }
            }
        }
        //if the queried glass has more than 1 unit in the 2D array
        return Math.min(1.0, tower[query_row][query_glass]);
    }
    
    public static void main(String[] args) {
        ChampagneTower champagneTower = new ChampagneTower();
        int poured = 100000009;
        int query_row = 33;
        int query_glass = 17;
        System.out.println(champagneTower.champagneTower(poured, query_row, query_glass));
    }
}
