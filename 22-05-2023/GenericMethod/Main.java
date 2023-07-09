package GenericMethod;


class InvalidSubscriptException extends Exception {
    String errorMessage;

    InvalidSubscriptException( String errorMessage ) {
        this.errorMessage = errorMessage;
    }
}

public class Main {
    
    public static <T> void printArray ( T[] array, int lowSubscript, int highSubscript ) throws InvalidSubscriptException {
        int arrayLength = array.length;
        if ( lowSubscript > arrayLength || highSubscript > arrayLength )
            throw new InvalidSubscriptException("Index out of range!");

        for ( int i=lowSubscript; i<highSubscript; i++ ) {
            System.out.print( array[i] + "\t");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        
        try {
            printArray( new Integer[] { 65, 34, 65, 34 }, 2, 4);
        } catch (InvalidSubscriptException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
