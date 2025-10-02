/**
 * Train engine with fuel type and current/max fuel levels
 * @author Greta Wang
 * @version 10/2/2025
 */
public class Engine implements EngineRequirements {
    
    private FuelType fuelType;
    private double currentFuel;
    private double maxFuel;


    /**
     * Constructor
     * @param fuelType Type of fuel for the Engine
     * @param currentFuel Current fuel level
     * @param maxFuel Maximum fuel capacity
     */
    public Engine(FuelType fuelType, double currentFuel, double maxFuel){
        this.fuelType = fuelType;
        this.currentFuel = currentFuel;
        this.maxFuel = maxFuel;
    }
    
    /**
     * Accessor for fuelType
     * @return FuelType of the Engine
     */
    public FuelType getFuelType(){
        return this.fuelType;
    } 

    /**
     * Accessor for maxFuel
     * @return Max fuel capacity as a double
     */
    public double getMaxFuel(){
        return this.maxFuel;
    }

    /**
     * Accessor for currentFuel
     * @return Current fuel level as a double
     */
    public double getCurrentFuel(){
        return this.currentFuel;
    }

    /**
     * Sets fuel level at maximum
     */
    public void refuel(){
        this.currentFuel = this.maxFuel;
    } 

    /**
     * Decreases fuel level by 20, prints remaining fuel level, returns true if there is fuel remaining and false otherwise
     * @return true if remaining fuel is positive, false otherwise
     */
    public Boolean go(){
        this.currentFuel -= 20;
        System.out.println("Remaining fuel: " + this.currentFuel);
        return this.currentFuel > 0;
    }
}