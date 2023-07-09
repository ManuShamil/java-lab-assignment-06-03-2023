//! Client.java

package RMIExamplePractise;

import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        try {
            LibraryService librarySvc = (LibraryService) Naming.lookup("rmi://localhost/LibraryService");

            librarySvc.borrowBook();
            librarySvc.returnBook();

        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }
}
