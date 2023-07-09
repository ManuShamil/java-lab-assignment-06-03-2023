package RMIExample;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

interface LibraryService extends Remote {
    void addBook(String bookName) throws RemoteException;
    boolean borrowBook(String bookName) throws RemoteException;
    boolean returnBook(String bookName) throws RemoteException;
}

class LibraryServiceImpl extends UnicastRemoteObject implements LibraryService {
    private Map<String, Boolean> books;

    public LibraryServiceImpl() throws RemoteException {
        books = new HashMap<>();
    }

    public void addBook(String bookName) throws RemoteException {
        books.put(bookName, true);
        System.out.println("Added book: " + bookName);
    }

    public boolean borrowBook(String bookName) throws RemoteException {
        if (books.containsKey(bookName) && books.get(bookName)) {
            books.put(bookName, false);
            System.out.println("Borrowed book: " + bookName);
            return true;
        } else {
            System.out.println("Book is not available: " + bookName);
            return false;
        }
    }

    public boolean returnBook(String bookName) throws RemoteException {
        if (books.containsKey(bookName) && !books.get(bookName)) {
            books.put(bookName, true);
            System.out.println("Returned book: " + bookName);
            return true;
        } else {
            System.out.println("Book cannot be returned: " + bookName);
            return false;
        }
    }
}

public class LibraryServer {
    public static void main(String[] args) {
        try {
            // Create an instance of the remote object
            LibraryService libraryService = new LibraryServiceImpl();

            // Create and start the RMI registry on port 1099
            LocateRegistry.createRegistry(1098);

            // Bind the remote object to a name
            Naming.rebind("LibraryService", libraryService);

            System.out.println("Library server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
