# Java 2026B Assignment - Vehicle Management System

A Java-based object-oriented programming project demonstrating inheritance through a vehicle management system. Includes both CLI test classes and a full Swing-based graphical user interface.

## Project Structure

```
├── Vehicle.java          # Base class for all vehicles
├── Car.java              # Car subclass (extends Vehicle)
├── Motorcycle.java       # Motorcycle subclass (extends Vehicle)
├── Van.java              # Van subclass (extends Vehicle)
├── VehicleManager.java   # Manages vehicle collection with duplicate detection
├── MainGUI.java          # Swing-based graphical user interface
├── TestPhase1.java       # CLI test for vehicle class instantiation and display
├── TestPhase2.java       # CLI test for VehicleManager functionality
└── README.md
```

## Classes Overview

### Vehicle (Base Class)
- **Fields:** `vehicleID`, `model`, `brand`, `engineCapacity`
- **Methods:**
  - Constructor with all fields
  - Getters and setters for all fields
  - `displayInfo()` – returns formatted vehicle details

### Car (extends Vehicle)
- **Additional Field:** `numberOfDoors`
- Overrides `displayInfo()` to include door count

### Motorcycle (extends Vehicle)
- **Additional Field:** `hasCarrier`
- Overrides `displayInfo()` to include carrier status

### Van (extends Vehicle)
- **Additional Field:** `loadCapacity`
- Overrides `displayInfo()` to include load capacity in kg

### VehicleManager
- Maintains an `ArrayList<Vehicle>` of registered vehicles
- `addVehicle(Vehicle v)` – adds a vehicle only if no duplicate model name exists (case-insensitive check); returns `false` on duplicate
- `searchCar(String model)` – searches for a `Car` by exact model (case-insensitive); returns `null` if not found
- `displayAllVehicles()` – returns a concatenated string of all vehicles' `displayInfo()` output, or `"No vehicles registered."`

### MainGUI (Swing GUI)
A graphical interface for interacting with the system:

| Feature | Description |
|---------|-------------|
| Vehicle Registration Form | Input fields for vehicle ID, model, brand, engine capacity, and type-specific fields |
| Dynamic Field Visibility | Fields change based on selected vehicle type (doors for Car, carrier for Motorcycle, load capacity for Van) |
| Add Vehicle | Validates input, detects duplicate models, and registers the vehicle |
| Search Car | Prompts for a model name and displays matching car info |
| Display All | Lists all registered vehicles in the output area |
| Validation | Enforces non-empty fields and correct numeric formats with error dialogs |

## Inheritance Hierarchy

```
        Vehicle
       /   |   \
     Car  Motorcycle  Van
```

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher

### Compilation
```bash
javac *.java
```

### Running the GUI
```bash
java MainGUI
```

### Running CLI Tests
```bash
java TestPhase1    # Tests vehicle class creation and displayInfo()
java TestPhase2    # Tests VehicleManager addVehicle, searchCar, and displayAllVehicles
```

### CLI Usage Example
```java
public class Main {
    public static void main(String[] args) {
        Car car = new Car("V001", "Civic", "Honda", 1500.0, 4);
        System.out.println(car.displayInfo());
    }
}
```

## Features
- Object-oriented design with inheritance
- Encapsulation using private fields with public getters/setters
- Method overriding (`displayInfo()`)
- `super` keyword usage for parent constructor and method calls
- Polymorphic collection management via `VehicleManager`
- Duplicate model detection (case-insensitive)
- Search functionality for `Car` objects by model
- Full Swing GUI with dynamic form fields based on vehicle type
- Input validation with user-friendly error messages

## Author

[INify](https://github.com/INify)