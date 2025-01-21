package proxy.Protection;// ProtectionProxyExample.java

// Step 1: Define the Subject Interface
interface Service {
    void performAction();
}

// Step 2: Implement the RealService (Actual Service)
class RealService implements Service {
    @Override
    public void performAction() {
        System.out.println("Real service is performing a sensitive action!");
    }
}

// Step 3: Implement the Proxy Class (Protection Proxy)
class ProxyService implements Service {
    private RealService realService;
    private String userRole;

    // Constructor takes the user role to simulate access control
    public ProxyService(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public void performAction() {
        if (userRole.equals("admin")) {
            // Only allow access if the user is an admin
            if (realService == null) {
                realService = new RealService();
            }
            realService.performAction(); // Forward the call to the real service
        } else {
            System.out.println("Access Denied: You do not have permission to perform this action.");
        }
    }
}

// Step 4: Using the Proxy in Client Code
public class Main {
    public static void main(String[] args) {
        // Create proxy with different roles
        Service adminService = new ProxyService("admin");
        Service userService = new ProxyService("user");

        // Test with admin role - should be allowed
        System.out.println("Testing with admin:");
        adminService.performAction();  // Should call RealService

        // Test with user role - should be denied
        System.out.println("\nTesting with user:");
        userService.performAction();   // Should deny access
    }
}
