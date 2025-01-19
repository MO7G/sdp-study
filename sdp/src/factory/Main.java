package factory;

// Product Interface
interface Shape {
    void draw();
}

// Concrete Product 1
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

// Concrete Product 2
class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

// Concrete Product 3
class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

// Factory Class
class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        switch (shapeType.toLowerCase()) {
            case "circle":
                return new Circle();
            case "rectangle":
                return new Rectangle();
            case "square":
                return new Square();
            default:
                return null;
        }
    }
}

// Client Code
public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        // Get and use different shapes
        Shape shape1 = shapeFactory.getShape("circle");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("rectangle");
        shape2.draw();

        Shape shape3 = shapeFactory.getShape("square");
        shape3.draw();
    }
}
