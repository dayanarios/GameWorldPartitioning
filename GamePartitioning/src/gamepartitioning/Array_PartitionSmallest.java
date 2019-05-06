/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepartitioning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author dayanarios
 */
public class Array_PartitionSmallest {
    
    //1x10x10 int[row][column]
    //can only communicate with players in array/region
    int rows = 500; 
    int cols = 20; 
    int[][] map = new int[rows][cols]; 
    ArrayList<Player> players; 
    ArrayList<Player>[] player_map = new ArrayList[rows]; 
    long response_time = 0; 
    

    public Array_PartitionSmallest(ArrayList<Player> players) {
        this.players = players; 
        
         for (int[] row: map){
            Arrays.fill(row, 0);
        }
        for(int i = 0; i< rows; i++){
            player_map[i] = new ArrayList<Player>(); 
        }
        
        for(Player p : players){
            int r = p.getLocation().first()*5; 
            int c = p.getLocation().second();
            
            if (c >=  cols){
                c = c % cols;  //appropriate column
            }
            
            if(p.getLocation().first() == 0 && c<rows){
                r=0; 
            }
            else if(p.getLocation().first() == 0 && c>rows){
                r= c/cols;
            }
            else if(c>cols){
                r+= c/cols; 
            }
            
            if(c == 20){
                c-=1; 
            }

            //System.out.println(r + " " + c);  
            map[r][c]= 1; 
            player_map[r].add(p); 
        }
    }
    
    public void game(){
        long startTime = System.nanoTime();
        for(int i =0; i<rows; i++){
            for(Player p: player_map[i]){
                int value = p.action(); 
                for(Player p2 : player_map[i]){
                    if (!p.equals(p2)){
                        p2.setValue(p.getID(), value); 
                    }
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
        for(int i =0; i<10; i++){
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
