import java.util.ArrayList;

/**
 * Train car with passengers who can be added/removed and a max passenger capacity
 * @author Greta Wang
 * @version 10/2/2025
 */
public class Car implements CarRequirements {

    private ArrayList<Passenger> passengers;
    private int capacity;

    /**
     * Constructor
     * @param capacity Passenger capacity of the Car
     */
    public Car(int capacity){
        this.capacity = capacity;
        this.passengers = new ArrayList<Passenger>(capacity);
    }

    /**
     * Accessor for capacity
     * @return Car capacity as an int
     */
    public int getCapacity(){
        return this.capacity;
    }

    /**
     * Determines number of available seats
     * @return Number of available seats
     */
    public int seatsRemaining(){
        return (this.capacity - this.passengers.size());
    }

    /**
     * Adds a Passenger to passengers list and returns true, or returns false if no seat available or the Passenger is already onboard
     * @param p Passenger to be added
     * @return True if Passenger was successfully added, false otherwise
     */
    public Boolean addPassenger(Passenger p){
        if (this.seatsRemaining() > 0 && !this.passengers.contains(p)){
            this.passengers.add(p);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes a Passenger from passengers list and returns true, or returns false if Passenger was not on list
     * @param p Passenger to be removed
     * @return True if Passenger was on list, false otherwise
     */
    public Boolean removePassenger(Passenger p){
        if (this.passengers.contains(p)){
            this.passengers.remove(p);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Prints roster of Passengers
     */
    public void printManifest(){
        if (this.passengers.isEmpty()){
            System.out.println("This car is EMPTY.");
        } else {
            for (int i=0; i < this.passengers.size(); i++){
                System.out.print(this.passengers.get(i));
                if (i < this.passengers.size() - 1){
                    System.out.print(", ");
                }
            }
            System.out.print("\n");  
        }
    }
}