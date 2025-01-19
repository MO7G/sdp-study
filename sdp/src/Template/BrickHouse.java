package Template;

// Concrete implementation of the template for Brick Houses
public class BrickHouse extends HouseTemplate {
    @Override
    public void buildPillars() {
        System.out.println("Built Brick Pillars");
    }

    @Override
    public void buildWalls() {
        System.out.println("Built Brick Walls");
    }
}
