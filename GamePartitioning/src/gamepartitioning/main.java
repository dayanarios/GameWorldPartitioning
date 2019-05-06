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
        int numPlayers = 100; 
        
        for(int i = 0; i< numPlayers; i++){
            players.add(new Player()); 
        }
        
        noPartition game_map = new noPartition(players); 
        game_map.game(); 
        System.out.println("game map with no paritions response time: " + game_map.getTime() + "msec"); 

        Array_Partition array_map = new Array_Partition(players); 
        //array_map.display();
        array_map.game();
        System.out.println("response time for partitioning game map with subarrays:"
                + " " + array_map.getTime() + "msec"); 
        
    }
    
}
