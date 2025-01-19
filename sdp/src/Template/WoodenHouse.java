package Template;

// Concrete implementation of the template for Wooden Houses
public class WoodenHouse extends HouseTemplate {
    @Override
    public void buildPillars() {
        System.out.println("Built Wooden Pillars");
    }

    @Override
    public void buildWalls() {
        System.out.println("Built Wooden Walls");
    }
}
