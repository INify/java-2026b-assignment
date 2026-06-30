public class Motorcycle extends Vehicle {
    private boolean hasCarrier;

    // Constructor
    public Motorcycle(String vehicleID, String model, String brand, double engineCapacity, boolean hasCarrier) {
        super(vehicleID, model, brand, engineCapacity);
        this.hasCarrier = hasCarrier;
    }

    // Getter and Setter
    public boolean isHasCarrier() {
        return hasCarrier;
    }

    public void setHasCarrier(boolean hasCarrier) {
        this.hasCarrier = hasCarrier;
    }

    // Override displayInfo
    @Override
    public String displayInfo() {
        return super.displayInfo() + "\n" +
               "Has Carrier: " + (hasCarrier ? "Yes" : "No");
    }
}