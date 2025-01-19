package Template;

// Main class to demonstrate the Template Design Pattern
public class Main {
    public static void main(String[] args) {
        // Build a brick house
        HouseTemplate house = new BrickHouse();
        house.buildHouse();

        System.out.println();

        // Build a wooden house
        house = new WoodenHouse();
        house.buildHouse();
    }
}
