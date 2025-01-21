package proxy.remote;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;




// The Remote Object Implementation
class Adder extends UnicastRemoteObject implements IRemote {

    // Constructor for Adder, calls the super constructor of UnicastRemoteObject
    Adder() throws RemoteException {
        super(); // Required for exporting the remote object
    }

    // Implementation of the remote method `add` declared in the IRemote interface
    @Override
    public int add(int a, int b) {
        return a + b; // Returns the sum of two numbers
    }
}



// The Server Class
public class RemoteServer {
    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
        try {
            // Step 1: Create the RMI registry on port 5555
            Registry registry = LocateRegistry.createRegistry(5555);

            // Step 2: Create a new instance of the Adder object
            Adder adder = new Adder();

            // Step 3: Bind the Adder object to the name "add" in the RMI registry
            registry.rebind("add", adder);

            // Print a success message
            System.out.println("Remote Adder Server is up and running on port 5555!");
        } catch (Exception e) {
            // Print any exceptions that occur during the setup
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace(); // Print detailed stack trace for debugging
        }
    }
}
