/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightApplication;

import java.util.Comparator;
/**
 *
 * @author JCSchneider
 */
public abstract class BaseFlight implements Comparable<BaseFlight> {
    private static int aircraftCounter = 0;  //Class variable
    private int aircraftID;
    int speed;
    private double latitude;
    private double longitude;
    private String planeType;
    int fuel;
    private int course;
    private int altitude;

    
    public BaseFlight(int altitude, int speed, double latitude, double longitude, String planeType, int fuel, int course) {
        this.aircraftID = ++this.aircraftCounter;
        this.speed = speed;
        this.latitude = latitude;
        this.longitude = longitude;
        this.planeType = planeType;
        this.fuel = fuel;
        this.course = course;
        this.altitude = altitude;
    }
    
    
    @Override
    public String toString() {
        return "BaseFlight{" + "aircraftID=" + aircraftID + ", speed=" + speed + ", latitude=" + latitude + ", longitude=" + longitude + 
                ", planeType=" + planeType + ", fuel=" + fuel + ", course=" + course + ", altitude=" + altitude + "}\n";
    }

    public static int getAircraftCounter() {
        return aircraftCounter;
    }

    public static void setAircraftCounter(int aircraftCounter) {
        BaseFlight.aircraftCounter = aircraftCounter;
    }

    public int getAircraftID() {
        return aircraftID;
    }

    public void setAircraftID(int aircraftID) {
        this.aircraftID = aircraftID;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        if (course >= 0 || course < 360)        {
            this.course = course;            
        }else if (course < 0) {
            this.course = 0;
        }else if(course >= 360){
            this.course = course;
        }
    }

    public void changeCourse(int courseChange){
        int courseBuffer = this.course;
        this.course += courseChange;
        if (this.course >= 360)
            this.course -= 360;
        if (this.course <0) {
            this.course += 360;
        }
    }
    
    
    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

     public void changeSpeed(int speedChange){
        //aircraft cannot fly backward; disallow negative numbers
        int speedBuffer = speed;
        this.speed += speedChange;
        if(speed < 0){
            speed = speedBuffer;
        }
    }
    public void changeAltitude(int newAltitude){
        //aircraft cannot fly at negative altitudes
        int altBuffer = newAltitude;
        if(altBuffer > 100)
            this.altitude = altBuffer;
    }
    
   
    
    public static Comparator<BaseFlight> PlaneTypeComparator = new Comparator<BaseFlight>(){
    @Override    
    public int compare(BaseFlight b0, BaseFlight b1){
            //ascending order
            return b0.getPlaneType().compareTo(b1.getPlaneType());
        }    
    
};
 
 public static Comparator<BaseFlight> FuelComparator = new Comparator<BaseFlight>(){
     @Override
        public int compare(BaseFlight b0, BaseFlight b1){
            return Integer.valueOf(b0.getFuel()).compareTo(Integer.valueOf(b1.getFuel()));
        }
    };
 
 public boolean equals(Object obj){
     if(obj == this) return true;
     if(obj == null) return false;
     if(this.getClass() == obj.getClass()){
         BaseFlight other = (BaseFlight)obj;
         return planeType.equals(other.planeType);
     }else{
         return false;
     }
 }
 
 
 
    
 
    
}
