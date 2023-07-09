//! Server.java
package RMIExamplePractise;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.*;


interface LibraryService extends Remote {
    public void borrowBook() throws RemoteException;
    public void returnBook() throws RemoteException;
}

class LibraryServiceImpl extends UnicastRemoteObject implements LibraryService {

    public LibraryServiceImpl() throws RemoteException {
        super();
    }

    public void borrowBook() throws RemoteException {
        System.out.println("borrowBook");
    }

    public void returnBook() throws RemoteException {
        System.out.println("returnBook");
    }
}

public class Server {
    public static void main(String[] args) {
        try {
            LibraryService librarySvc = new LibraryServiceImpl();

            LocateRegistry.createRegistry(1098);

            Naming.rebind("LibraryService", librarySvc);

            System.out.println("Server is ready");

        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }
}
