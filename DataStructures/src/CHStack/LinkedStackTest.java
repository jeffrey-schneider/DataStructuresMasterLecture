/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CHStack;

import FlightApplication.CommercialFlight;
import java.util.ArrayList;

/**
 *
 * @author JCSchneider
 */
public class LinkedStackTest {
    
    public static void main(String[] args){
        
        LinkedStack stack = new LinkedStack();
        for (int i = 0; i < 10; i++) {
            stack.push(i);            
        }
        
        //System.out.println(stack.popAll());
       
        for (int i = 0; i < 10; i++) {
            stack.push(i);            
        }
        System.out.println("Peek: " + stack.peek());
        
        while (!stack.isEmpty()) {
            System.out.println("Pop: " + stack.pop());
        }
        
        
        LinkedStack<FlightApplication.CommercialFlight> flights = new LinkedStack<>();
        ArrayList<String> crew = new ArrayList<String>();
        crew.add("Bob");
        crew.add("Ted");
        crew.add("Carole");
        crew.add("Alice");
        
        
        flights.push(new CommercialFlight(150, "flightNo 1", "destinationLocation", "departureLocation", crew, 0, 0, 0, 0, "planeType", 0, 0));
        
        flights.push(new CommercialFlight(150, "flightNo 2", "destinationLocation2", "departureLocation2", crew, 0, 0, 0, 0, "planeType2", 0, 0));
        
        while(!flights.isEmpty()){
            System.out.println(flights.pop());
        }
        
    }
            
    
    
    
}
