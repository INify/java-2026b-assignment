import java.util.ArrayList;

public class VehicleManager {
    private ArrayList<Vehicle> vehicles;

    // Constructor
    public VehicleManager() {
        vehicles = new ArrayList<>();
    }

    // Method addVehicle: Check for duplicate model names (case-insensitive)
    public boolean addVehicle(Vehicle v) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getModel().equalsIgnoreCase(v.getModel())) {
                return false; // Duplicate model found
            }
        }
        vehicles.add(v);
        return true;
    }

    // Method searchCar: Search for a Car object matching the exact model string (case-insensitive)
    public Car searchCar(String model) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Car && vehicle.getModel().equalsIgnoreCase(model)) {
                return (Car) vehicle;
            }
        }
        return null;
    }

    // Method displayAllVehicles: Return concatenated displayInfo() results or "No vehicles registered."
    public String displayAllVehicles() {
        if (vehicles.isEmpty()) {
            return "No vehicles registered.";
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < vehicles.size(); i++) {
            result.append(vehicles.get(i).displayInfo());
            if (i < vehicles.size() - 1) {
                result.append("\n");
            }
        }
        return result.toString();
    }
}