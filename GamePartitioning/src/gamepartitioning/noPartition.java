/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepartitioning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author dayanarios
 */
public class noPartition {
    
    int rows = 100; 
    int cols = 100; 
    int[][] map = new int[rows][cols]; 
    ArrayList<Player> players; 
    long response_time = 0; 

    public noPartition(ArrayList<Player> players) {
        this.players= players; 
        
        for (int[] row: map){
            Arrays.fill(row, 0);
        }
        
        for(Player p : players){
            int r = ThreadLocalRandom.current().nextInt(0, rows);
            int c = ThreadLocalRandom.current().nextInt(0, cols);
            p.setLocation(new Pair(r,c));
            map[r][c]= 1; 
        }
    }
    
    public void game(){
        long startTime = System.nanoTime();
        
        for(Player p: players){
            int value = p.action(); 
            for( Player p2: players){
                if (!p.equals(p2)){
                    p2.setValue(p.getID(), value); 
                }
                
            }
        }

        long endTime = System.nanoTime();
        response_time = (endTime - startTime);
    }
    
    
    public void display(){
        for (int i = 0; i< rows; i++){
            for(int j = 0; j < cols; j++){
                System.out.print(map[i][j]); 
            }
            System.out.println(); 
        }
        /*
        for(int i =0; i<rows; i++){
            System.out.println("region " + i);
            for(Player p: player_map[i]){
                Pair temp = p.getLocation();
                System.out.println(p.getID() + " " + temp.first() + "," + temp.second());
              
            }
        }
        */
    }

    public long getTime() {
        return response_time/1000000; //in milliseconds
    }
    
    
    
}
