package proxy.Protection;

// Step 1: Define a common interface
interface ISensitiveDataAccess {
    void accessData(String userRole);
}

// Step 2: The Real Subject
class SensitiveData implements ISensitiveDataAccess {
    @Override
    public void accessData(String userRole) {
        System.out.println("Accessing sensitive data...");
    }
}

// Step 3: The Proxy
class SensitiveDataProxy implements ISensitiveDataAccess {
    private SensitiveData realSensitiveData;

    public SensitiveDataProxy() {
        // Lazy initialization of the real object
        this.realSensitiveData = new SensitiveData();
    }

    @Override
    public void accessData(String userRole) {
        // Protection logic
        if ("ADMIN".equalsIgnoreCase(userRole)) {
            realSensitiveData.accessData(userRole);
            System.out.println("Access granted to ADMIN.");
        } else {
            System.out.println("Access denied! Only admins are allowed to access this data.");
        }
    }
}

// Step 4: Client Code
public class Main {
    public static void main(String[] args) {
        ISensitiveDataAccess proxy = new SensitiveDataProxy();

        // Access as a regular user
        System.out.println("Trying to access as a USER:");
        proxy.accessData("USER");

        // Access as an admin
        System.out.println("\nTrying to access as an ADMIN:");
        proxy.accessData("ADMIN");
    }
}
