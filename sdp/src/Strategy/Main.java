package Strategy;

// Strategy Interface
interface IDriveStrategy {
    public void drive();
}

// Concrete Strategy 1
class LowSpeedStrategy implements IDriveStrategy {
    public void drive() {
        System.out.println("Low speed drive");
    }
}

// Concrete Strategy 2
class MediumSpeedStrategy implements IDriveStrategy {
    public void drive() {
        System.out.println("Medium speed drive");
    }
}

// Concrete Strategy 3
class HighSpeedStrategy implements IDriveStrategy {
    public void drive() {
        System.out.println("High speed drive");
    }
}

// Context Class
class CarContext {
    private IDriveStrategy driveStrategy;

    public void setStrategy(IDriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public void drive() {
        if (driveStrategy != null) {
            this.driveStrategy.drive();
        }
    }
}

// Main Function
public class Main {
    public static void main(String[] args) {
        CarContext car = new CarContext();

        car.setStrategy(new LowSpeedStrategy());
        car.drive();

        car.setStrategy(new MediumSpeedStrategy());
        car.drive();

        car.setStrategy(new HighSpeedStrategy());
        car.drive();
    }
}
