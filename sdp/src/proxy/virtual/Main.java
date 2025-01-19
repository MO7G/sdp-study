package proxy.virtual;

// Step 1: Define a Subject Interface
interface Iimage {
    void display();
}

// Step 2: The Real Subject
class RealImage implements Iimage {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadImageFromDisk(); // Simulate an expensive operation
    }

    private void loadImageFromDisk() {
        System.out.println("Loading image from disk: " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + fileName);
    }
}

// Step 3: The Proxy
class ProxyImage implements Iimage {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        // Lazy initialization of the real object
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}

// Step 4: Client Code
public class Main {
    public static void main(String[] args) {
        // Proxy is created, but the RealImage isn't loaded yet
        Iimage image = new ProxyImage("sample_image.jpg");

        System.out.println("Image created. Now displaying it...");
        image.display(); // RealImage is loaded and displayed

        System.out.println("\nDisplaying the image again...");
        image.display(); // RealImage is reused; no need to reload
    }
}
