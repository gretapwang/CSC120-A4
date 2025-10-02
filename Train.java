import java.util.ArrayList;

/**
 * Train with an engine and cars
 * @author Greta Wang
 * @version 10/2/2025
 */
public class Train implements TrainRequirements {
    
    private Engine engine;
    private ArrayList<Car> cars;

    /**
     * Constructor
     * @param fuelType FuelType for the Train's Engine
     * @param currentFuelLevel Current fuel in Engine
     * @param fuelCapacity Engine's max fuel capacity
     * @param nCars Number of Cars in Train
     * @param passengerCapacity Capacity of each Car
     */
    public Train(FuelType fuelType, double currentFuelLevel, double fuelCapacity, int nCars, int passengerCapacity){
        this.engine = new Engine(fuelType, currentFuelLevel, fuelCapacity);
        this.cars = new ArrayList<Car>(nCars);
        for (int i = 0; i < nCars; i++){
            this.cars.add(new Car(passengerCapacity));
        }
    }
    
    /**
     * Accessor for engine
     * @return Train's Engine
     */
    public Engine getEngine(){
        return this.engine;
    }

    /**
     * Returns the Car at a given number
     * @param i Number of desired Car
     * @return Car number i in list of Cars
     */
    public Car getCar(int i){
       return this.cars.get(i); 
    }

    /**
     * Returns total capacity of Train
     * @return Passenger capacity across all Cars
     */
    public int getMaxCapacity(){
        return this.cars.size() * this.getCar(0).getCapacity();
    }

    /**
     * Returns number of empty seats on Train
     * @return Total empty seats across all Cars
     */
    public int seatsRemaining(){
        int emptySeats = 0;
        for (int i = 0; i < this.cars.size(); i++){
            emptySeats += this.getCar(i).seatsRemaining();
        }
        return emptySeats;
    }

    /**
     * Prints roster of Passengers
     */
    public void printManifest(){
        for (int i = 0; i < this.cars.size(); i++){
            System.out.print("Car " + i + ": ");
            this.getCar(i).printManifest();
        }
    }

    /**
     * Tests functionality of Train, Car, Engine, and Passenger classes
     */
    public static void main(String[] args){

        // Initialize train
        Train train = new Train(FuelType.STEAM, 50, 100, 5, 2);
        System.out.println("Engine info: fuel type " + train.getEngine().getFuelType() + ", current fuel " + train.getEngine().getCurrentFuel() + ", max fuel " + train.getEngine().getMaxFuel());
        System.out.println("The max capacity of this train is " + train.getMaxCapacity());
        
        // Test fuel usage
        while (train.getEngine().go()) {
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel.");
        train.getEngine().refuel();
        System.out.println("Refueled: fuel now at " + train.getEngine().getCurrentFuel());

        // Initialize and board passengers
        Passenger greta = new Passenger("Greta");
        Passenger meilin = new Passenger("Meilin");
        Passenger kayla = new Passenger("Kayla");
        greta.boardCar(train.getCar(0));
        meilin.boardCar(train.getCar(0));
        kayla.boardCar(train.getCar(1));
        kayla.getOffCar(train.getCar(1));
        kayla.boardCar(train.getCar(2));

        // Print rosters
        System.out.println("Printing roster for car 0:");
        train.getCar(0).printManifest();
        System.out.println("Printing roster for full train:");
        train.printManifest();

        // Test seat availablility
        System.out.println("The train has " + train.seatsRemaining() + " seats available.");
        System.out.println("Car 0 has " + train.getCar(0).seatsRemaining() + " seats available.");

        // Test errors when boarding/leaving
        kayla.boardCar(train.getCar(0));
        kayla.getOffCar(train.getCar(0));


    }
}
