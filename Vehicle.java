public class Vehicle {
    private String vehicleID;
    private String model;
    private String brand;
    private double engineCapacity;

    // Constructor
    public Vehicle(String vehicleID, String model, String brand, double engineCapacity) {
        this.vehicleID = vehicleID;
        this.model = model;
        this.brand = brand;
        this.engineCapacity = engineCapacity;
    }

    // Getters and Setters
    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    // displayInfo method
    public String displayInfo() {
        return "Vehicle ID: " + vehicleID + "\n" +
               "Model: " + model + "\n" +
               "Brand: " + brand + "\n" +
               "Engine Capacity: " + engineCapacity + " CC";
    }
}