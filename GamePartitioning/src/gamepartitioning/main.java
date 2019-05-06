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
        int rounds = 100; 
        for(int i = 0; i< numPlayers; i++){
            players.add(new Player()); 
        }
        long time100 = 0; 
        long time50 = 0; 
        long time20 = 0; 
        long timeNo = 0; 
        
        
        System.out.println("\t\t GAME MAP AVERAGE RESPONSE TIMES");
        System.out.println("============================================================");
        System.out.println("Partitions \t Size \t\tnsec\t\tmsec" );
        System.out.println("------------------------------------------------------------" );
        
        for(int i = 0; i< rounds; i++){
        //no partition
        long startTime1 = System.nanoTime(); 
        noPartition game_map = new noPartition(players); 
        game_map.game(); 
        long endTime1   = System.nanoTime();
        //long totalTime1 = endTime1 - startTime1; 
        //timeNo += game_map.getTime(); 
        timeNo = endTime1 - startTime1; 


        //partition: 1x100
        long startTime2 = System.nanoTime(); 
        Array_Partition array_map = new Array_Partition(players); 
        //array_map.display();
        array_map.game();
        long endTime2   = System.nanoTime();
        //long totalTime2 = endTime2 - startTime2;
        //time100 += array_map.getTime();
        time100 =endTime2 - startTime2;

        
        //partition: 1x50
        long startTime3 = System.nanoTime(); 
        Array_PartitionSmall array_mapSmall = new Array_PartitionSmall(players); 
        array_mapSmall.game(); 
        long endTime3   = System.nanoTime();
        //long totalTime3 = endTime3 - startTime3; 
        //time50 +=array_mapSmall.getTime(); 
        time50 = endTime3 - startTime3; 

        
        
        //partition: 1x20
        long startTime4 = System.nanoTime(); 
        Array_PartitionSmallest array_mapSmallest = new Array_PartitionSmallest(players); 
        array_mapSmallest.game(); 
        long endTime4   = System.nanoTime();
        //long totalTime4 = endTime4 - startTime4; 
        //time20 += array_mapSmallest.getTime(); 
        time20= endTime4 - startTime4; 
        }
        
        long avgNo = timeNo/(long) rounds; 
        long avg100 = time100/(long)rounds; 
        long avg50 = time50/(long)rounds; 
        long avg20 = time20/(long)rounds; 

        System.out.println("None\t\t -\t\t" 
                +  avgNo + " nsec\t" + avgNo/1000000.0 + " msec" );   
        
        System.out.println("Subarrays  \t 1x100 \t\t"
                 + avg100 + " nsec\t" + avg100/1000000.0 + " msec"); 
        
        System.out.println("Subarrays  \t 1x50 \t\t"
                 + avg50 + " nsec\t" + avg50/1000000.0 + " msec");

         System.out.println("Subarrays  \t 1x20 \t\t"
                 + avg20 + " nsec\t" + avg20/1000000.0 + " msec"); 
         
        System.out.println("============================================================");
    }
    
}