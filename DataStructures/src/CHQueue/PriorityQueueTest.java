/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CHQueue;

import static FlightApplication.BaseFlight.FuelComparator;
import FlightApplication.CommercialFlight;
import static FlightApplication.CommercialFlight.PassengerComparator;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author JCSchneider
 */
public class PriorityQueueTest {
    
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.add(50);
        pq.add(75);
        pq.add(1);
        pq.add(25);
        
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
        
          
                
        PriorityQueue<CommercialFlight> flights = new PriorityQueue<CommercialFlight>(PassengerComparator);
        //PriorityQueue<CommercialFlight> flights = new PriorityQueue<CommercialFlight>(FuelComparator);
        
        
        
        CommercialFlight plane1 = new CommercialFlight(1, "flightNo", "destinationLocation", "departureLocation", null, 0, 100, 0, 0, "planeType", 1000, 0);
        flights.add(plane1);
        CommercialFlight plane2 = new CommercialFlight(2, "flightNo", "destinationLocation", "departureLocation", null, 0, 200, 0, 0, "planeType", 500, 0);        
        //flights.add(plane2);
        flights.offer(plane2);
        
        
        flights.add(new CommercialFlight(100, "Flight100", "Chicago", "Chattanooga", null, 52000, 535, 33.5, -155.2, "Boeing 737", 35000, 190));
        
        
        while (!flights.isEmpty()) {
            System.out.println(flights.poll());
        }
    }
}
