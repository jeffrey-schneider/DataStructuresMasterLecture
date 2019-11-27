/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightApplication;

/**
 *
 * @author jeffrey.schneider
 */
public class PrivateFlight extends BaseFlight{    
    private String flightPlan;
    private String departure;
    private String arrival;
    private int passengers;

    @Override
    public String toString() {
        return "PrivateFlight{" + "flightPlan=" + flightPlan + ", departure=" + departure + 
                ", arrival=" + arrival + ", passengers=" + passengers + '}' + super.toString();
    }

    public void setFlightPlan(String flightPlan) {
        this.flightPlan = flightPlan;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public String getFlightPlan() {
        return flightPlan;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public int getPassengers() {
        return passengers;
    }

    public PrivateFlight(int altitude, int speed, double latitude, double longitude, String planeType, int fuel, int course) {
        super( speed, altitude, latitude, longitude, planeType, fuel, course);
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
