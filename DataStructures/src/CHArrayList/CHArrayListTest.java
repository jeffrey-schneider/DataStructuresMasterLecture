
package CHArrayList;

/**
 *
 * @author jeffrey.schneider
 */
public class CHArrayListTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CHArrayList list = new CHArrayList();
        System.out.println("Is empty: " + list.isEmpty());
        int counter = 0;
        
        long startTime = System.nanoTime();
        
        while(counter < 10){
            list.add(counter);
            counter++;
        }
        long elapsedTime = (System.nanoTime() - startTime);
        double printElapsed = (double)elapsedTime * 0.000000001;
        System.out.println("Elapsed Time: " + printElapsed);
        
        
        System.out.println(list.get(5));
        list.add(5,999);
        System.out.println(list.get(5));
        
        //list.remove(4);
      
        
        System.out.println("Contains 999: " + list.contains((Integer)999));
        System.out.println("Contains 998"+ list.contains((Integer)998));
        
        
        list.printAll();
        System.out.println("Remove range 0, 5");
        list.removeRange(0, 5);
        list.printAll();        
        System.out.println("size: " + list.length());
        
        System.out.println("Clear");
        list.clear();
        System.out.println("Print All:");
        list.printAll();
        System.out.println("size: " + list.length());
       
        
        
    }
    
}
