package decorator;

// Component Interface
interface Coffee {
    String getDescription();
    double getCost();
}

// ConcreteComponent
class BasicCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Basic Coffee";
    }

    @Override
    public double getCost() {
        return 2.0; // Base price of coffee
    }
}

// Decorator Abstract Class
abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee; // Reference to a Coffee object

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription(); // Delegate to the wrapped coffee
    }

    @Override
    public double getCost() {
        return coffee.getCost(); // Delegate to the wrapped coffee
    }
}

// ConcreteDecoratorA
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 0.5; // Add the cost of milk
    }
}

// ConcreteDecoratorB
class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 0.2; // Add the cost of sugar
    }
}

// ConcreteDecoratorC
class WhippedCreamDecorator extends CoffeeDecorator {
    public WhippedCreamDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Whipped Cream";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 0.7; // Add the cost of whipped cream
    }
}

// Client Code
public class Main {
    public static void main(String[] args) {
        // Start with a Basic Coffee
        Coffee myCoffee = new BasicCoffee();
        System.out.println(myCoffee.getDescription() + " = $" + myCoffee.getCost());

        // Add Milk
        myCoffee = new MilkDecorator(myCoffee);
        System.out.println(myCoffee.getDescription() + " = $" + myCoffee.getCost());

        // Add Sugar
        myCoffee = new SugarDecorator(myCoffee);
        System.out.println(myCoffee.getDescription() + " = $" + myCoffee.getCost());

        // Add Whipped Cream
        myCoffee = new WhippedCreamDecorator(myCoffee);
        System.out.println(myCoffee.getDescription() + " = $" + myCoffee.getCost());
    }
}
