# Java 2026B Assignment - Vehicle Management System

A Java-based object-oriented programming project demonstrating inheritance through a vehicle management system.

## Project Structure

```
├── Vehicle.java      # Base class for all vehicles
├── Car.java          # Car subclass (extends Vehicle)
├── Motorcycle.java   # Motorcycle subclass (extends Vehicle)
├── Van.java          # Van subclass (extends Vehicle)
└── README.md
```

## Classes Overview

### Vehicle (Base Class)
- **Fields:** `vehicleID`, `model`, `brand`, `engineCapacity`
- **Methods:**
  - Constructor with all fields
  - Getters and setters for all fields
  - `displayInfo()` - returns formatted vehicle details

### Car (extends Vehicle)
- **Additional Field:** `numberOfDoors`
- Overrides `displayInfo()` to include door count

### Motorcycle (extends Vehicle)
- **Additional Field:** `hasCarrier`
- Overrides `displayInfo()` to include carrier status

### Van (extends Vehicle)
- **Additional Field:** `loadCapacity`
- Overrides `displayInfo()` to include load capacity in kg

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
javac Vehicle.java Car.java Motorcycle.java Van.java
```

### Usage
Each class can be instantiated with its respective parameters. Create a main class to test the functionality:

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

## Author

[INify](https://github.com/INify)