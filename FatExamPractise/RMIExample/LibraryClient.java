package RMIExample;

import java.rmi.Naming;

public class LibraryClient {
    public static void main(String[] args) {
        try {
            // Lookup the remote object by name
            LibraryService libraryService = (LibraryService) Naming.lookup("rmi://localhost/LibraryService");

            // Invoke remote methods
            libraryService.addBook("Book1");
            libraryService.addBook("Book2");

            libraryService.borrowBook("Book1");
            libraryService.borrowBook("Book2");

            libraryService.returnBook("Book1");
            libraryService.returnBook("Book2");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}