package FlightApplication;

import java.util.ArrayList;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JCSchneider
 *
 */
//public class CommercialFlight extends BaseFlight{
public class CommercialFlight extends BaseFlight {


    private static int numberOfCommercialFlights = 0; //Class variable - one for the entire program
    private int commercialFlightID;
    private int passengers;
    private String flightNo;
    private String destinationLocation;
    private String departureLocation;
    private ArrayList<String> crew;

    public int getCommercialFlightID() {
        return commercialFlightID;
    }

    public int getPassengers() {
        return passengers;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public ArrayList<String> getCrew() {
        return crew;
    }

    /**
     *
     * @param passengers
     * @param flightNo
     * @param destinationLocation
     * @param departureLocation
     * @param crew
     * @param speed
     * @param latitude
     * @param longitude
     * @param planeType
     * @param fuel
     * @param course
     */
    public CommercialFlight(int passengers,
            String flightNo,
            String destinationLocation,
            String departureLocation,
            ArrayList<String> crew,
            int altitude, int speed, double latitude, double longitude,
            String planeType, int fuel, int course) {
        super(altitude, speed, latitude, longitude, planeType, fuel, course);
        this.passengers = passengers;
        this.flightNo = flightNo;
        this.destinationLocation = destinationLocation;
        this.departureLocation = departureLocation;
        this.crew = crew;
        this.commercialFlightID = ++numberOfCommercialFlights;
    }

    public static void setFuelComparator(Comparator<BaseFlight> FuelComparator) {
        BaseFlight.FuelComparator = FuelComparator;
    }

    public static Comparator<BaseFlight> getFuelComparator() {
        return FuelComparator;
    }

    
     public static Comparator<CommercialFlight> PassengerComparator = new Comparator<CommercialFlight>(){
     @Override
        public int compare(CommercialFlight b0, CommercialFlight b1){
            return Integer.valueOf(b0.getPassengers()).compareTo(Integer.valueOf(b1.getPassengers()));
        }
    };
    @Override
    public String toString() {
        return "CommercialFlight{"
                + super.toString()
                + "fuel= "+ fuel 
                + " commercialFlightID=" + commercialFlightID
                + ", passengers=" + passengers
                + ", flightNo=" + flightNo + ", destinationLocation="
                + destinationLocation + ", departureLocation="
                + departureLocation + ", crew="
                + crew + '}';
    }

    @Override
    public int compareTo(BaseFlight o) {
        if (this.getFuel() > o.getFuel()) {
            return 1;
        } else if (this.getFuel() < o.getFuel()) {
            return -1;
        } else {
            return 0;
        }
    }

    

}
