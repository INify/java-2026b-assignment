public class TestPhase1 {
    public static void main(String[] args) {
        Car car = new Car("C001", "Civic", "Honda", 1500.0, 4);
        Motorcycle motorcycle = new Motorcycle("M001", "Ninja", "Kawasaki", 650.0, true);
        Van van = new Van("V001", "Transit", "Ford", 2000.0, 1200.0);

        System.out.println("=== Car Info ===");
        System.out.println(car.displayInfo());
        System.out.println();

        System.out.println("=== Motorcycle Info ===");
        System.out.println(motorcycle.displayInfo());
        System.out.println();

        System.out.println("=== Van Info ===");
        System.out.println(van.displayInfo());
    }
}