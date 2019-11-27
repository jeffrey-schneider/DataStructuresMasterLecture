/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightApplication;

/**
 *
 * @author JCSchneider
 */
public class HelicopterFlight extends BaseFlight {

    public HelicopterFlight(int altitude, int speed, double latitude, double longitude,
            String planeType, int fuel, int course) {
        super(altitude, speed, latitude, longitude, planeType, fuel, course);
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeSpeed(int speedChage){
        this.speed += speedChage;
    }
    
    @Override
    public int compareTo(BaseFlight o) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(this.getFuel() > o.getFuel()){
            return 1;
        }else if(this.getFuel() < o.getFuel()){
            return -1;
        }else{
            return 0;
        }
    }
    
}

