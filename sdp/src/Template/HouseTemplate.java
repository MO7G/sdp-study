package Template;

// Abstract class defining the template method
public abstract class HouseTemplate {
    // Template method - defines the algorithm
    public final void buildHouse() {
        buildFoundation();
        buildPillars();
        buildWalls();
        buildWindows();
        System.out.println("House is built successfully!");
    }

    public final void buildFoundation() {
        System.out.println("Built Foundations");
    }

    // Abstract methods to be implemented by subclasses
    public abstract void buildPillars();
    public abstract void buildWalls();

    public final void buildWindows() {
        System.out.println("Built Windows");
    }
}
