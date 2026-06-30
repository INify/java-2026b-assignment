public class TestPhase2 {
    public static void main(String[] args) {
        VehicleManager manager = new VehicleManager();

        // Create two Car objects with the same model name
        Car car1 = new Car("C001", "Civic", "Honda", 1.8, 4);
        Car car2 = new Car("C002", "Civic", "Honda", 2.0, 2);

        // Add first car and print result
        boolean firstAdd = manager.addVehicle(car1);
        System.out.println("First addVehicle (Civic): " + firstAdd);

        // Add second car (duplicate model) and print result (should be false)
        boolean secondAdd = manager.addVehicle(car2);
        System.out.println("Second addVehicle (Civic): " + secondAdd);

        // Create a Motorcycle with model 'Ninja' and add it
        Motorcycle motorcycle = new Motorcycle("M001", "Ninja", "Kawasaki", 0.6, true);
        manager.addVehicle(motorcycle);

        // Call searchCar('Civic') and print the result's displayInfo()
        Car foundCar = manager.searchCar("Civic");
        System.out.println("\nSearch Car 'Civic':");
        if (foundCar != null) {
            System.out.println(foundCar.displayInfo());
        } else {
            System.out.println("null");
        }

        // Call searchCar('Ninja') and print the result (should be null)
        Car foundNinja = manager.searchCar("Ninja");
        System.out.println("\nSearch Car 'Ninja':");
        if (foundNinja != null) {
            System.out.println(foundNinja.displayInfo());
        } else {
            System.out.println("null");
        }

        // Call displayAllVehicles() and print the full output
        System.out.println("\nAll Vehicles:");
        System.out.println(manager.displayAllVehicles());
    }
}