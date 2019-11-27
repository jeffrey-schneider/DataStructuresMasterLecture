/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CHQueue;

import FlightApplication.CommercialFlight;
import java.util.ArrayList;

/**
 *
 * @author JCSchneider
 */
public class LinkedQueueTest {

    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();
        
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        
        System.out.println(queue.toString() + "\n");      
        
        
        while (!queue.isEmpty()) {
            System.out.println("Peeking: " + queue.peek());
            System.out.println(queue.toString() + "\n");
            queue.dequeue();
        }
        
        LinkedQueue<CommercialFlight> flights = new LinkedQueue<CommercialFlight>();
        
        ArrayList<String> crew = new ArrayList<String>();
        crew.add("Bob");
        crew.add("Ted");
        crew.add("Carole");
        crew.add("Alice");
        
        CommercialFlight airplane1 = new CommercialFlight(150, "flightNo1", "destinationLocation1", "departureLocation", crew, 0, 0, 0, 0, "planeType1", 0, 0);

        flights.enqueue(airplane1);
        flights.enqueue(new CommercialFlight(150, "flightNo2", "destinationLocation2", "departureLocation", null, 0, 0, 0, 0, "planeType2", 0, 0));
        while(!flights.isEmpty()){
            System.out.println(flights);
            flights.dequeue();
        }
        System.out.println("Done");
        
        
    }
    
}
