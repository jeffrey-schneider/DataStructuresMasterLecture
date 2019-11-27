/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CHArrayList;

import FlightApplication.CommercialFlight;
import FlightApplication.BaseFlight;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author JCSchneider
 */
public class ArrayListAviation {
    public static void main(String[] args){
        CHArrayList<CommercialFlight> commList = new CHArrayList<CommercialFlight>();
        System.out.println("Is empty: " + commList.isEmpty());
        int counter = 0;
        
        CommercialFlight comm1 = new CommercialFlight(65, "EMC2", "CHA", "DTX", null, 290, 34, 
                34.0, 125.0, "Boeing737-400", 2750, 25);
        commList.add(comm1);

        commList.add(new CommercialFlight(0, "Flight666", "LAX","CHA", null, 890, 6500, 32.4, -123.0, "Airbus Doomed 320", 234, 180));
        
        commList.add(new CommercialFlight(25, "616", "CHA", "LAX", null, 230, 550, 
                34.0, -133.5, "MD88", 2500, 175));      
        
        commList.add(new CommercialFlight(250, "616", "CHA", "LAX", null, 230, 550, 
                34.0, -133.5, "MD88", 2500, 175));
        
        commList.add(new CommercialFlight(252, "616", "CHA", "LAX", null, 230, 550, 34.0, -133.5, "MD88", 25, 175));
        commList.add(new CommercialFlight(253, "616", "CHA", "LAX", null, 230, 550, 34.0, -133.5, "MD88", 250, 175));
        commList.add(new CommercialFlight(253, "616", "CHA", "LAX", null, 230, 550, 34.0, -133.5, "MD88", 2500, 175));
        commList.add(new CommercialFlight(2504, "616", "CHA", "LAX", null, 230, 550, 34.0, -133.5, "MD88", 25000, 175));
        commList.add(new CommercialFlight(2505, "616", "CHA", "LAX", null, 230, 550, 34.0, -133.5, "MD88", 257, 175));
        commList.add(new CommercialFlight(2506, "616", "CHA", "LAX", null, 230, 550, 34.0, -133.5, "MD88", 2, 175));
        commList.add(new CommercialFlight(2507, "616", "CHA", "LAX", null, 230, 550, 34.0, -133.5, "MD88", 27588, 175));
        commList.add(new CommercialFlight(2508, "616", "CHA", "LAX", null, 230, 550, 34.0, -133.5, "MD88", 2784, 175));
        commList.add(new CommercialFlight(2509, "616", "CHA", "LAX", null, 230, 550, 34.0, -133.5, "MD88", 2500, 175));
        commList.add(new CommercialFlight(25010, "616", "CHA", "LAX", null, 230, 550, 34.0, -133.5, "MD88", 300, 175));
        commList.add(new CommercialFlight(25011, "616", "CHA", "LAX", null, 230, 550, 34.0, -133.5, "MD88", 165, 175));
        commList.add(new CommercialFlight(25012, "616", "CHA", "LAX", null, 230, 550, 34.0, -133.5, "MD88", 150, 175));
        commList.add(new CommercialFlight(25013, "616", "CHA", "LAX", null, 230, 550, 34.0, -133.5, "MD88", 156, 175));


    CommercialFlight newFlight = new CommercialFlight(-100, "Hold my Beer", "CHI", "CHA", null, 230, 555, 34.8, -133.5, "747", 250000, 190);

        
        
        commList.printAll();        
        System.out.println("size: " + commList.length());
        
        System.out.println("Clear");
        //commList.clear();
        System.out.println("Print All:");
        commList.printAll();
        System.out.println("size: " + commList.length());
        
        
        System.out.println("Get:" + commList.get(1));
        System.out.println("Set: " + commList.set(15, newFlight));
        
        commList.printAll();
        System.out.println("size: " + commList.length());
        
        System.out.println("Remove 15: " + commList.remove(15));
        System.out.println("size: " + commList.length());
        
        
        System.out.println("Remove range 10-15" + commList.removeRange(10, 14));
        commList.printAll();
        
        
        
        /** How do we change the course of one commercial flight 
         Use an iterator!! */
        System.out.println("Iterator action:");
        Iterator it = commList.iterator();
        while(it.hasNext()){
            CommercialFlight checker = (CommercialFlight)it.next();
            if(checker.getAircraftID() == 15){
                System.out.println(checker.toString());
                checker.changeCourse(270);
                System.out.println(checker.toString());
            }
        }
        
      
                
    }
}



