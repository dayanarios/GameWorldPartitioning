/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepartitioning;

import java.util.Hashtable;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author dayanarios
 */



public class Player {
    
    private int ID; 
    private Pair<Integer> location; 
    static int ID_generator = 0; 
    int fib_min = 13; 
    int fib_max = 18; 
    private Hashtable<Integer, Integer> values = new Hashtable(); 
    
    public Player(){
        ID = ID_generator++; 
    }
    
    public int action(){
        int n = ThreadLocalRandom.current().nextInt(fib_min, fib_max);
        return fibonacci(n); 
    }
    
    public int fibonacci(int number){ 
        if(number == 1 || number == 2){ 
            return 1;
        } 
        return fibonacci(number-1) + fibonacci(number -2);
    } 

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Pair<Integer> getLocation() {
        return location;
    }

    public void setLocation(Pair<Integer> location) {
        this.location = location;
    }
    
    public void setValue(int id, int value){
        values.put(id, value); 
    }
    
    
   


    
}

class Pair<T> {
    private final T m_first;
    private final T m_second;

    public Pair(T first, T second) {
        m_first = first;
        m_second = second;
    }

    public T first() {
        return m_first;
    }

    public T second() {
        return m_second;
    }
}
