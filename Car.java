public class Car extends Vehicle {
    private int numberOfDoors;

    // Constructor
    public Car(String vehicleID, String model, String brand, double engineCapacity, int numberOfDoors) {
        super(vehicleID, model, brand, engineCapacity);
        this.numberOfDoors = numberOfDoors;
    }

    // Getter and Setter
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    // Override displayInfo
    @Override
    public String displayInfo() {
        return super.displayInfo() + "\n" +
               "Number of Doors: " + numberOfDoors;
    }
}