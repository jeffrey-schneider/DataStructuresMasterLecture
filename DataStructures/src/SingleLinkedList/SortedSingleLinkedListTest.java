/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SingleLinkedList;

import FlightApplication.CommercialFlight;
import java.util.ArrayList;

/**
 *
 * @author JCSchneider
 */
public class SortedSingleLinkedListTest {
    public static void main(String[] args) {
        SortedSingleLinkedList<String> names = new SortedSingleLinkedList<>();
        names.add("Sam");
        names.add("Harry");
        names.add("Dick");
        names.add("Tom");
        names.add("Jeff");
        
        System.out.println("Get size " + names.getSize());
        names.printMe();
        
        try{
        System.out.println("->" + names.get(0));
        }catch(Exception exc){
            System.out.println(exc.getMessage());
        }
        
       
       // names.printAll();
        
        
        names.reverse();
        
        
        SortedSingleLinkedList<CommercialFlight> flights = new SortedSingleLinkedList<>();
        
        ArrayList<String> crew = new ArrayList<String>();
        crew.add("Bob");
        crew.add("Ted");
        crew.add("Carole");
        crew.add("Alice");
        
        //flights.add(new CommercialFlight(300, "ABC123", "Chicago", "Chattanooga", crew, 15000, 650, 35.0456, -85.3097, "Boeing 737", 5000, 270));
        //flights.add(new CommercialFlight(150, "flightNo 1", "destinationLocation", "departureLocation", crew, 0, 0, 0, 0, "planeType", 3000, 90));
        //
        //flights.add(new CommercialFlight(150, "flightNo 2", "destinationLocation2", "departureLocation2", crew, 0, 0, 0, 0, "planeType2", 500, 0));
        //
        //flights.printAll();
        
      
    }
            
}
