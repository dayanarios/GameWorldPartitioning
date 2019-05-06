/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepartitioning;

import java.util.ArrayList;

/**
 *
 * @author dayanarios
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Player> players = new ArrayList<Player>();
        int numPlayers = 1000; 
        
        for(int i = 0; i< numPlayers; i++){
            players.add(new Player()); 
        }
        
        System.out.println("\t\t GAME MAP RESPONSE TIMES");
        System.out.println("============================================================");
        System.out.println("Partitions \t Size \t\tnsec\t\tmsec" );
        System.out.println("------------------------------------------------------------" );
        //no partition
        long startTime1 = System.nanoTime(); 
        noPartition game_map = new noPartition(players); 
        game_map.game(); 
        long endTime1   = System.nanoTime();
        long totalTime1 = endTime1 - startTime1; 
        System.out.println("None\t\t -\t\t" 
                + totalTime1 + " nsec\t" + totalTime1/1000000 + " msec" ); 

        //partition: 10x10
        long startTime2 = System.nanoTime(); 
        Array_Partition array_map = new Array_Partition(players); 
        //array_map.display();
        array_map.game();
        long endTime2   = System.nanoTime();
        long totalTime2 = endTime2 - startTime2; 
        System.out.println("Subarrays  \t 1x100 \t\t"
                 + totalTime2 + " nsec\t" + totalTime2/1000000 + " msec"); 
        
        //partition: 5x5
        long startTime3 = System.nanoTime(); 
        Array_PartitionSmall array_mapSmall = new Array_PartitionSmall(players); 
        array_mapSmall.game(); 
        long endTime3   = System.nanoTime();
        long totalTime3 = endTime3 - startTime3; 
        
        System.out.println("Subarrays  \t 1x50 \t\t"
                 + totalTime3 + " nsec\t" + totalTime3/1000000 + " msec");
        
        
        //partition: 1x1
        long startTime4 = System.nanoTime(); 
        Array_PartitionSmallest array_mapSmallest = new Array_PartitionSmallest(players); 
        array_mapSmallest.game(); 
        long endTime4   = System.nanoTime();
        long totalTime4 = endTime4 - startTime4; 
        
        System.out.println("Subarrays  \t 1x20 \t\t"
                 + totalTime4 + " nsec\t" + totalTime4/1000000 + " msec");
        
        
        System.out.println("============================================================");
    }
    
}
