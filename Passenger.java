/**
 * Train passenger with a name, can board and leave train cars
 * @author Greta Wang
 * @version 10/2/2025
 */
public class Passenger implements PassengerRequirements {
    
    private String name;

    /**
     * Constructor
     * @param name Passenger's name
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * Adds Passenger to a Car, or prints error message is Car is full
     * @param c Car to board
     */
    public void boardCar(Car c){
        if (c.addPassenger(this)){
            System.out.println(this + " has boarded!");
        }
        else {
            System.out.println("This car is full. " + this + " cannot board.");
        }
    }

    /**
     * Removes Passenger from a Car, or prints error message if Passenger was not aboard
     * @param c Car to get off of
     */
    public void getOffCar(Car c){
        if (c.removePassenger(this)){
            System.out.println(this + " has left the car.");
        }
        else {
            System.out.println(this + " was not aboard.");
        }
    }

    /**
     * Returns Passenger's name for printing
     * @return Name as a String
     */
    public String toString(){
        return this.name;
    }
}
