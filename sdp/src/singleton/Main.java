package singleton;

// Singleton class
 class Singleton {
    // Private static instance of the class (volatile for thread safety)
    private static volatile Singleton instance;

    // Private constructor to prevent instantiation
    private Singleton() {
        // Prevent instantiation via reflection
        if (instance != null) {
            throw new IllegalStateException("Instance already created");
        }
    }

    // Public static method to provide global access to the instance
    public static Singleton getInstance() {
        if (instance == null) { // Check if instance is null
            synchronized (Singleton.class) { // Synchronize to make thread-safe
                if (instance == null) { // Double-check locking
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // Example method
    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}

// Main class to test Singleton
public class Main {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        singleton1.showMessage();

        // Verify that both references point to the same instance
        System.out.println(singleton1 == singleton2); // Should print true
    }
}
