package FlightApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/**
 *
 * @author JCSchneider
 */
public class FlightApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       System.out.println("\n\nCommercial Flight ArrayList");
        ArrayList<CommercialFlight> commList = new ArrayList<CommercialFlight>();
        ArrayList<MilitaryFlight> milList = new ArrayList<MilitaryFlight>();
        ArrayList crew = new ArrayList<String>();
        crew.add("Unger");
        crew.add("Dunne");
        
        CommercialFlight comm1 = new CommercialFlight(65, "EMC2", "CHA", "DTX", crew, 290, 34, 
                34.0, 125.0, "Boeing737-400", 2750, 25);
        commList.add(comm1);
        
        ////////////////////////////
        CommercialFlight comm123 = new CommercialFlight(255, "ABC1234", "Chicago", "Chattanooga", crew, 15000, 525, 33.1, -155.15, "Boeing 777", 15000, 270);
        System.out.println("This is it.");
        System.out.println(comm123.toString());
        /////////////////////////////////////        
        
        
        CommercialFlight comm2 = new CommercialFlight(0, "Flight666", "HELL", 
                "CHA", crew, 890, 6500, 32.4, -123.0, "Airbus Doomed 320", 234, 180);
        commList.add(comm2);
        
        CommercialFlight comm3 = new CommercialFlight(250, "616", "CHA", "LAX", crew, 230, 550, 
                34.0, -133.5, "MD88", 2500, 175);
        commList.add(comm3);
        
        commList.add(new CommercialFlight(250, "1588", "CHA", "DTW", crew, 230, 3400, 
                34.0, -133.5, "MD88", 2500, 175));
        
   /* Anonymous inner class with an instance initializer (also known as a 
        "double brace initialization") 
   *    https://stackoverflow.com/questions/1005073/initialization-of-an-arraylist-in-one-line
   * coodbird answer Jun 17, 2009   */
        ArrayList<String> crewList = new ArrayList<String>() {{
             add("Adam");
             add("Barney");
             add("Charlie");
        }};        
        commList.add(new CommercialFlight(500, "Genesis 1", "CHA", "DTW", crewList, 15000, 350, 35.0455, -8.30972, "Boeing 737-800", 15000, 158));
        //crewList.clear();
        
        
//        for(CommercialFlight item: commList){
//               System.out.println("Retrieved element" + item.toString());
//        }
        
        ArrayList<String> weapons = new ArrayList<String>(){{
            add("Bombs");
        }};

        ArrayList<String> sensors = new ArrayList<String>(){{
            add("Radar");
        }};

        ArrayList<String>crewList2 = new ArrayList<String>()
        {{ add("Brooks"); add("Dunn");}};
                
        MilitaryFlight pizza =new MilitaryFlight("Deliver Pizza", true, weapons, sensors, 
                crewList2, 
                4000, 1000, 33.6, -133.6, "A6-D", 1000, 180);
//        System.out.println("Military: " + pizza.toString());
        
         MilitaryFlight pizza2 =new MilitaryFlight("Deliver Pizza", true, weapons, sensors, 
                new ArrayList<String>(){{ add("Brooks"); add("Dunn");}}, 
                4000, 1000, 33.6, -133.6, "A6-D", 1000, 180);
  //      System.out.println("Military: " + pizza2.toString());
        
        
        Collections.sort(commList,BaseFlight.FuelComparator);        
        
        Iterator<CommercialFlight> iter3 = commList.iterator();        
        while(iter3.hasNext()){
            System.out.println(iter3.next());
        }
        
        
       
        ArrayList<HelicopterFlight> heliList = new ArrayList<HelicopterFlight>();
        HelicopterFlight heli1 = new HelicopterFlight(1500, 150, 34.0, -133.5, "Huey", 500, 270);
        
        heli1.changeCourse(+180);
        heliList.add(heli1);
        Iterator<HelicopterFlight> iter4 = heliList.iterator();
        while(iter4.hasNext()){
            System.out.println(iter4.next());
        }
        
        milList.add(new MilitaryFlight("Bombing", true, null, null, crewList, 0, 0, 0, 0, "B1B bomber", 12000, 45));
        milList.add(new MilitaryFlight("Defoliating", true,null,null, crewList, 1,2,3,4,"Ducky bird", 125000,45));
        
        System.out.println("Enhanced For Loop, Commercial"); 
       for(CommercialFlight item: commList){
            System.out.println("Retrieved element" + item.toString());
       }
       
       for (HelicopterFlight item: heliList) 
            System.out.println("Retrieved element: " + item.toString());
       
       
       for(MilitaryFlight item: milList){
           System.out.println("Retrieved element: " + item.toString());
       }
       
        
        
    }
}
