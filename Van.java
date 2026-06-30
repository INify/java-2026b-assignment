public class Van extends Vehicle {
    private double loadCapacity;

    // Constructor
    public Van(String vehicleID, String model, String brand, double engineCapacity, double loadCapacity) {
        super(vehicleID, model, brand, engineCapacity);
        this.loadCapacity = loadCapacity;
    }

    // Getter and Setter
    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    // Override displayInfo
    @Override
    public String displayInfo() {
        return super.displayInfo() + "\n" +
               "Load Capacity: " + loadCapacity + " kg";
    }
}